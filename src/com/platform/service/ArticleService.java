package com.platform.service;


import com.platform.dao.ArticleMapper;
import com.platform.dao.Article_likesMapper;
import com.platform.dao.CommentMapper;
import com.platform.dao.Comment_likesMapper;
import com.platform.entity.Article;
import com.platform.entity.Article_likes;
import com.platform.entity.Comment;
import com.platform.entity.Comment_likes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "articleService")
public class ArticleService {

//    只引入articleMapper和commentMapper，不引入article_likeMapper和comment_likeMapper，喜欢的总数可以在接口、xml里写一个查询的sql/函数即可

    @Resource(name = "articleMapper")
    ArticleMapper articleMapper;

    @Resource(name = "commentMapper")
    CommentMapper commentMapper;

    @Resource(name = "article_likesMapper")
    Article_likesMapper article_likesMapper;

    @Resource(name = "comment_likesMapper")
    Comment_likesMapper comment_likesMapper;

//    articleMapper

    public int getArticleCount(int id) {
        return articleMapper.getArticleCount(id);
    }

    public int getArticleLikeCount(int id) {
        return articleMapper.getArticleLikeCount(id);
    }




//    commentMapper


    public int getMaxDepth(int aid) {
        return commentMapper.getMaxDepth(aid);
    }

    public int insertSelective(Comment comment) {
        return commentMapper.insertSelective(comment);
    }


    public int getCommentCount(int aid) {
        return commentMapper.getCommentCount(aid);
    }

    public List<Comment> search(int aid , int offset , int order) {
        return commentMapper.search(aid , offset , order);
    }


//    article_likes Mapper
    public int insertSelective(Article_likes article_likes) {
        return article_likesMapper.insertSelective(article_likes);
    }

    public int deleteLike(int aid , int uid) {
        return article_likesMapper.deleteLike(aid , uid);
    }


    public int getLike(int aid , int uid) {
        return article_likesMapper.getLike(aid , uid);
    }


    public int getLikeCount(int aid) {
        return article_likesMapper.getLikeCount(aid);
    }


//    comment_likes Mapper

    public int insertSelective(Comment_likes record) {
        return comment_likesMapper.insertSelective(record);
    }


    public int zanInfo(int id) {
        return comment_likesMapper.zanInfo(id);
    }


    public int getZan(int uid , int cid) {
        return comment_likesMapper.getZan(uid , cid);
    }


    public int unlike_comment(int uid , int cid) {
        return comment_likesMapper.unlike_comment(uid , cid);
    }

    public Article getArticleById (int id){
        return articleMapper.selectByPrimaryKey(id);
    }


    public List<Article> searchArticle(String text) {
        return articleMapper.searchArticle(text);
    }
}
