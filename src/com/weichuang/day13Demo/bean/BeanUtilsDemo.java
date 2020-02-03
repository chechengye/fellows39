package com.weichuang.day13Demo.bean;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanUtilsDemo {
    public static void main(String[] args) {
        String name = "zhangsan";
        String email = "zhangsan@163.com";
        String age = "18";
        User user = new User();
        //user.setName(name);
        //user.setAge(Integer.valueOf(age));
        Map<String , Object> map = new HashMap<>();
        map.put("name","lisi");
        map.put("age","18");
        map.put("email" , "lisi@163.com");
        try {
            //BeanUtils.setProperty(user , "age" , age);//不需要强转属性
            //BeanUtils.setProperty(user,"email" , email);
            BeanUtils.populate(user,map); //map方式的自动映射，map的key键必须与bean中的属性匹配到，才可以赋值成功
            System.out.println(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
