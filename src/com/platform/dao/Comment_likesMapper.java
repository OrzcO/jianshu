package com.platform.dao;

import com.platform.entity.Comment_likes;

public interface Comment_likesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment_likes record);

    int insertSelective(Comment_likes record);

    Comment_likes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment_likes record);

    int updateByPrimaryKey(Comment_likes record);
}