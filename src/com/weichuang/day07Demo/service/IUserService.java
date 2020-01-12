package com.weichuang.day07Demo.service;

import com.weichuang.day07Demo.MyException;
import com.weichuang.day07Demo.pojo.User;

public interface IUserService {
    User login(String username , String password) throws MyException;
}
