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
    @RequestMapping("article.action")
    public String article(){
        return "article";
    }

    @RequestMapping("search_article.action")
    public String search_article(){
        return "search-article";
    }

//    @RequestMapping("search_user.action")
//    public String search_user(HttpServletRequest httpServletRequest){
//        String text = httpServletRequest.getParameter("text");
//        System.out.println(text);
//        if (text != null && text != "") {
//            return "redirect:/html/search-user.html?text=" + text;
//        }
//        return "search-user";
//    }


}
