package com.platform.dao;

import com.platform.entity.Article_likes;

public interface Article_likesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article_likes record);

    int insertSelective(Article_likes record);

    Article_likes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article_likes record);

    int updateByPrimaryKey(Article_likes record);



    int deleteLike(int aid , int uid);

    int getLike(int aid , int uid);

    int getLikeCount(int aid );


}