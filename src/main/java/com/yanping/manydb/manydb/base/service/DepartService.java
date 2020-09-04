package com.yanping.manydb.manydb.base.service;

import com.yanping.manydb.manydb.test.entity.User;
import com.yanping.manydb.manydb.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.yanping.manydb.manydb.base.entity.Depart;
import com.yanping.manydb.manydb.base.dao.DepartDao;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartService {

    @Resource
    private DepartDao departDao;

    @Autowired
    private UserService userService;

    public int insert(Depart pojo) {
        userService.insert(new User("严平", "123456"));
        return departDao.insert(pojo);
    }

    public int insertSelective(Depart pojo) {
        return departDao.insertSelective(pojo);
    }

    public int insertList(List<Depart> pojos) {
        return departDao.insertList(pojos);
    }

    public int update(Depart pojo) {
        return departDao.updateByPrimaryKeySelective(pojo);
    }
}
