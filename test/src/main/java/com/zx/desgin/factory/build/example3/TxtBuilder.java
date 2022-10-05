package com.zx.desgin.factory.build.example3;

import java.util.Collection;
import java.util.Map;

/**
 * @author zhangxin
 * @date 2022/8/29 17:02
 */
public class TxtBuilder implements Builder {

    private StringBuffer buffer = new StringBuffer();

    @Override
    public void builderHeader(ExportHeaderModel headerModel) {
        buffer.append(headerModel.getDepId()+","+headerModel.getExportDate()+"\n");
    }

    @Override
    public void buildBody(Map<String, Collection<ExportDataModel>> mapData) {
        for (String tblName : mapData.keySet()) {
            //先拼接表名称
            buffer.append(tblName + "\n");
            //然后循环拼接具体数据
            for (ExportDataModel edm : mapData.get(tblName)) {
                buffer.append(edm.getProductId() + "," + edm.getPrice() + "," + edm.getAmount() + "\n");
            }
        }
    }

    @Override
    public void buildFooter(ExportFooterModel efm) {
        buffer.append(efm.getExportUser());
    }

    public StringBuffer getResult(){
        return buffer;
    }
}
