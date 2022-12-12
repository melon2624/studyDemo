package com.zx.util;

import org.apache.poi.hssf.usermodel.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: cst-ump
 * @description: 导出数据列表根据类
 * @author: luo
 * @create: 2019-07-29 20:40
 **/
public class ExcelImportHelper {

    private ExcelExportHelper excelExportHelper = new ExcelExportHelper();


    /**
     * 导出数据列表
     *
     * @param header
     * @param excelList
     * @param sheetTitle
     * @param fileName
     * @param outputStream
     */
    public void exportExcel(String[] header, List<String[]> excelList, String sheetTitle, String fileName, OutputStream outputStream) throws IOException {
        //生成Excel
        HSSFWorkbook book = exportExcelL(header, excelList, sheetTitle);
        //保存生成的Excel
        book.write(outputStream);
    }

    public HSSFWorkbook exportExcel(String[] header, List<String[]> excelList, String sheetTitle, String filePath, String fileName) {
        //生成Excel
        HSSFWorkbook book = exportExcelL(header, excelList, sheetTitle);
        //保存生成的Excel
         excelExportHelper.saveExcel(book, filePath, fileName);
        return book;
    }

    /**
     * 生成表格
     *
     * @param header
     * @param excelList
     * @param sheetTitle
     * @return
     */
    public HSSFWorkbook exportExcelL(String[] header, List<String[]> excelList,
                                     String sheetTitle) {
        //生成一个Excel
        HSSFWorkbook book = new HSSFWorkbook();
        // 生成一个表格
        sheetTitle = excelExportHelper.getSheetTitle(sheetTitle); // 判断、设置sheetTitle
        //每5万个数据做一次分页
        int pageNum = 50000;
        int sheetNum = excelList.size() / pageNum;
        for (int j = 0; j <= sheetNum; j++) {
            HSSFSheet sheet = book.createSheet(sheetTitle + (j + 1));
            // 设置列宽  （第几列，宽度）
            for (int i = 0; i < header.length; i++) {
                sheet.setColumnWidth(i, sheet.getColumnWidth(i) * 2);
            }

            List<String[]> newList = new ArrayList<>();
            newList.addAll(excelList.subList(j * pageNum, Math.min((j + 1) * pageNum, excelList.size())));
            // 设置Excel里面数据
            setExcelContentData(book, sheet, header, newList);
        }

        System.out.println("——————————————————ExcelExportHelper:Excel生成成功...");
        return book;
    }


    /**
     * 表格填充数据
     *
     * @param book
     * @param sheet
     * @param header
     * @param excelList
     */
    private void setExcelContentData(HSSFWorkbook book, HSSFSheet sheet, String[] header, List<String[]> excelList) {
        //设置列头样式(居中、变粗)
        HSSFCellStyle headerStyle = book.createCellStyle();
        excelExportHelper.setHeaderStyle(headerStyle, book);

        // 设置单元格样式
        HSSFCellStyle cellStyle = book.createCellStyle();
        excelExportHelper.setCellStyle(cellStyle, book);

        // 创建头部
        HSSFRow row = excelExportHelper.createHeader(sheet, headerStyle, header);
        for (int i = 0; i < excelList.size(); i++) {
            String[] field = excelList.get(i);
            HSSFRow dataRow = sheet.createRow(i + 1);
            for (int j = 0; j < header.length; j++) {
                HSSFCell cell = dataRow.createCell(j);
                cell.setCellStyle(cellStyle);
                if (ObjectUtils.isEmpty(field[j])) {
                    cell.setCellValue("");
                } else {
                    cell.setCellValue(field[j]);
                }
            }
        }
        System.out.println("——————————————————填充Excel数据成功..........");
    }


    /**
     * 导出数据列表
     *
     * @param filePath
     * @param fileName
     */
    public void exportExcel(HSSFWorkbook book, String filePath, String fileName) {
        //保存生成的Excel
        excelExportHelper.saveExcel(book, filePath, fileName);

    }

    /**
     * 生成固定列宽的表格
     *
     * @param header
     * @param excelList
     * @param sheetTitle
     * @param filePath
     * @param fileName
     */
    public void exportExcelS(String[] header, Integer[] sheetWidth, List<String[]> excelList, String sheetTitle, String filePath, String fileName) {
        //生成Excel
        //生成一个Excel
        HSSFWorkbook book = new HSSFWorkbook();
        // 生成一个表格
        sheetTitle = excelExportHelper.getSheetTitle(sheetTitle); // 判断、设置sheetTitle
        HSSFSheet sheet = book.createSheet(sheetTitle);
        // 设置列宽  （第几列，宽度）
        for (int i = 0; i < sheetWidth.length; i++) {
            sheet.setColumnWidth(i, sheetWidth[i]);
        }
        sheet.setDefaultRowHeight((short) 360);//设置行高

        // 设置Excel里面数据
        setExcelContentData(book, sheet, header, excelList);
        System.out.println("——————————————————ExcelExportHelper:Excel生成成功...");

        //保存生成的Excel
        excelExportHelper.saveExcel(book, filePath, fileName);

    }


}
