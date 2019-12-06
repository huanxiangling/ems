package com.baizhi.controller;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("findAll")
    public Map findAll(String searchField, String searchString, String searchOper, Boolean _search, Integer page, Integer rows) {
        if (_search) {
            return empService.findAllSearch(searchField, searchString, searchOper, page, rows);
        } else {
            return empService.findPage(page, rows);
        }
    }

    @RequestMapping("change")
    public Map change(String oper, Emp emp) {
        Map map = new HashMap();
        if ("add".equals(oper)) {
            return map = empService.save(emp);
        } else if ("edit".equals(oper)) {
            return map = empService.update(emp);
        } else {
            return map = empService.delete(emp);
        }
    }
}
