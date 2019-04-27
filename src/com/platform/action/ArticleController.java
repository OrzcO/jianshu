package com.platform.action;


import com.platform.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/article/")
public class ArticleController {

    @Resource(name = "articleService")
    ArticleService articleService;

    @RequestMapping("comment.action")
    public void comment(HttpServletRequest httpServletRequest){

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
