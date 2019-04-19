package com.platform.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login/")
public class LoginController {

    @RequestMapping("main.action")
    public String main(){
        return "login";
    }

    @RequestMapping("login.action")
    public String login(HttpServletRequest httpServletRequest){
        String username = httpServletRequest.getParameter("username");
        String passwd = httpServletRequest.getParameter("passwd");
        System.out.println(username + " - " + passwd);

        return "main";
    }
}
