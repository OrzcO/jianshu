package com.platform.action;


import com.platform.entity.Follow;
import com.platform.entity.User;
import com.platform.service.FollowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/follow/")
public class FollowController {


    @Resource(name = "followService")
    FollowService followService;


    @RequestMapping("getFollowCount.action")
    @ResponseBody
    int getFollowCount(HttpServletRequest httpServletRequest){

        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        int ans = followService.getFollowCount(id);

        System.out.println("getFollowCount.action  " + id + " : " + ans);

        return ans;
    }

    @RequestMapping("getFanCount.action")
    @ResponseBody
    int getFanCount(HttpServletRequest httpServletRequest){

        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        int ans = followService.getFanCount(id);

        System.out.println("getFanCount.action  " + id + " : " + ans);

        return ans;
    }


    @RequestMapping("getFollowed.action")
    @ResponseBody
    int getFollowed(HttpServletRequest httpServletRequest){

        int from = Integer.parseInt(httpServletRequest.getParameter("from"));
        int to = Integer.parseInt(httpServletRequest.getParameter("to"));

        int ans = followService.getFollowed(from , to);

        System.out.println("getFollowed.action  " + from + " - " + to  + " : " + ans);

        return ans;
    }


    @RequestMapping("like.action")
    @ResponseBody
    public int like(HttpServletRequest httpServletRequest){

        int from = Integer.parseInt(httpServletRequest.getParameter("from"));
        int to = Integer.parseInt(httpServletRequest.getParameter("to"));

        Follow follow = new Follow();

        follow.setFollowFrom(from);
        follow.setFollowTo(to);
        follow.setTime(new Date());

        int ans = followService.like(follow);

        System.out.println("like.action " + from + " - " + to  +  " : " + ans );

        return ans;
    }

    @RequestMapping("unlike.action")
    @ResponseBody
    public int getArticleLikeCount(HttpServletRequest httpServletRequest){

        int from = Integer.parseInt(httpServletRequest.getParameter("from"));
        int to = Integer.parseInt(httpServletRequest.getParameter("to"));

        int ans = followService.unlike(from , to);

        System.out.println("unlike.action " + from + " - " + to  +  " : " + ans );

        return ans;
    }


    @RequestMapping("getFanList.action")
    @ResponseBody
    public List<User> getFanList(HttpServletRequest httpServletRequest){

        int id =  Integer.parseInt(httpServletRequest.getParameter("id"));

        List<User> userList = followService.getFanList(id);

        System.out.println("getFanList.action " + id +  " : " + userList.size() );

        return userList;
    }



    @RequestMapping("getFollowList.action")
    @ResponseBody
    public List<User> getFollowList(HttpServletRequest httpServletRequest){

        int id =  Integer.parseInt(httpServletRequest.getParameter("id"));

        List<User> userList = followService.getFollowList(id);

        System.out.println("getFollowList.action " + id +  " : " + userList.size() );

        return userList;
    }

    @RequestMapping("updateFan.action")
    @ResponseBody
    public int updateFan(HttpServletRequest httpServletRequest){

        int id =  Integer.parseInt(httpServletRequest.getParameter("id"));

        int ans = followService.updateFan(id);

        System.out.println("updateFan.action " + id +  " : " + ans );

        return ans;
    }

    @RequestMapping("updateFollow.action")
    @ResponseBody
    public int updateFollow(HttpServletRequest httpServletRequest){

        int id =  Integer.parseInt(httpServletRequest.getParameter("id"));

        int ans = followService.updateFollow(id);

        System.out.println("updateFollow.action " + id +  " : " + ans );

        return ans;
    }

    @RequestMapping("updateArticleLike.action")
    @ResponseBody
    public int updateArticleLike(HttpServletRequest httpServletRequest){

        int id =  Integer.parseInt(httpServletRequest.getParameter("id"));

        int ans = followService.updateArticleLike(id);

        System.out.println("updateArticleLike.action " + id +  " : " + ans );

        return ans;
    }



}
