package com.jee.po;

import org.apache.ibatis.ognl.ParseException;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateConverter implements Converter<String, Date> {
    // 转换实现
    // 将请求中的字符串日期，转换成java中的Date对象
    public Date convert(String s) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {

                date = sdf.parse(s);
            } catch (java.text.ParseException e) {
                e.printStackTrace();

        }
        return date;
    }
}
