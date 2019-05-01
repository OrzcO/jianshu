package com.platform.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class RedirectController {

//    返回主页
    @RequestMapping("index.action")
    public String main(){
        return "index";
    }

//    返回用户主页
    @RequestMapping("user_main.action")
    public String user_main(){
        return "user_main";
    }

//    返回用户关注/粉丝页面
    @RequestMapping("followFan.action")
    public String followFan(){
        return "followFan";
    }

//    返回登录页面
    @RequestMapping("login.action")
    public String login(){
        return "login";
    }

//    返回注册页面
    @RequestMapping("register.action")
    public String register(){
        return "register";
    }

//    返回重置页面
    @RequestMapping("reset.action")
    public String reset(){
        return "reset";
    }

//    返回文章页面
//    还要含有文章的id , href="article.action/aid=***" href中拼上aid
    @RequestMapping("article.action")
    public String article(){
        return "article";
    }


}
