package com.yanping.manydb.manydb.base.rest;

import com.yanping.manydb.manydb.base.entity.Depart;
import com.yanping.manydb.manydb.base.service.DepartService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @ProjectName: manydb
 * @ClassName: DepartController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: Administrator
 * @Date: 2020/9/4 10:07
 */
@RestController
@RequestMapping("depart")
@Api(tags = "try")
public class DepartController {

    @Autowired
    private DepartService departService;

    @GetMapping
    public String test(){
        Depart depart = new Depart();
        depart.setName("娱乐");
        departService.insert(depart);
        return "okokok";
    }



}
