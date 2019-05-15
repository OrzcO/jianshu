package com.platform.dao;

import com.platform.entity.Search;

import java.util.List;

public interface SearchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Search record);

    int insertSelective(Search record);

    Search selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Search record);

    int updateByPrimaryKey(Search record);




    List<Search> getSearch(int id);

    List<String> getHotSearch(int cnt);

    int clear(int id);

    int clearAll(int uid);

    List<Search> getSearchTableInfo();

}