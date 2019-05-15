package com.platform.action;


import com.platform.entity.Article;
import com.platform.entity.Article_likes;
import com.platform.entity.Comment;
import com.platform.entity.Comment_likes;
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


    @RequestMapping("like.action")
    @ResponseBody
    public int like(HttpServletRequest httpServletRequest){
        int aid = Integer.parseInt(httpServletRequest.getParameter("aid"));
        int uid = Integer.parseInt(httpServletRequest.getParameter("uid"));

        Article_likes article_likes = new Article_likes();
        article_likes.setAid(aid);
        article_likes.setUid(uid);
        article_likes.setTime(new Date());

        int ans = articleService.insertSelective(article_likes);

        System.out.println("like.action " + aid + " " + uid + " : " + ans );

        return ans;
    }


    @RequestMapping("unlike.action")
    @ResponseBody
    public int unlike(HttpServletRequest httpServletRequest){
        int aid = Integer.parseInt(httpServletRequest.getParameter("aid"));
        int uid = Integer.parseInt(httpServletRequest.getParameter("uid"));

        int ans = articleService.deleteLike(aid , uid);

        System.out.println("unlike.action " + aid + " " + uid + " : " + ans );

        return ans;
    }



    @RequestMapping("getLike.action")
    @ResponseBody
    public int getLike(HttpServletRequest httpServletRequest){
        int aid = Integer.parseInt(httpServletRequest.getParameter("aid"));
        int uid = Integer.parseInt(httpServletRequest.getParameter("uid"));

        int ans = articleService.getLike(aid , uid);

        System.out.println("getLike.action " + aid + " " + uid + " : " + ans );

        return ans;
    }

    @RequestMapping("getLikeCount.action")
    @ResponseBody
    public int getLikeCount(HttpServletRequest httpServletRequest){
        int aid = Integer.parseInt(httpServletRequest.getParameter("aid"));

        int ans = articleService.getLikeCount(aid);

        System.out.println("getLikeCount.action " + aid +  " : " + ans );

        return ans;
    }

    @RequestMapping("zanInfo.action")
    @ResponseBody
    public int zanInfo(HttpServletRequest httpServletRequest){
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        int ans = articleService.zanInfo(id);

        System.out.println("zanInfo.action " + id +  " : " + ans );

        return ans;
    }

    @RequestMapping("getZan.action")
    @ResponseBody
    public int getZan(HttpServletRequest httpServletRequest){
        int uid = Integer.parseInt(httpServletRequest.getParameter("uid"));
        int cid = Integer.parseInt(httpServletRequest.getParameter("cid"));

        int ans = articleService.getZan(uid , cid);

        System.out.println("getZan.action " + uid + " - " + cid  +  " : " + ans );

        return ans;
    }


    @RequestMapping("like_comment.action")
    @ResponseBody
    public int like_comment(HttpServletRequest httpServletRequest){
        int uid = Integer.parseInt(httpServletRequest.getParameter("uid"));
        int cid = Integer.parseInt(httpServletRequest.getParameter("cid"));

        Comment_likes comment_likes = new Comment_likes();
        comment_likes.setUid(uid);
        comment_likes.setCid(cid);
        comment_likes.setTime(new Date());

        int ans = articleService.insertSelective(comment_likes);

        System.out.println("like_comment.action " + uid + " - " + cid  +  " : " + ans );

        return ans;
    }


    @RequestMapping("unlike_comment.action")
    @ResponseBody
    public int unlike_comment(HttpServletRequest httpServletRequest){

        int uid = Integer.parseInt(httpServletRequest.getParameter("uid"));
        int cid = Integer.parseInt(httpServletRequest.getParameter("cid"));

        int ans = articleService.unlike_comment(uid , cid);

        System.out.println("unlike_comment.action " + uid + " - " + cid  +  " : " + ans );

        return ans;
    }




    @RequestMapping("getArticleCount.action")
    @ResponseBody
    public int getArticleCount(HttpServletRequest httpServletRequest){

        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        int ans = articleService.getArticleCount(id);

        System.out.println("getArticleCount.action " + id +  " : " + ans );

        return ans;
    }


    @RequestMapping("getArticleLikeCount.action")
    @ResponseBody
    public int getArticleLikeCount(HttpServletRequest httpServletRequest){

        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        int ans = articleService.getArticleLikeCount(id);

        System.out.println("getArticleLikeCount.action " + id +  " : " + ans );

        return ans;
    }



    @RequestMapping("getArticleById.action")
    @ResponseBody
    public Article getArticleById(HttpServletRequest httpServletRequest){

        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        Article article = articleService.getArticleById(id);

        System.out.println("getArticleById.action " + id );

        return article;
    }

    @ResponseBody
    @RequestMapping("searchArticle.action")
    public List<Article> searchUserLimit(HttpServletRequest httpServletRequest) {
        String text = httpServletRequest.getParameter("text");

        List<Article> list = articleService.searchArticle(text);

        System.out.println("searchArticle.action " + text +  " : " + list.size());

        return list;
    }

    @ResponseBody
    @RequestMapping("insert.action")
    public int insert(HttpServletRequest httpServletRequest) {

        Article article = new Article();

        if (httpServletRequest.getParameter("uid") != null && httpServletRequest.getParameter("uid") != "") {
            article.setUid(Integer.parseInt(httpServletRequest.getParameter("uid")));
        }
        String author = httpServletRequest.getParameter("author");
        String title = httpServletRequest.getParameter("title");
        String introduction = httpServletRequest.getParameter("introduction");
        String content = httpServletRequest.getParameter("content");

        if (httpServletRequest.getParameter("url") != null) {
            article.setUrl(httpServletRequest.getParameter("url"));
        }

        article.setAuthor(author);
        article.setTitle(title);
        article.setIntroduction(introduction);
        article.setContent(content);
        article.setTime(new Date());


        int ans = articleService.insertSelective(article);


        return ans;
    }


    @ResponseBody
    @RequestMapping("updateReadCount.action")
    public int updateReadCount(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        int ans = articleService.updateReadCount(id);

        System.out.println("updateReadCount.action - " + id + " : " + ans);

        return ans;
    }

    @ResponseBody
    @RequestMapping("updateCommentCount.action")
    public int updateCommentCount(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        int ans = articleService.updateCommentCount(id);

        System.out.println("updateCommentCount.action - " + id + " : " + ans);

        return ans;
    }

    @ResponseBody
    @RequestMapping("updatelikeCount.action")
    public int updatelikeCount(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        int ans = articleService.updatelikeCount(id);

        System.out.println("updatelikeCount.action - " + id + " : " + ans);

        return ans;
    }

    @ResponseBody
    @RequestMapping("getArticleList.action")
    public List<Article> getArticleList(HttpServletRequest httpServletRequest) {

        int cnt = Integer.parseInt(httpServletRequest.getParameter("cnt")) * 5;

        List<Article> list = articleService.getArticleList(cnt);

        System.out.println("getArticleList.action : " + cnt + " : " + list.size());

        return list;


    }


    @ResponseBody
    @RequestMapping("getArticleTableInfo.action")
    public List<Article> getArticleTableInfo(){
        List<Article> list = articleService.getArticleTableInfo();

        System.out.println("getArticleTableInfo : " + list.size());

        return list;
    }


    @ResponseBody
    @RequestMapping("getCommentTableInfo.action")
    public List<Comment> getCommentTableInfo(){
        List<Comment> list = articleService.getCommentTableInfo();

        System.out.println("getCommentTableInfo : " + list.size());

        return list;
    }


    @ResponseBody
    @RequestMapping("deleteArticleById.action")
    public int deleteSearchById(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        int ans = articleService.deleteArticleById(id);

        System.out.println("deleteArticleById - " + id + " : " + ans);

        return ans;
    }

    @ResponseBody
    @RequestMapping("deleteCommentById.action")
    public int deleteCommentById(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        int ans = articleService.deleteCommentById(id);

        System.out.println("deleteCommentById - " + id + " : " + ans);

        return ans;
    }
}
