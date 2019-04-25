package com.platform.action;

import com.platform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/")
public class UserController {


    @Resource(name = "userService")
    UserService userService;


    @RequestMapping("searchUsernameDup.action")
    @ResponseBody
    public Integer searchUsernameDup(HttpServletRequest httpServletRequest){

        System.out.println("searchUsernameDup.action");

        String username = httpServletRequest.getParameter("username");

        System.out.println(username);

        int ans = userService.searchUsernameDup(username);

        System.out.println("searchUsernameDup : " + username + " : " + ans);
        return 1;
    }

    //    用户登录
    @RequestMapping("login.action")
    public String login(HttpServletRequest httpServletRequest){
        String username = httpServletRequest.getParameter("username");
        String passwd = httpServletRequest.getParameter("passwd");
        System.out.println(username + " - " + passwd);

        return "index";
    }


//    用户注册
    @RequestMapping("register.action")
    public String register(HttpServletRequest httpServletRequest){
        String username = httpServletRequest.getParameter("username");
        String passwd = httpServletRequest.getParameter("passwd");
        System.out.println(username + " - " + passwd);

        return "index";
    }


//    用户注销
    @RequestMapping("logout.action")
    public String logout(){

        return "index";
    }
}
