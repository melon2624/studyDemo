package com.zx.controller;


import com.csvreader.CsvReader;
import com.zx.entity.CompareVo;

import com.zx.mapper.TbuserMapper;
import com.zx.service.TbuserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @PostMapping("/compare")
    public String test(HttpServletRequest request) {

        List<CompareVo> c1 = tbuserMapper.select1();

        System.out.println("----------------------");

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


        return null;

    }


    @PostMapping("/compare1")
    public String test2() {
        String filePath = "C:\\Users\\xkdtm\\Desktop\\1121\\医生2-统计的结果.csv";
        ArrayList<String[]> arrList = readCsvByReader(filePath);

        for (int row = 1; row < arrList.size() - 1; row++) {
            String a = arrList.get(row)[0];
            String b = arrList.get(row)[1];
            CompareVo compareVo = new CompareVo();
            compareVo.setPictureName(a);
            compareVo.setSectionType(b);
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

        String filePath = "C:\\Users\\xkdtm\\Desktop\\1121\\医生1-统计结果.csv";
        ArrayList<String[]> arrList = readCsvByReader(filePath);


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
