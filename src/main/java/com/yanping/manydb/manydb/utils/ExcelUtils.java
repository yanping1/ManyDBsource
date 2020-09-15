package com.yanping.manydb.manydb.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.excel.export.ExcelExportService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * excel工具类
 */
public class ExcelUtils {


    private static final int ROW = 100000;

    public static <T> ExcelImportResult<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass, String dictTableMetaId) {
        if (file == null || file.isEmpty()) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        params.setNeedVerfiy(true);
        ExcelImportResult<T> result = null;
        try {
            result = ExcelImportUtil.importExcelMore(file.getInputStream(), pojoClass, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * Excel导出
     *
     * @param response  response
     * @param fileName  文件名
     * @param list      数据List
     * @param pojoClass 对象Class
     */
    public static void exportExcel(HttpServletResponse response, String fileName, Collection<?> list,
                                   Class<?> pojoClass) throws IOException {
        if (StringUtils.isBlank(fileName)) {
            //当前日期
            fileName = String.valueOf(System.currentTimeMillis());
        }
        // 定义标题和sheet名称
        ExportParams exportParams = new ExportParams(fileName, fileName);
        exportParams.setType(ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
        ServletOutputStream out = response.getOutputStream();
        workbook.write(out);
        out.flush();
    }

    /**
     * Excel导出，先sourceList转换成List<targetClass>，再导出
     *
     * @param response    response
     * @param fileName    文件名
     * @param sourceList  原数据List
     * @param targetClass 目标对象Class
     */
    public static void exportExcelToTarget(HttpServletResponse response, String fileName, Collection<?> sourceList,
                                           Class<?> targetClass) throws Exception {
        List targetList = new ArrayList<>(sourceList.size());
        for (Object source : sourceList) {
            Object target = targetClass.newInstance();
            BeanUtils.copyProperties(source, target);
            targetList.add(target);
        }

        exportExcel(response, fileName, targetList, targetClass);
    }

    /**
     * 一个excel 创建多个sheet
     *
     * @param list 多个Map key title 对应表格Title key entity 对应表格对应实体 key data
     *             Collection 数据
     * @return
     */
    public static Workbook exportExcelBySheets(List<Map<String, Object>> list, ExcelType type) {
        Workbook workbook = getWorkbook(type, 0);
        for (Map<String, Object> map : list) {
            ExcelExportService service = new ExcelExportService();
            service.createSheet(workbook, (ExportParams) map.get("title"),
                    (Class<?>) map.get("entity"), (Collection<?>) map.get("data"));
        }
        return workbook;
    }

    private static Workbook getWorkbook(ExcelType type, int size) {
        if (ExcelType.HSSF.equals(type)) {
            return new HSSFWorkbook();
        } else if (size < ROW) {
            return new XSSFWorkbook();
        } else {
            return new SXSSFWorkbook();
        }
    }

    /**
     * 文件导出
     *
     * @param response
     * @param fileName
     * @param workbook
     * @throws IOException
     */
    public static void exportExcel(HttpServletResponse response, String fileName, Workbook workbook) throws IOException {
        if (StringUtils.isBlank(fileName)) {
            //当前日期
            fileName = String.valueOf(System.currentTimeMillis());
        }
        // 定义标题和sheet名称
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
        ServletOutputStream out = response.getOutputStream();
        workbook.write(out);
        out.flush();
    }


}
