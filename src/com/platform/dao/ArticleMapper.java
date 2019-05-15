package com.platform.dao;

import com.platform.entity.Article;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);



    int getArticleCount(int id);

    int getArticleLikeCount(int id);


    List<Article> searchArticle(String text);

    int updateReadCount(int id);

    int updateCommentCount(int id);

    int updatelikeCount(int id);


    List<Article> getArticleList(int cnt);

    List<Article> getArticleTableInfo();

}