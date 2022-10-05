package com.zx.desgin.factory.build.example3;

import java.util.Collection;
import java.util.Map;

/**
 * @author zhangxin
 * @date 2022/8/29 16:58
 */
public class XmlBuilder implements Builder {

    private StringBuffer buffer = new StringBuffer();

    @Override
    public void builderHeader(ExportHeaderModel headerModel) {
        buffer.append("<?xml version='1.0' encoding='gb2312'?>\n");
        buffer.append("<Report>\n");
        buffer.append("  <Header>\n");
        buffer.append("    <DepId>" + headerModel.getDepId() + "</DepId>\n");
        buffer.append("    <ExportDate>" + headerModel.getExportDate() + "</ExportDate>\n");
        buffer.append("  </Header>\n");
    }

    @Override
    public void buildBody(Map<String, Collection<ExportDataModel>> mapData) {
        buffer.append("  <Body>\n");
        for (String tblName : mapData.keySet()) {
            //先拼接表名称
            buffer.append("    <Datas TableName=\"" + tblName + "\">\n");
            //然后循环拼接具体数据
            for (ExportDataModel edm : mapData.get(tblName)) {
                buffer.append("      <Data>\n");
                buffer.append("        <ProductId>" + edm.getProductId() + "</ProductId>\n");
                buffer.append("        <Price>" + edm.getPrice() + "</Price>\n");
                buffer.append("        <Amount>" + edm.getAmount() + "</Amount>\n");
                buffer.append("      </Data>\n");
            }
            buffer.append("    </Datas>\n");
        }
        buffer.append("  </Body>\n");
    }

    @Override
    public void buildFooter(ExportFooterModel efm) {
        buffer.append("  <Footer>\n");
        buffer.append("    <ExportUser>" + efm.getExportUser() + "</ExportUser>\n");
        buffer.append("  </Footer>\n");
        buffer.append("</Report>\n");
    }

    public StringBuffer getResult() {
        return buffer;
    }

}
