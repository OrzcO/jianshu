package com.platform.service;


import com.platform.dao.FollowMapper;
import com.platform.entity.Follow;
import com.platform.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("followService")
public class FollowService {

    @Resource(name = "followMapper")
    FollowMapper followMapper;



    public int getFollowCount(int id){
        return followMapper.getFollowCount(id);
    }

    public int getFanCount(int id){
        return followMapper.getFanCount(id);
    }

    public int getFollowed(int from , int to) {
        return followMapper.getFollowed(from , to);
    }

    public int like(Follow record) {
        return followMapper.insertSelective(record);
    }

    public int unlike(int from , int to) {
        return followMapper.unlike(from , to);
    }

    public List<User> getFanList(int id) {
        return followMapper.getFanList(id);
    }

    public List<User> getFollowList(int id) {
        return followMapper.getFollowList(id);
    }


    public int updateFan(int id) {
        return followMapper.updateFan(id);
    }

    public int updateFollow(int id) {
        return followMapper.updateFollow(id);
    }

    public int updateArticleLike(int id) {
        return followMapper.updateArticleLike(id);
    }


}
