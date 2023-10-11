package com.zx.controller;

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
/*        for (int i = 1; i < 2187; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            Integer pioltValue = (int) cell.getNumericCellValue();
            hashSet.add(pioltValue.toString());
            // System.out.println(cell.getNumericCellValue());
        }*/

        for (int i = 1; i < 1194; i++) {
            Row row = sheet1.getRow(i);
            Cell cell = row.getCell(0);
            // System.out.println(cell.getCellType());
            Integer pioltValue = (int) cell.getNumericCellValue();
            System.out.println(pioltValue);
            Boolean aaa = hashSet.add(pioltValue.toString());
            if (aaa == false) {
                System.out.println(pioltValue);
            }
        }

        File file1 = new File("C:\\Users\\MeloZhang\\Desktop\\ty\\CRL");
        File[] list = file1.listFiles();

        TreeMap<String, File> treeMap = new TreeMap<String,File>(new CustomFileComparator());
        for (File file2:list){
            // 在这里实现自定义的比较逻辑
            String fileName1 = file2.getName();
            int lastDotIndex1 = fileName1.lastIndexOf('.');
            String resultString1 = fileName1.substring(0, lastDotIndex1);
            treeMap.put(resultString1,file2);
        }
        list= treeMap.values().toArray(new File[treeMap.size()]);

        int j=1;
        for (int i = 0; i < list.length; i++) {
            String filePath2 = "C:\\Users\\MeloZhang\\Desktop\\ty\\valid2\\";
            String orl = list[i].getPath();
            String fileName = list[i].getName();
            //System.out.println(fileName);
            int lastDotIndex = fileName.lastIndexOf('.');
            String resultString = fileName.substring(0, lastDotIndex);

            String[] parts = fileName.split("\\.");
            String format ="."+ parts[parts.length - 1];
           // String format = fileName.substring(fileName.length() - 4);
            if (hashSet.contains(resultString)) {
                Integer name=j++;
                String newPath = filePath2 +"V"+ name+format;
                Path sourcePath = Paths.get(orl);
                Path targetPath = Paths.get(newPath);
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }

        System.out.println("hello");
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

}
