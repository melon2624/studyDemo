package com.zx.desgin.factory.factoryMethod2;

/**
 * @author zhangxin
 * @date 2022/8/22 20:23
 */
public class ExportXml implements ExportFileApi {
    @Override
    public boolean export(String data) {
        //简单示意一下
        System.out.println("导出数据" + data + "到XML文件");

        return true;
    }
}
