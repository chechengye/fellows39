package com.weichuang.day07Demo.service.impl;

import com.weichuang.day07Demo.MyException;
import com.weichuang.day07Demo.pojo.User;
import com.weichuang.day07Demo.service.IUserService;

public class UserServiceImpl implements IUserService{
    /**
     * 登陆功能实现
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) throws MyException{
        if(!"admin".equals(username)){
            throw new MyException("用户名错误");
        }else if(!"1234".equals(password)){
            throw new MyException("密码错误");
        }
        User user = new User();
        user.setUsername(username);
        return user;
    }
}
