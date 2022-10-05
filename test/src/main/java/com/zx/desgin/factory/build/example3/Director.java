package com.zx.desgin.factory.build.example3;

import java.util.Collection;
import java.util.Map;

/**
 * @author zhangxin
 * @date 2022/8/29 17:05
 */
public class Director {

    /**
     * 持有当前需要使用的构建器对象
     */
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 指导构建器构建最终的输出的文件的对象
     *
     * @param headerModel     文件头的内容
     * @param mapData 数据的内容
     * @param efm     文件尾的内容
     */
    public void construct(ExportHeaderModel headerModel, Map<String, Collection<ExportDataModel>> mapData, ExportFooterModel efm) {
        //1：先构建Header
        builder.builderHeader(headerModel);
        //2：然后构建Body
        builder.buildBody(mapData);
        //3：然后构建Footer
        builder.buildFooter(efm);
    }

}
