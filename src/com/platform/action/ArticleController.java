package com.platform.action;


import com.platform.entity.Comment;
import com.platform.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/article/")
public class ArticleController {

    @Resource(name = "articleService")
    ArticleService articleService;

    @RequestMapping("comment.action")
    @ResponseBody
    public int comment(HttpServletRequest httpServletRequest){

        Comment comment = new Comment();


        int aid = Integer.parseInt(httpServletRequest.getParameter("aid"));
        String comment_from = httpServletRequest.getParameter("comment_from");
        String commment_to = httpServletRequest.getParameter("comment_to");
        int depth = Integer.parseInt(httpServletRequest.getParameter("depth"));
        String info = httpServletRequest.getParameter("info");


        comment.setAid(aid);
        comment.setCommentFrom(comment_from);
        comment.setCommentTo(commment_to);
        comment.setDepth(depth);
        comment.setInfo(info);
        comment.setTime(new Date());

        int ans = articleService.insertSelective(comment);

        System.out.println("comment " + aid + " - " + comment_from + " - " + info + " : " + ans);

        return ans;
    }


    @RequestMapping("getMaxDepth.action")
    @ResponseBody
    public int getMaxDepth(HttpServletRequest httpServletRequest) {
        int aid = Integer.parseInt(httpServletRequest.getParameter("aid"));

        int ans = articleService.getMaxDepth(aid);

        System.out.println("getMaxDepth : " + aid + " - ans " + ans);

        return ans;
    }


    @RequestMapping("getCommentCount.action")
    @ResponseBody
    public int getCommentCount(HttpServletRequest httpServletRequest) {
        int aid = Integer.parseInt(httpServletRequest.getParameter("aid"));

        int ans = articleService.getCommentCount(aid);

        System.out.println("getCommentCount : " + aid + " - ans " + ans);

        return ans;
    }


    @RequestMapping("search.action")
    @ResponseBody
    public List<Comment> search(HttpServletRequest httpServletRequest) {

        int aid = Integer.parseInt(httpServletRequest.getParameter("aid"));
        int offset = Integer.parseInt(httpServletRequest.getParameter("offset")); // 第几页
        int order = Integer.parseInt(httpServletRequest.getParameter("order"));
        int comment_depth = Integer.parseInt(httpServletRequest.getParameter("comment_depth"));

//        将offset转化为第几条~第几条的记录
//        means 按时间降序排 （默认的）
        if (order == 0) {
            offset = comment_depth - offset*3;
        } else {
            offset = offset *3;
        }

        List<Comment> list = articleService.search(aid , offset , order);

        return list;
    }
}
