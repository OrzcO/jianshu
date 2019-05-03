package com.platform.service;


import com.platform.dao.ArticleMapper;
import com.platform.dao.Article_likesMapper;
import com.platform.dao.CommentMapper;
import com.platform.entity.Article_likes;
import com.platform.entity.Comment;
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


//    articleMapper





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
        return article_likesMapper.getLikeCount(aid );
    }
}
