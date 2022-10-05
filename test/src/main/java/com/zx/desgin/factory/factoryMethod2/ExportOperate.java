package com.zx.desgin.factory.factoryMethod2;

/**
 * @author zhangxin
 * @date 2022/8/22 20:18
 */
public class ExportOperate {


    public boolean export(int type, String data) {
        //使用工厂方法
        ExportFileApi api = factoryMethod(type);
        return api.export(data);
    }

    protected ExportFileApi factoryMethod(int type) {
        ExportFileApi api = null;
        //根据类型来选择究竟要创建哪一种导出文件对象
        if (type == 1) {
            api = new ExportTxtFile();
        } else if (type == 2) {
            api = new ExportDB();
        }
        return api;
    }

}
