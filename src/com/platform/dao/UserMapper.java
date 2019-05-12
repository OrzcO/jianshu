package com.platform.dao;

import com.platform.entity.*;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);







    int searchUsernameDup(String username);

    int searchPhoneDup(String phone);

    User login(String username , String passwd);

    int reset(String phone , String passwd);

    int setInfo(int id , String info);

    String getUsernameById(int id);

    String getUserInfoById(int id);


    List<User> getUserInfo(int id);
    List<Article> getArticleInfo(int id);
    List<Article_likes> getArticleLikesInfo(int id);
    List<Comment> getCommentInfo(int id);
    List<Comment_likes> getCommentLikesInfo(int id);
    List<Follow> getFollowInfo(int id);


//    搜索部分
    List<User> searchUser(String text);
    List<User> searchUserLimit(String text);


//    更新用户写字、文章数量
    int updateWordCnt(int id , int word_cnt);
    int updateArticleCnt(int id);


//    更新用户喜欢数量
    int updatelikeCount(int id);


    int updateUrl(int id ,String url);
    String getImgUrl(int id);


    List<User> recommendUserList(int cnt);

}