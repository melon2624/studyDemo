package com.zx.controller;

import com.zx.entity.ExportExcelDto;
import com.zx.entity.JmeterTestVo;
import com.zx.util.ExcelImportHelper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@RestController
@RequestMapping("/zx")
public class Test914Controller {

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\MeloZhang\\Desktop\\ty\\CRL");

            String filePath2 = "C:\\Users\\MeloZhang\\Desktop\\ty\\test\\";
            File[] list = file.listFiles();
            if (file.exists() && file.isDirectory()) {
                for (int i = 0; i < list.length; i++) {
                    String orl = list[i].getPath();
                    System.out.println(orl);
                    String fileName = list[i].getName();

                    String newName = filePath2 + fileName;
                    System.out.println(newName);
                    BufferedImage originalImage = ImageIO.read(new File(orl));
                    // 指定裁剪的位置和大小
                    int x = 0; // 左上角 x 坐标
                    int y = (int) (originalImage.getHeight() / 8.5); // 从图像顶部1/4处开始裁剪
                    int width = originalImage.getWidth(); // 裁剪后的宽度，保持不变
                    int height = (int) (originalImage.getHeight() * 7 / 8); // 裁剪后的高度为原始高度的3/4
                    BufferedImage croppedImage = originalImage.getSubimage(x, y, width, height);

                    String format = fileName.substring(fileName.length() - 3);
                    // 保存裁剪后的图像
                    ImageIO.write(croppedImage, format, new File(newName));
                }
            }
            /* String filePath = "C:\\Users\\MeloZhang\\Desktop\\ty\\test\\1.jpg";
            String filePath2 = "C:\\Users\\MeloZhang\\Desktop\\ty\\test\\2.jpg";*/
            // 读取原始图片

            // 创建裁剪后的图像
            System.out.println("图片裁剪成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/test914")
    public void testController(@RequestParam("fileName") MultipartFile file) throws IOException {
        // 防止生成的临时文件重复-建议使用UUID
        final File excelFile = File.createTempFile(System.currentTimeMillis() + "", "zx");
        file.transferTo(excelFile);
        Workbook workbook = null;
        workbook = new XSSFWorkbook(new FileInputStream(excelFile));
        Sheet sheet = workbook.getSheetAt(0);
        Sheet sheet1 = workbook.getSheetAt(1);
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 1; i < 2187; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            Integer pioltValue = (int) cell.getNumericCellValue();
            hashSet.add(pioltValue.toString());
            // System.out.println(cell.getNumericCellValue());
        }

  /*      for (int i = 1; i < 1194; i++) {
            Row row = sheet1.getRow(i);
            Cell cell = row.getCell(0);
            // System.out.println(cell.getCellType());
            Integer pioltValue = (int) cell.getNumericCellValue();
            System.out.println(pioltValue);
            Boolean aaa = hashSet.add(pioltValue.toString());
            if (aaa == false) {
                System.out.println(pioltValue);
            }
        }*/

        File file1 = new File("C:\\Users\\MeloZhang\\Desktop\\ty\\CRL");
        File[] list = file1.listFiles();

        TreeMap<String, File> treeMap = new TreeMap<String, File>(new CustomFileComparator());
        for (File file2 : list) {
            // 在这里实现自定义的比较逻辑
            String fileName1 = file2.getName();
            int lastDotIndex1 = fileName1.lastIndexOf('.');
            String resultString1 = fileName1.substring(0, lastDotIndex1);
            treeMap.put(resultString1, file2);
        }
        list = treeMap.values().toArray(new File[treeMap.size()]);

        int j = 1;
        for (int i = 0; i < list.length; i++) {
            String filePath2 = "C:\\Users\\MeloZhang\\Desktop\\ty\\pilot2\\";
            String orl = list[i].getPath();
            String fileName = list[i].getName();
            //System.out.println(fileName);
            int lastDotIndex = fileName.lastIndexOf('.');
            String resultString = fileName.substring(0, lastDotIndex);

            String[] parts = fileName.split("\\.");
            String format = "." + parts[parts.length - 1];
            // String format = fileName.substring(fileName.length() - 4);
            if (hashSet.contains(resultString)) {
                Integer name = j++;
                String newPath = filePath2 + "P" + name + format;
                Path sourcePath = Paths.get(orl);
                Path targetPath = Paths.get(newPath);
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }

        System.out.println("hello");
    }

    @RequestMapping("/test1120")
    public void test1120(@RequestParam("fileName") MultipartFile file) throws IOException {
        // 防止生成的临时文件重复-建议使用UUID
        final File excelFile;
        excelFile = File.createTempFile(System.currentTimeMillis() + "", "zx");
        file.transferTo(excelFile);
        Workbook workbook = null;
        workbook = new XSSFWorkbook(new FileInputStream(excelFile));
        Sheet sheet = workbook.getSheetAt(1);
        HashMap<String, Integer> anser = new HashMap<>();
      /*  for (int i = 1; i < 68801; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(2);
            String name = cell.getStringCellValue();
            if (anser.containsKey(name)) {
                anser.put(name, anser.get(name) + 1);
            } else {
                anser.put(name, 1);
            }
        }*/
     /*   int total=0;
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
        for (Map.Entry<String,Integer> map:anser.entrySet()){
            total=total+map.getValue();
            System.out.println(map.getKey()+" : "+map.getValue());
        }
        System.out.println("bbbbbbbbbbbbbbb");
        System.out.println(total);
        System.out.println("-----------------------------------------");*/
        for (int i = 1; i < 68801; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(3);
            String name = cell.getStringCellValue();

            if (!name.contains("?")) {
                int hyphenIndex = name.lastIndexOf('-');
                // 如果找到了连字符，并且它不在字符串的最后位置
                if (hyphenIndex != -1 && hyphenIndex < name.length() - 1) {
                    String aaaaa = name.substring(0, hyphenIndex);
                    // 返回连字符前面的部分
                    if (anser.containsKey(aaaaa)) {
                        anser.put(aaaaa, anser.get(aaaaa) + 1);
                    } else {
                        anser.put(aaaaa, 1);
                    }
                }
            } else {
                int hyphenIndex = name.lastIndexOf('?');
                if (hyphenIndex != -1 && hyphenIndex < name.length() - 1) {
                    String aaaaa = name.substring(0, hyphenIndex);
                    // 返回连字符前面的部分
                    if (anser.containsKey(aaaaa)) {
                        anser.put(aaaaa, anser.get(aaaaa) + 1);
                    } else {
                        anser.put(aaaaa, 1);
                    }
                }
            }
        }

        int total = 0;
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
        for (Map.Entry<String, Integer> map : anser.entrySet()) {
            total = total + map.getValue();
            System.out.println(map.getKey() + " : " + map.getValue());
        }
        System.out.println("total : " + total);
    }

    @RequestMapping("/test11201")
    public void test11201(@RequestParam("fileName") MultipartFile file) throws IOException {
        // 防止生成的临时文件重复-建议使用UUID
        final File excelFile;
        excelFile = File.createTempFile(System.currentTimeMillis() + "", "zx");
        file.transferTo(excelFile);
        Workbook workbook = null;
        workbook = new XSSFWorkbook(new FileInputStream(excelFile));
        Sheet sheet = workbook.getSheetAt(1);
        HashMap<String, HashMap<String, Integer>> anser = new HashMap<>();
        HashMap<String, String> actionMap = new HashMap<>();
        for (int i = 1; i < 68801; i++) {
            Row row = sheet.getRow(i);
            Cell responseMessageCell = row.getCell(5);
            String responseMessageCellName = responseMessageCell.getStringCellValue();
            if (anser.containsKey(responseMessageCellName)) {
            } else {
                anser.put(responseMessageCellName, new HashMap<String, Integer>());
            }
        }

        for (int i = 1; i < 68801; i++) {
            Row row = sheet.getRow(i);
            Cell actionCell = row.getCell(2);
            Cell lableCell = row.getCell(3);
            actionMap.put(lableCell.getStringCellValue(), actionCell.getStringCellValue());
            Cell responseMessageCell = row.getCell(5);
            if (responseMessageCell.getStringCellValue().equals("OK")){
                continue;
            }
            HashMap<String, Integer> map = anser.get(responseMessageCell.getStringCellValue());
            String lable = lableCell.getStringCellValue();
            if (map.containsKey(lable)) {
                map.put(lable, map.get(lable) + 1);
            } else {
                map.put(lable, 1);
            }
        }

        List<String[]> jmeterTestVoList = new ArrayList<>();

        for (Map.Entry<String, HashMap<String, Integer>> map : anser.entrySet()) {
            String responseCode = map.getKey();
            //System.out.println(map.getKey() + " ----------" );
            for (Map.Entry<String, Integer> map2 : map.getValue().entrySet()) {

                String label = map2.getKey();
                String num = map2.getValue().toString();
                String action = actionMap.get(label);
                String[] body = new String[4];
                body[0] = action;
                body[1] = label;
                body[2] = num;
                body[3] = responseCode;
                jmeterTestVoList.add(body);
                System.out.println(map2.getKey() + " : " + map2.getValue());
            }
        }
        String[] header = new String[]{"action", "label", "num", "responseCode"
        };
        ExcelImportHelper excelImportHelper = new ExcelImportHelper();
        String fileName = "数据" + System.currentTimeMillis();
        String path = "C:/Users/MeloZhang/Desktop/Ad_hoc_Report_R2_20231110/Ad_hoc_Report_R2_20231110";
        ExportExcelDto exportExcelDto = new ExportExcelDto();
        exportExcelDto.setFileName(fileName);
        //  exportExcelDto.setFilePath(importInfoPath);
        exportExcelDto.setHeader(header);
        exportExcelDto.setList(jmeterTestVoList);
        exportExcelDto.setSheetTitle("数据");
        HSSFWorkbook book = excelImportHelper.exportExcel(exportExcelDto.getHeader(), exportExcelDto.getList(), exportExcelDto.getSheetTitle()
                , path, exportExcelDto.getFileName());

        System.out.println("--------------------");
    }
}


class CustomFileComparator implements Comparator<String> {
    @Override
    public int compare(String file1, String file2) {
       /*    定义的比较逻辑 // 在这里实现自
            String fileName1 = file1.getName();
            int lastDotIndex1 = fileName1.lastIndexOf('.');
            String resultString1 = fileName1.substring(0, lastDotIndex1);
            String fileName2 = file2.getName();
            int lastDotIndex2 = fileName2.lastIndexOf('.');
            String resultString2 = fileName2.substring(0, lastDotIndex2);*/
        int num1 = Integer.parseInt(file1);
        int num2 = Integer.parseInt(file2);
        return Integer.compare(num1, num2);
        // return file1.compareTo(file2);
    }
}