package com.baizhi.dao;

import com.baizhi.entity.Emp;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EmpDao extends Mapper<Emp> {

    List<Emp> findAllSearch(
            @Param("searchField") String searchField, @Param("searchString") String searchString, @Param("searchOper") String searchOper, @Param("start") Integer start, @Param("rows") Integer rows);

    Integer findTotalCountsSearch(
            @Param("searchField") String searchField, @Param("searchString") String searchString, @Param("searchOper") String searchOper);
}
