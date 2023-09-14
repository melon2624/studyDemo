package com.zx.controller;

import com.zx.entity.Patient;
import com.zx.entity.TestVo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/zx")
public class Test713Controller {

    @RequestMapping("/zx")
    public void test(@RequestParam("fileName") MultipartFile file) throws IOException {
        // 防止生成的临时文件重复-建议使用UUID
        final File excelFile = File.createTempFile(System.currentTimeMillis() + "", "zx");
        file.transferTo(excelFile);
        Workbook workbook = null;
        workbook = new HSSFWorkbook(new FileInputStream(excelFile));
        List<Patient> list = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();

    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        String filePath = "C:\\Users\\MeloZhang\\Desktop\\CDH.xlsx";
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(fis);
        List<String> list = new ArrayList<>();

        HashSet<String> aaaaa = new HashSet<>();

        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rowNum; i++) {
            Cell cell = sheet.getRow(i).getCell(0);
            double numericCellValue = cell.getNumericCellValue();
            int aaa = (int) numericCellValue;
            aaaaa.add(String.valueOf(aaa));
        }

        File file = new File("C:\\Users\\MeloZhang\\Desktop\\CRL2");
        File[] list1 = file.listFiles();


        HashSet<String> set = new HashSet<>();
        for (File file1 : list1) {
            String name = file1.getName();
            int endIndex = name.length() - 4;
            String result = name.substring(0, endIndex);
            set.add(result);
        }

        for (String a:aaaaa){
            if (!set.contains(a)){
                System.out.println(a);
            }
        }


        for (File file1 : list1) {

            String name = file1.getName();
            int endIndex = name.length() - 4;
            String result = name.substring(0, endIndex);

            if (!result.equals(result.trim())) {
                System.out.println(result);
            }
            if (aaaaa.contains(result)) {
                String dir = "C:\\Users\\MeloZhang\\Desktop\\CRL3\\" + name;
                File dest1 = new File(dir);
                copyfile(file1, dest1);
            }
            //    System.out.println(name);
        }


        System.out.printf("");
    }

    public static void copyfile(File f, File cf) throws IOException {
        FileChannel ic = null;
        FileChannel oc = null;
        ic = new FileInputStream(f).getChannel();//f为已有文件对象
        oc = new FileOutputStream(cf).getChannel();//cf为复制到的文件对象
        oc.transferFrom(ic, 0, ic.size());
        ic.close();
        oc.close();
    }

    @RequestMapping("/test")
    public  void  teest(@RequestBody TestVo testVo){
        System.out.println(testVo.getA());
        System.out.println(testVo.getB());
    }


}


