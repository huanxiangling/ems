package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Map findOne(User user) {
        Map map = new HashMap();
        User one = userDao.selectOne(user);
        if (one != null) {
            map.put("status", 200);
            map.put("user", one);
        } else {
            map.put("status", -200);
            map.put("message", "账号密码错误");
        }

        return map;
    }
}
