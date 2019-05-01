package com.platform.action;


import com.platform.entity.Comment;
import com.platform.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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
}
