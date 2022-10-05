package com.zx.wechatPay.util;

//import com.sun.xml.internal.fastinfoset.stax.factory.StAXOutputFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlUtil {

    private static  Logger logger = LoggerFactory.getLogger(XmlUtil.class);
    //将map中的参数组装成xml格式  供微信接口调用
    public static String getXmlFromMap(Map<String,String> parame){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<xml>");
        Set set = parame.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            buffer.append("<"+key+">"+value+"</"+key+">");
            /*//过滤相关字段sign
            if("sign".equalsIgnoreCase(key)){
                buffer.append("<"+key+">"+"<![CDATA["+value+"]]>"+"</"+key+">");
            }else{
                buffer.append("<"+key+">"+value+"</"+key+">");
            }*/
        }
        buffer.append("</xml>");
        return buffer.toString();
    }

    /**
     * 将String类型的xml转换成对象
     */
    public static <T> T xmlToBean(String xmlStr,Class<T> clazz) {
        Object xmlObject = null;
        StringReader sr = null;
        try {
            //创建JAXBContext对象，注意一定要传@XmlRootElement的所标记的类的类型
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            sr = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(sr);

        } catch (Exception e) {
            logger.error("将String类型的xml转换成对象错误",e);
        } finally {
            if (sr != null) {
                sr.close();
            }
        }
        return (T)xmlObject;
    }

    /**
     * JavaBean装换成xml
     * 默认编码UTF-8
     * @param obj
     * @return
     */
    public static String converTomXml(Object obj) {
        return converToXml(obj,"UTF-8");

    }

    /**
     * JavaBean装换成xml
     * @param obj
     * @param encoding
     * @return
     */
    private static String converToXml(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING,encoding);
            StringWriter writer = new StringWriter();
            // 2) 自定义生成
            //writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            marshaller.marshal(obj,writer);
            result =writer.toString();
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(result);
            result = m.replaceAll("");
        } catch (Exception e) {
            logger.error("JavaBean装换成xml",e);
        }
        return result;
    }

}
