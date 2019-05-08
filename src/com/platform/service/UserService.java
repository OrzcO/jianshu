package com.platform.service;


import com.platform.dao.UserMapper;
import com.platform.entity.Article;
import com.platform.entity.Comment;
import com.platform.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service(value = "userService")
public class UserService {

    @Resource(name = "userMapper")
    UserMapper userMapper;

    public int searchUsernameDup(String username){
        return userMapper.searchUsernameDup(username);
    }

    public int searchPhoneDup(String phone){
        return userMapper.searchPhoneDup(phone);
    }


    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    public User login (String username , String passwd) {
        return userMapper.login(username , passwd);
    }

    public int reset(String phone , String passwd) {
        return userMapper.reset(phone , passwd);
    }

    public int setInfo(int id , String info) {
        return userMapper.setInfo(id , info);
    }

    public User selectByPrimaryKey(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public String getUsernameById(int id) {
        return userMapper.getUsernameById(id);
    }
    public String getUserInfoById(int id) {
        return userMapper.getUserInfoById(id);
    }


    public List<Object> getAllInfo(int id) {
        List<Object> objects = new ArrayList();
        for (Object o : userMapper.getUserInfo(id)) {
            objects.add(o);
        }

        for (Object o : userMapper.getArticleInfo(id)) {
            objects.add(o);
        }

        for (Object o : userMapper.getArticleLikesInfo(id)) {
            objects.add(o);
        }

        for (Object o : userMapper.getCommentInfo(id)) {
            objects.add(o);
        }

        for (Object o : userMapper.getCommentLikesInfo(id)) {
            objects.add(o);
        }

        for (Object o : userMapper.getFollowInfo(id)) {
            objects.add(o);
        }

        return objects;
    }


    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }


    public List<Article> getArticleInfo(int id){
        List<Article> list = new ArrayList();
        for (Article article : userMapper.getArticleInfo(id)) {
            list.add(article);
        }

        return list;
    }

    public List<Comment> getCommentInfo(int id){
        List<Comment> list = new ArrayList();
        for (Comment comment : userMapper.getCommentInfo(id)) {
            list.add(comment);
        }

        return list;
    }

}
