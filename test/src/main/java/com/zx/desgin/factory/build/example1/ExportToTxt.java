package com.zx.desgin.factory.build.example1;

import java.util.Collection;
import java.util.Map;

/**
 * @author zhangxin
 * @date 2022/8/22 20:52
 */
public class ExportToTxt {


    public  void  export(ExportHeaderModel headerModel, Map<String, Collection<ExportDataModel>> mapData
     ,ExportFooterModel footerModel){

        //用来记录最终输出的文件内容
        StringBuffer buffer=new StringBuffer();
        //1 先来拼接文件头的内容
        buffer.append(headerModel.getDepId()+","+headerModel.getExportDate()+"\n");
        return;
        //接着来拼接文件体的内容
      /*  for(String talName:mapData.keySet()){

        }*/

    }

}
