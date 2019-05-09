package com.platform.action;


import com.platform.entity.Search;
import com.platform.service.SearchService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/search/")
public class SearchController {


    @Resource(name = "searchService")
    SearchService searchService;


    @ResponseBody
    @RequestMapping("getSearch.action")
    public List<Search> getSearch(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        List<Search> list = searchService.getSearch(id);

        System.out.println("getSearch.action " + id + " : " + list.size());

        return list;
    }


    @ResponseBody
    @RequestMapping("getHotSearch.action")
    public List<String> getHotSearch(HttpServletRequest httpServletRequest) {

//        简单分页
        int cnt = Integer.parseInt(httpServletRequest.getParameter("cnt")) * 5;

        List<String> list = searchService.getHotSearch(cnt);

        System.out.println("getHotSearch.action " + cnt + " : " + list.size());

        return list;
    }


    @ResponseBody
    @RequestMapping("searchInsert.action")
    public int searchInsert(HttpServletRequest httpServletRequest) {

        Search search = new Search();

        String info = httpServletRequest.getParameter("info");

        if (httpServletRequest.getParameter("id") != null) {
            search.setUid(Integer.parseInt(httpServletRequest.getParameter("id")));
        }


        search.setInfo(info);
        search.setTime(new Date());

        int ans = searchService.searchInsert(search);

        System.out.println("searchInsert.action " + info + "  : " + ans);

        return ans;
    }

    @ResponseBody
    @RequestMapping("clear.action")
    public int clear(HttpServletRequest httpServletRequest) {

        int id = Integer.parseInt(httpServletRequest.getParameter("id"));

        int ans = searchService.clear(id);

        System.out.println("clear.action " + id + "  : " + ans);

        return ans;
    }

    @ResponseBody
    @RequestMapping("clearAll.action")
    public int clearAll(HttpServletRequest httpServletRequest) {

        int uid = Integer.parseInt(httpServletRequest.getParameter("uid"));

        int ans = searchService.clearAll(uid);

        System.out.println("clearAll.action " + uid + "  : " + ans);

        return ans;
    }

}
