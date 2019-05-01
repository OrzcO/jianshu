package com.platform.service;


import com.platform.dao.ArticleMapper;
import com.platform.dao.CommentMapper;
import com.platform.entity.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "articleService")
public class ArticleService {

//    只引入articleMapper和commentMapper，不引入article_likeMapper和comment_likeMapper，喜欢的总数可以在接口、xml里写一个查询的sql/函数即可

    @Resource(name = "articleMapper")
    ArticleMapper articleMapper;

    @Resource(name = "commentMapper")
    CommentMapper commentMapper;


//    articleMapper





//    commentMapper


    public int getMaxDepth(int aid) {
        return commentMapper.getMaxDepth(aid);
    }

    public int insertSelective(Comment comment) {
        return commentMapper.insertSelective(comment);
    }

}
