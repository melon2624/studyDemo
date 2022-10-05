package com.zx.desgin.factory.factoryMethod2;

/**
 * @author zhangxin
 * @date 2022/8/22 20:25
 */
public class ExportOperate2 extends ExportOperate {

    protected ExportFileApi factoryMethod(int type) {
        ExportFileApi api = null;

        if (type == 3) {
            api = new ExportXml();
        } else {
            api = super.factoryMethod(type);
        }

        return api;

    }

}
