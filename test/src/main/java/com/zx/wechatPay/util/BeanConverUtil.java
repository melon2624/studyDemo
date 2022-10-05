package com.zx.wechatPay.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanConverUtil {

    /**
     * 将一个 JavaBean 对象转化为一个 Map
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的 Map 对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static Map<String, String> toMap(Object bean,Map<String,String> returnMap) {
        Class<? extends Object> clazz = bean.getClass();
        if(returnMap==null){
            returnMap = new HashMap<>();
        }
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object value = null;
                    value = readMethod.invoke(bean, new Object[0]);
                    if (null != propertyName) {
                        propertyName = propertyName.toString();
                    }
                    if (null != value) {
                        returnMap.put(propertyName, value.toString());
                    }
                }
            }
        } catch (IntrospectionException e) {
            System.out.println("分析类属性失败");
        } catch (IllegalAccessException e) {
            System.out.println("实例化 JavaBean 失败");
        } catch (IllegalArgumentException e) {
            System.out.println("映射错误");
        } catch (InvocationTargetException e) {
            System.out.println("调用属性的 setter 方法失败");
        }
        return returnMap;
    }
}
