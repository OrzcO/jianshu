package com.platform.dao;

import com.platform.entity.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);





    int getMaxDepth(int aid);

    int getCommentCount(int aid);

    List<Comment> search(int aid , int offet , int order);


    List<Comment> getCommentTableInfo();
}