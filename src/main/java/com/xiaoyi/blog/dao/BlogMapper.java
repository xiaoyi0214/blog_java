package com.xiaoyi.blog.dao;

import com.xiaoyi.blog.po.Blog;
import com.xiaoyi.blog.po.DetailedBlog;
import com.xiaoyi.blog.vo.BlogQuery;
import com.xiaoyi.blog.vo.FirstPageBlog;
import com.xiaoyi.blog.vo.RecommendBlog;
import com.xiaoyi.blog.vo.SearchBlog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogMapper {

    Blog getBlog(Long id);

    List<BlogQuery> getAllBlogQuery();

    List<BlogQuery> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog);


    int saveBlog(Blog blog);    //down

    int updateBlog(Blog blog);  //down

    int deleteBlog(Long id);  //down

    List<FirstPageBlog> getFirstPageBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    DetailedBlog getDetailedBlog(Long id);

    List<RecommendBlog> getAllRecommendBlog();


}