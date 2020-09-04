package com.yanping.manydb.manydb.base.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.yanping.manydb.manydb.base.entity.Depart;
import tk.mybatis.mapper.common.Mapper;

public interface DepartDao extends Mapper<Depart> {


    int insertList(@Param("pojos") List<Depart> pojo);

}
