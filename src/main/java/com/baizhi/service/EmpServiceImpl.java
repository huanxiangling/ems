package com.baizhi.service;

import com.baizhi.dao.EmpDao;
import com.baizhi.entity.Emp;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public Map findPage(Integer page, Integer rows) {
        Map map = new HashMap();
        List<Emp> list = empDao.selectByRowBounds(new Emp(), new RowBounds((page - 1) * rows, rows));
        int count = empDao.selectCount(new Emp());
        Integer total = count % rows == 0 ? count / rows : count / rows + 1;
        map.put("rows", list);
        map.put("records", count);
        map.put("total", total);
        map.put("page", page);
        return map;
    }

    @Override
    public Map finOne(Emp emp) {
        Map map = new HashMap();
        Emp emp1 = empDao.selectByPrimaryKey(emp);
        map.put("status", 200);
        map.put("emp", emp1);
        return map;
    }

    @Override
    public Map save(Emp emp) {
        Map map = new HashMap();
        String id = UUID.randomUUID().toString().replace("-", "");
        emp.setId(id);
        empDao.insert(emp);
        map.put("status", 200);
        map.put("empId", id);
        return map;
    }

    @Override
    public Map delete(Emp emp) {
        Map map = new HashMap();
        empDao.delete(emp);
        map.put("status", 200);
        map.put("empId", emp.getId());
        return map;
    }

    @Override
    public Map update(Emp emp) {
        Map map = new HashMap();
        empDao.updateByPrimaryKeySelective(emp);
        map.put("status", 200);
        map.put("empId", emp.getId());
        return map;
    }

    @Override
    public Map findAllSearch(String searchField, String searchString, String searchOper, Integer page, Integer rows) {
        HashMap map = new HashMap();
        List<Emp> emps = empDao.findAllSearch(searchField, searchString, searchOper, (page - 1) * rows, rows);
        int records = empDao.findTotalCountsSearch(searchField, searchString, searchOper);
        int total = records % rows == 0 ? records / rows : records / rows + 1;
        map.put("rows", emps);
        map.put("records", records);
        map.put("total", total);
        map.put("page", page);
        return map;
    }
}
