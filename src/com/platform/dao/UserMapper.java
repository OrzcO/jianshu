package com.platform.dao;

import com.platform.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


//


    int searchUsernameDup(String username);

    int searchPhoneDup(String phone);

    User login(String username , String passwd);

    int reset(String phone , String passwd);
}