package com.LW1_ptlb.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

//工具类，用于把 获得的 json 对象转换为 所需要的原本数据
public class ReturnJackson {

    ObjectMapper objectMapper = new ObjectMapper();//获得 jackson 的类型转换工具

    public <T> T  returnJackson(ResponseEntity<String> forEntity,Class<T> valueType){

        //把接收的 json 类型 转换为 json 字符串
        String body = forEntity.getBody();

        //返回值
        T t = null;

        try {
            t = objectMapper.readValue(body, valueType);//把 json 字符串转换为所需要的数据类型
        } catch (JsonProcessingException e) {
            System.err.println("格式转换错误\n"+e);
        }

        return t;//返回数据
    }

}
