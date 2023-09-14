package com.zx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
                String orl=list[i].getPath();
                System.out.println(orl);
                String fileName = list[i].getName();

                String newName=filePath2+fileName;
                System.out.println(newName);
                BufferedImage originalImage = ImageIO.read(new File(orl));
                // 指定裁剪的位置和大小
                int x = 0; // 左上角 x 坐标
                int y = (int) (originalImage.getHeight() / 8.5); // 从图像顶部1/4处开始裁剪
                int width = originalImage.getWidth(); // 裁剪后的宽度，保持不变
                int height = (int) (originalImage.getHeight() *  7/ 8); // 裁剪后的高度为原始高度的3/4
                BufferedImage croppedImage = originalImage.getSubimage(x, y, width, height);

                String format=fileName.substring(fileName.length()-3);
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


}
