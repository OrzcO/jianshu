package com.platform.action;

import com.platform.entity.Article;
import com.platform.entity.Comment;
import com.platform.entity.User;
import com.platform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/")
public class UserController {


    @Resource(name = "userService")
    UserService userService;


    @ResponseBody
    @RequestMapping("searchUsernameDup.action")
    public int searchUsernameDup(HttpServletRequest httpServletRequest){

        String username = httpServletRequest.getParameter("username");

        int ans = userService.searchUsernameDup(username);

        System.out.println("searchUsernameDup : " + username + " : " + ans);

        return ans;
    }

    @ResponseBody
    @RequestMapping("searchPhoneDup.action")
    public int searchPhoneDup(HttpServletRequest httpServletRequest){

        String phone = httpServletRequest.getParameter("phone");

        int ans = userService.searchPhoneDup(phone);

        System.out.println("searchPhoneDup : " + phone + " : " + ans);

        return ans;
    }

    //    用户登录
    @ResponseBody
    @RequestMapping("login.action")
    public int login(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();

        String username = httpServletRequest.getParameter("username");
        String passwd = httpServletRequest.getParameter("passwd");

        User user = userService.login(username , passwd);

        int ans = 0;

        if (user != null) {
            session.setAttribute("user" , user);
            ans = 1;
        }

        System.out.println( "login : " +  username + " - " + passwd + " --->> ans : " + ans);

        return ans;
    }


//    用户注册
    @ResponseBody
    @RequestMapping("register.action")
    public int register(HttpServletRequest httpServletRequest){
        String username = httpServletRequest.getParameter("username");
        String phone = httpServletRequest.getParameter("phone");
        String passwd = httpServletRequest.getParameter("passwd");

        User user = new User();
        user.setUsername(username);
        user.setPhone(phone);
        user.setPasswd(passwd);
        user.setCreatetime(new Date());

        int ans = userService.insertSelective(user);

        System.out.println( "register : " +  username + " - " + phone + " - " + passwd + " --->> ans : " + ans);

        return ans;
    }

//    用户重置密码
    @ResponseBody
    @RequestMapping("reset.action")
    public int reset(HttpServletRequest httpServletRequest){

        String phone = httpServletRequest.getParameter("phone");
        String passwd = httpServletRequest.getParameter("passwd");

        int ans = userService.reset(phone , passwd);

        System.out.println( "reset : " +  phone + " - " +  passwd + " --->> ans : " + ans);

        return ans;
    }


    @ResponseBody
    @RequestMapping("getSession.action")
    public Map<String , String> getSession(HttpServletRequest httpServletRequest) {
        Map<String , String > map = new HashMap<>();

        HttpSession session = httpServletRequest.getSession();
        User user = (User)session.getAttribute("user");

//        解决session的500错误
        if (user == null) {
            return null;
        }

        map.put("id" , String.valueOf(user.getId())) ;
        map.put("username" , user.getUsername());
        map.put("info" , user.getInfo());

        return map;
    }


//    用户注销
    @RequestMapping("logout.action")
    public String logout(HttpServletRequest httpServletRequest){

        HttpSession session = httpServletRequest.getSession();

        session.invalidate();

        return "redirect:/index.action";
    }

    @ResponseBody
    @RequestMapping("setInfo.action")
    public int setInfo(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));
        String info = httpServletRequest.getParameter("info");

        int ans = userService.setInfo(id , info);

        System.out.println("setInfo.action " + id + " - " + info + " : " + ans);


//        更新session !!!
        User user = userService.selectByPrimaryKey(id);

        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("user" , user);

        return ans;
    }


    @ResponseBody
    @RequestMapping("getUsernameById.action")
    public String getUsernameById(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        String ans = userService.getUsernameById(id);

        System.out.println("getUsernameById.action " + id +  " : " + ans);

        return ans;
    }

    @ResponseBody
    @RequestMapping("getUserInfoById.action")
    public String getUserInfoById(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        String ans = userService.getUserInfoById(id);

        System.out.println("getUserInfoById.action " + id +  " : " + ans);

        return ans;
    }



//    user_main页面
    @ResponseBody
    @RequestMapping("getAllInfo.action")
    public List<Object> getAllInfo(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        List<Object> list = userService.getAllInfo(id);

        System.out.println("getAllInfo.action " + id +  " : " + list.size());

        return list;
    }



    @ResponseBody
    @RequestMapping("getUserById.action")
    public User getUserById(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        User user = userService.getUserById(id);

        System.out.println("getUserById.action " + id  );

        return user;
    }

    @ResponseBody
    @RequestMapping("getArticleInfo.action")
    public List<Article> getArticleInfo(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        List<Article> list = userService.getArticleInfo(id);

        System.out.println("getArticleInfo.action " + id +  " : " + list.size());

        return list;
    }

    @ResponseBody
    @RequestMapping("getCommentInfo.action")
    public List<Comment> getCommentInfo(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        List<Comment> list = userService.getCommentInfo(id);

        System.out.println("getCommentInfo.action " + id +  " : " + list.size());

        return list;
    }


}
