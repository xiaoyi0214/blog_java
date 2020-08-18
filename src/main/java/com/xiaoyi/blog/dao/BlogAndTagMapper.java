package com.xiaoyi.blog.dao;

import com.xiaoyi.blog.po.BlogAndTag;

public interface BlogAndTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogAndTag record);

    int insertSelective(BlogAndTag record);

    BlogAndTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogAndTag record);

    int updateByPrimaryKey(BlogAndTag record);
}