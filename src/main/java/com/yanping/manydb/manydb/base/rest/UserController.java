package com.yanping.manydb.manydb.base.rest;

import com.yanping.manydb.manydb.test.service.UserService;
import com.yanping.manydb.manydb.utils.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version v1.0
 * @ProjectName: manydb
 * @ClassName: UserController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: Administrator
 * @Date: 2020/9/15 13:47
 */
@RestController
@RequestMapping("user")
@Api(tags = "导出测试")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation(value = "测试",produces = "application/octet-stream")
    public void test(String keys, HttpServletResponse response) {
        Workbook workbook = userService.getExcelEntities(keys);
        try {
            ExcelUtils.exportExcel(response, "ceshi", workbook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
