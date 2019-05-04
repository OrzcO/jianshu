package com.platform.service;


import com.platform.dao.UserMapper;
import com.platform.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserService {

    @Resource(name = "userMapper")
    UserMapper userMapper;

    public int searchUsernameDup(String username){
        return userMapper.searchUsernameDup(username);
    }

    public int searchPhoneDup(String phone){
        return userMapper.searchPhoneDup(phone);
    }


    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    public User login (String username , String passwd) {
        return userMapper.login(username , passwd);
    }

    public int reset(String phone , String passwd) {
        return userMapper.reset(phone , passwd);
    }

    public int setInfo(int id , String info) {
        return userMapper.setInfo(id , info);
    }

    public User selectByPrimaryKey(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
