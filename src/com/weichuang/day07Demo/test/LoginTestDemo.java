package com.weichuang.day07Demo.test;

import com.weichuang.day07Demo.MyException;
import com.weichuang.day07Demo.pojo.User;
import com.weichuang.day07Demo.service.IUserService;
import com.weichuang.day07Demo.service.impl.UserServiceImpl;

import java.util.Scanner;

public class LoginTestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.next();
        System.out.println("请输入密码:");
        String password = sc.next();
        IUserService userService = new UserServiceImpl(); //多态的概念
        try{
            User user = userService.login(username, password);
            System.out.println("欢迎您," + user.getUsername());
        }catch (MyException e){
            System.out.println("用户名或密码错误！");
        }
    }
}
