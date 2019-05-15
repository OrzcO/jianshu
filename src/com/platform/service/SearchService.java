package com.platform.service;

import com.platform.dao.SearchMapper;
import com.platform.entity.Search;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "searchService")
public class SearchService {

    @Resource(name = "searchMapper")
    SearchMapper searchMapper;


    public List<Search> getSearch(int id) {
        return searchMapper.getSearch(id);
    }

    public List<String> getHotSearch(int id) {
        return searchMapper.getHotSearch(id);
    }

    public int searchInsert(Search search) {
        return searchMapper.insertSelective(search);
    }

    public int clear(int id) {
        return searchMapper.clear(id);
    }

    public int clearAll(int uid) {
        return searchMapper.clearAll(uid);
    }

    public List<Search> getSearchTableInfo(){
        return searchMapper.getSearchTableInfo();
    }

    public int deleteSearchById(int id) {
        return searchMapper.deleteByPrimaryKey(id);
    }
}
