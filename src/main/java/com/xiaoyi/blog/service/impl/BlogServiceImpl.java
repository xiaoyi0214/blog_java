package com.xiaoyi.blog.service.impl;

import com.xiaoyi.blog.dao.BlogMapper;
import com.xiaoyi.blog.po.Blog;
import com.xiaoyi.blog.service.BlogService;
import com.xiaoyi.blog.vo.BlogQuery;
import com.xiaoyi.blog.vo.SearchBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by 小逸 on 2020/9/21.
 *
 * @author 小逸
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Blog getBlog(Long id) {
        return blogMapper.getBlog(id);
    }

    @Override
    public List<BlogQuery> getAllBlog() {
        return blogMapper.getAllBlogQuery();
    }

    @Override
    public List<BlogQuery> getBlogBySearch(SearchBlog searchBlog) {
        return blogMapper.searchByTitleOrTypeOrRecommend(searchBlog);
    }


    @Transactional
    @Override
    public int saveBlog(Blog blog) {
        if (blog.getId() == null){
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
            blog.setCommentCount(0);
            return blogMapper.saveBlog(blog);
        }else {
            blog.setUpdateTime(new Date());
            return blogMapper.updateBlog(blog);
        }

    }

    @Transactional
    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Transactional
    @Override
    public int deleteBlog(Long id) {
        return blogMapper.deleteBlog(id);
    }


}
