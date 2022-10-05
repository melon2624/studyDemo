package com.zx.other;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @author zhangxin
 * @date 2022/8/31 21:18
 */
public class JYSortCode {

    public static void main(String[] args) throws InterruptedException, IOException {

        File file = new File("C:\\12525\\3");
        File[] list = file.listFiles();
        if (file.exists() && file.isDirectory()) {
            for (int i = 0; i < list.length; i++) {
                String name = list[i].getName();
                Integer j = i + 1021;
                String name2 =j +".jpg";
                File dest = new File("C:\\12126" + "\\3\\" + name2);
                copyfile(list[i],dest);
             //   list[i].renameTo(dest);
                System.out.println(list[i].getName());
            }
        }

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

}
