package com.yanping.manydb.manydb.test.dao;

import com.yanping.manydb.manydb.test.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao extends tk.mybatis.mapper.common.Mapper<User> {


    int insertList(@Param("pojos") List<User> pojo);

}
