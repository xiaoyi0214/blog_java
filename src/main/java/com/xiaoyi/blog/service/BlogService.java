package com.xiaoyi.blog.service;

import com.xiaoyi.blog.po.Blog;
import com.xiaoyi.blog.vo.BlogQuery;
import com.xiaoyi.blog.vo.SearchBlog;

import java.util.List;

/**
 * Created by 小逸 on 2020/9/21.
 *
 * @author 小逸
 */
public interface BlogService {

    Blog getBlog(Long id);

    List<BlogQuery> getAllBlog();

    List<BlogQuery> getBlogBySearch(SearchBlog searchBlog); // 查询

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);

}
