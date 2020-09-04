package com.yanping.manydb.manydb.test.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.yanping.manydb.manydb.test.entity.User;
import com.yanping.manydb.manydb.test.dao.UserDao;

@Service
public class UserService{

    @Resource
    private UserDao userDao;

    public int insert(User pojo){
        return userDao.insertSelective(pojo);
    }

}
