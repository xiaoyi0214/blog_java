package com.xiaoyi.blog.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyi.blog.po.DetailedBlog;
import com.xiaoyi.blog.service.BlogService;
import com.xiaoyi.blog.vo.FirstPageBlog;
import com.xiaoyi.blog.vo.RecommendBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by 小逸 on 2020/8/11.
 *
 * @author 小逸
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    // 分页查询博客首页列表
    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, RedirectAttributes attributes){
        PageHelper.startPage(pageNum, 10);
        List<FirstPageBlog> allFirstPageBlog = blogService.getAllFirstPageBlog();
        List<RecommendBlog> recommendBlog = blogService.getAllRecommendBlog();

        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("recommendedBlogs", recommendBlog);
        return "index";
    }

    // 首页搜索博客
    @PostMapping("/search")
    public String indexSearch(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, @RequestParam String query){
        PageHelper.startPage(pageNum, 20);
        List<FirstPageBlog> searchBlog = blogService.getSearchBlog(query);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }
    // 博客详情页
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model){
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
        model.addAttribute("blog",detailedBlog);
        return "blog";
    }
}
