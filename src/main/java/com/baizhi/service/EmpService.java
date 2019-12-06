package com.baizhi.service;

import com.baizhi.entity.Emp;

import java.util.Map;

public interface EmpService {
    Map findPage(Integer page, Integer rows);

    Map finOne(Emp emp);

    Map save(Emp emp);

    Map delete(Emp emp);

    Map update(Emp emp);
}
