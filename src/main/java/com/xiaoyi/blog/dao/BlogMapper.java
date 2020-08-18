package com.xiaoyi.blog.dao;

import com.xiaoyi.blog.po.Blog;
import com.xiaoyi.blog.po.BlogWithBLOBs;

public interface BlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BlogWithBLOBs record);

    int insertSelective(BlogWithBLOBs record);

    BlogWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BlogWithBLOBs record);

    int updateByPrimaryKey(Blog record);
}