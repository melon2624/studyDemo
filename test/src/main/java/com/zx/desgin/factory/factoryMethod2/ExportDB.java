package com.zx.desgin.factory.factoryMethod2;

/**
 * @author zhangxin
 * @date 2022/8/22 20:16
 */
public class ExportDB implements ExportFileApi {
    @Override
    public boolean export(String data) {

        //简单示意一下，这里需要操作文件
        System.out.println("导出数据" + data + "到数据库");
        return true;
    }
}
