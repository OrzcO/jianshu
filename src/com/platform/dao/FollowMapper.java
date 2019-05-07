package com.platform.dao;

import com.platform.entity.Follow;
import com.platform.entity.User;

import java.util.List;

public interface FollowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Follow record);

    int insertSelective(Follow record);

    Follow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Follow record);

    int updateByPrimaryKey(Follow record);





    int getFollowCount(int id);

    int getFanCount(int id);

    int getFollowed(int from , int to);

    int unlike(int from , int to);

    List<User> getFanList(int id);

    List<User> getFollowList(int id);



    int updateFan(int id);

    int updateFollow(int id);

    int updateArticleLike(int id);
}