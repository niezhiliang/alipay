package com.suyu.alipay.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Bean2MapUtil {
    /**
     * getFileds获取所有public 属性<br/>
     * getDeclaredFields 获取所有声明的属性<br/>
     * @param bean
     * @return 将某个类及其继承属性全部添加到Map中
     */
    public static Map<String,String> beanToMap(Object bean){
        Map<String,String> result = new HashMap<String,String>();
        if(bean==null){
            return result;
        }

        Field[] fields = bean.getClass().getDeclaredFields();
        if(fields==null||fields.length==0){
            return result;
        }

        for(Field field:fields){
            //重置属性可见(而且一般属性都是私有的)，否则操作无效
            boolean accessible = field.isAccessible();
            if(!accessible){
                field.setAccessible(true);
            }

            //获取属性名称及值存入Map
            String key = field.getName();
            try {
                result.put(key,field.get(bean) == null ? null : field.get(bean).toString());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            //还原属性标识
            field.setAccessible(accessible);
        }

        //获取父类属性
        fields = bean.getClass().getSuperclass().getDeclaredFields();
        if(fields==null||fields.length==0){
            return result;
        }

        for(Field field:fields){
            //重置属性可见(而且一般属性都是私有的)，否则操作无效
            boolean accessible = field.isAccessible();
            if(!accessible){
                field.setAccessible(true);
            }

            //获取属性名称及值存入Map
            String key = field.getName();
            try {
                result.put(key, field.get(bean) == null ? null : field.get(bean).toString());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            //还原属性标识
            field.setAccessible(accessible);
        }

        return result;
    }
}
