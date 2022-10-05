package com.zx.desgin.factory.factoryMethod2;

/**
 * @author zhangxin
 * @date 2022/8/22 20:15
 */
public class ExportTxtFile implements ExportFileApi {
    @Override
    public boolean export(String data) {

        //简单示意一下，这里需要操作文件
        System.out.println("导出数据" + data + "到文本文件");

        return true;
    }
}
