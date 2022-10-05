package com.zx.desgin.factory.build.example3;

import java.util.Collection;
import java.util.Map;

/**
 * @author zhangxin
 * @date 2022/8/29 16:48
 */
public interface Builder {

    /**
     * 构建输出文件的Header部分
     * @param headerModel 文件头的内容
     */
    public void builderHeader(ExportHeaderModel headerModel);

    /**
     * 构建输出文件的Body部分
     * @param mapData 要输出的数据的内容
     */
    public void buildBody(Map<String, Collection<ExportDataModel>> mapData);

    /**
     * 构建输出文件的Footer部分
     * @param efm 文件尾的内容
     */
    public void buildFooter(ExportFooterModel efm);

}
