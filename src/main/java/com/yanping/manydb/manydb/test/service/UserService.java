package com.yanping.manydb.manydb.test.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yanping.manydb.manydb.test.entity.User;
import com.yanping.manydb.manydb.test.dao.UserDao;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public int insert(User pojo) {
        return userDao.insertSelective(pojo);
    }

    public Workbook getExcelEntities(String keys) {
        List<ExcelExportEntity> titleColums = new ArrayList<ExcelExportEntity>();
        List<Map<String, Object>> mapList = userDao.list(keys);
        for (Map.Entry<String, Object> entry : mapList.get(0).entrySet()) {
            System.out.println("key : " + entry.getKey() + " value : " + entry.getValue());
            titleColums.add(new ExcelExportEntity(entry.getKey(), entry.getKey()));
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("测试", "测试"), titleColums,
                mapList);

        return workbook;
    }

}
