package com.zx.controller;


import com.csvreader.CsvReader;
import com.zx.entity.CompareVo;

import com.zx.entity.DeleteVO;
import com.zx.entity.ExportExcelDto;
import com.zx.mapper.TbuserMapper;
import com.zx.service.TbuserService;
import com.zx.util.ExcelImportHelper;
import com.zx.utils.WeiXinUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author zhangxin
 * @date 2022/12/1 9:21
 */
@RestController
public class JYController {

    @Autowired
    TbuserService tbuserService;

    @Autowired
    TbuserMapper tbuserMapper;


    private ExcelImportHelper excelImportHelper = new ExcelImportHelper();

    @PostMapping("/delete")
    public void delete() throws UnsupportedEncodingException {

        WeiXinUtil.doTis();
    }

    @PostMapping("/compare")
    public String test(HttpServletRequest request) {

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("files");
        System.out.printf("zhangxinxinxinxinxinxinxinxinxin");

        // 获得Workbook工作薄对象
        Workbook workbook = getWorkBook(files.get(0));
        Workbook workbook1 = getWorkBook(files.get(1));

        Sheet sheet = workbook.getSheetAt(0);
        Sheet sheet1 = workbook1.getSheetAt(0);

        int rowNum = sheet.getPhysicalNumberOfRows();
        LinkedHashMap<String, String> map1 = new LinkedHashMap<>();
        LinkedHashMap<String, DeleteVO> map2 = new LinkedHashMap<>();
        for (int i = 1; i < 713; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            Cell cell1 = row.getCell(1);
            String name = cell.getStringCellValue();
            map1.put(name.trim(), String.valueOf(i));
        }

        for (int i = 1; i < 1629; i++) {
            Row row = sheet1.getRow(i);
            Cell cell = row.getCell(0);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            Cell cell1 = row.getCell(1);
            cell1.setCellType(Cell.CELL_TYPE_STRING);
            Cell cell2 = row.getCell(2);
            cell2.setCellType(Cell.CELL_TYPE_STRING);
            Cell cell3 = row.getCell(3);
            cell3.setCellType(Cell.CELL_TYPE_STRING);
            Cell cell4 = row.getCell(4);
            cell4.setCellType(Cell.CELL_TYPE_STRING);
            Cell cell5 = row.getCell(5);
            cell5.setCellType(Cell.CELL_TYPE_STRING);
            Cell cell6 = row.getCell(6);
            cell6.setCellType(Cell.CELL_TYPE_STRING);
            Cell cell7 = row.getCell(7);
            cell7.setCellType(Cell.CELL_TYPE_STRING);
            Cell cell8 = row.getCell(8);
            cell8.setCellType(Cell.CELL_TYPE_STRING);
            Cell cell9 = row.getCell(9);
            cell9.setCellType(Cell.CELL_TYPE_STRING);
            Cell cell10 = row.getCell(10);
            cell10.setCellType(Cell.CELL_TYPE_STRING);
            Cell cell11 = row.getCell(11);
            cell11.setCellType(Cell.CELL_TYPE_STRING);
            Cell cell12 = row.getCell(12);
            cell12.setCellType(Cell.CELL_TYPE_STRING);
            Cell cell13 = row.getCell(13);
            cell13.setCellType(Cell.CELL_TYPE_STRING);
            String name = cell.getStringCellValue();
            DeleteVO deleteVO = new DeleteVO();

            deleteVO.setA(cell.getStringCellValue());
            deleteVO.setB(cell1.getStringCellValue());
            deleteVO.setC(cell2.getStringCellValue());
            deleteVO.setD(cell3.getStringCellValue());
            deleteVO.setE(cell4.getStringCellValue());
            deleteVO.setF(cell5.getStringCellValue());
            deleteVO.setG(cell6.getStringCellValue());
            deleteVO.setH(cell7.getStringCellValue());
            deleteVO.setI(cell8.getStringCellValue());
            deleteVO.setJ(cell9.getStringCellValue());
            deleteVO.setK(cell10.getStringCellValue());
            deleteVO.setL(cell11.getStringCellValue());
            deleteVO.setM(cell12.getStringCellValue());
            deleteVO.setN(cell13.getStringCellValue());
            deleteVO.setO(String.valueOf(i));
            map2.put(name.trim(), deleteVO);
        }
        List<DeleteVO> deleteVOList = new ArrayList<>();
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String name = entry.getKey();
            DeleteVO deleteVO = map2.get(name);
            if (deleteVO != null) {
                deleteVOList.add(deleteVO);
            }
        }

        List<String[]> list = new ArrayList<>();

        for (DeleteVO deleteVO:deleteVOList){
            String[] body = new String[15];
            body[0]=deleteVO.getA();
            body[1]=deleteVO.getB();
            body[2]=deleteVO.getC();
            body[3]=deleteVO.getD();
            body[4]=deleteVO.getE();
            body[5]=deleteVO.getF();
            body[6]=deleteVO.getG();
            body[7]=deleteVO.getH();
            body[8]=deleteVO.getI();
            body[9]=deleteVO.getJ();
            body[10]=deleteVO.getK();
            body[11]=deleteVO.getL();
            body[12]=deleteVO.getM();
            body[13]=deleteVO.getN();
            body[14]=deleteVO.getO();
            list.add(body);
        }
        String[] header=new String[]{"", "", "医生1-上下径", "医生2-上下径", "", "模型判断切面", "模型测量-上下径", "", "医生判断切面",
                "医生1-长径", "医生2-长径", "", "模型判断切面", "模型测量长径", ""

        };
        String fileName = "数据" + System.currentTimeMillis();
        String path = "C:/12525/3/";
        ExportExcelDto exportExcelDto = new ExportExcelDto();
        exportExcelDto.setFileName(fileName);
        //  exportExcelDto.setFilePath(importInfoPath);
        exportExcelDto.setHeader(header);
        exportExcelDto.setList(list);
        exportExcelDto.setSheetTitle("数据");
        HSSFWorkbook book = excelImportHelper.exportExcel(exportExcelDto.getHeader(), exportExcelDto.getList(), exportExcelDto.getSheetTitle()
                , path, exportExcelDto.getFileName());

        return "zhangxin";

 /*       HashSet<String> set1 = new HashSet<>();

        for (CompareVo c : c1) {
            if (set1.contains(c.getPictureName())){
                System.out.println(c.getPictureName());
            }else {
                set1.add(c.getPictureName());
            }
        }*/

    /*    HashSet<String> set2 = new HashSet<>();

        for (CompareVo c : c2) {
            if (set2.contains(c.getPictureName())){
                System.out.println(c.getPictureName());
            }else {
                set2.add(c.getPictureName());
            }
        }*/

     /*   Map<String, String> map2 = c2.stream().collect(Collectors.toMap(CompareVo::getPictureName, CompareVo::getSectionType));
        Map<String, String> map1 = c1.stream().collect(Collectors.toMap(CompareVo::getPictureName, CompareVo::getSectionType));
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String pictureName1 = entry.getKey();
            String sectionType2 = map2.get(pictureName1);
            if (sectionType2 != null) {
                boolean equals = sectionType2.equals(entry.getValue());
                if (!equals) {
                    String s = "表格1中的 " + pictureName1 + " 医生1的判断为： " + entry.getValue();
                    String s2 = "----表格2中的 ："+pictureName1+" 为：  " + map2.get(pictureName1);
                    tbuserMapper.adAnser(s + s2);
                }
            } else {
                String s = "表格1中的  " + pictureName1 + "在表格2中不存在";
                tbuserMapper.adAnser(s);
            }
        }*/

/*
        List<CompareVo> c1 = tbuserMapper.select1();
        List<CompareVo> c2 = tbuserMapper.select2();
        Map<String, String> map1 = c1.stream().collect(Collectors.toMap(CompareVo::getPictureName, CompareVo::getSectionType));

        Map<String, String> map2 = c2.stream().collect(Collectors.toMap(CompareVo::getPictureName, CompareVo::getSectionType));

        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String pictureName2 = entry.getKey();

            String sectionType1 = map1.get(pictureName2);

            if (sectionType1 != null) {
                boolean equals = sectionType1.equals(entry.getValue());
                if (!equals) {
                    String s = "表格2中的 " + pictureName2 + " 医生2的判断为： " + entry.getValue();
                    String s2 = "----表格1中的 ：" + pictureName2 + "医生1的判断 为：  " + map1.get(pictureName2);
                    tbuserMapper.adAnser(s + s2);
                }
            } else {
                String s = "表格2中的  " + pictureName2 + "在表格1中不存在";
                tbuserMapper.adAnser(s);
            }
        }
*/
        //   return null;
    }


    @PostMapping("/compare1")
    public String test2() {
        String filePath = "C:\\Users\\xkdtm\\Desktop\\1121\\class_measure.csv";
        ArrayList<String[]> arrList = readCsvByReader(filePath);

        for (int row = 1; row < arrList.size() - 1; row++) {
            String[] arr = arrList.get(row);
            String a = arrList.get(row)[0];
            String b = arrList.get(row)[1];
            CompareVo compareVo = new CompareVo();
            compareVo.setPictureName(a);
            compareVo.setSectionType(b);
            if (arr.length >= 3) {
                compareVo.setNum1(arrList.get(row)[2]);
            }
            if (arr.length >= 4) {
                compareVo.setNum2(arrList.get(row)[3]);
            }
            if (arr.length >= 5) {
                compareVo.setNum3(arrList.get(row)[4]);
            }
            tbuserMapper.add2(compareVo);
        }

        return null;
    }

    public static Workbook getWorkBook(MultipartFile file) {
        // 获得文件名
        String fileName = file.getOriginalFilename();
        // 创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            // 获取excel文件的io流
            InputStream is = file.getInputStream();
            // 根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if (fileName.endsWith("xls")) {
                // 2003
                workbook = new HSSFWorkbook(is);
            } else if (fileName.endsWith("xlsx")) {
                // 2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return workbook;
    }


    public static void main(String[] args) {

      /*  String filePath = "C:\\Users\\xkdtm\\Desktop\\1121\\医生1-统计结果.csv";
        ArrayList<String[]> arrList = readCsvByReader(filePath);*/
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime aaa = LocalDateTime.now().plusDays(7);
        System.out.println(aaa);
/*
        List<Integer> integerList = new ArrayList<>();
        integerList.add(4);
        integerList.add(2);
        integerList.add(6);
        integerList.add(3);
        Optional<Integer> max = integerList.stream().max(Integer::compareTo);
        System.out.println(max.get());
*/
        long a = Duration.between(now, aaa).toDays();
        String aaaa = "sssaaa";
        String b = aaaa.replace("a", "bb");
        System.out.println(b);
        System.out.println(a);

    }

    public static ArrayList<String[]> readCsvByReader(String filePath) {

        ArrayList<String> strList = null;
        try {
            ArrayList<String[]> arrList = new ArrayList<String[]>();
            strList = new ArrayList<String>();
            CsvReader reader = new CsvReader(filePath, ',', Charset.forName("UTF-8"));
            while (reader.readRecord()) {
//                System.out.println(Arrays.asList(reader.getValues()));
                arrList.add(reader.getValues()); // 按行读取，并把每一行的数据添加到list集合
            }
            reader.close();
            System.out.println("读取的行数：" + arrList.size());
            String[] aa = arrList.get(3239);
            String[] aaaa = arrList.get(3240);

            System.out.println(strList.size());
            return arrList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // return strList;
        return null;
    }


}
