package com.xiaoyi.blog.web.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyi.blog.po.Blog;
import com.xiaoyi.blog.po.User;
import com.xiaoyi.blog.service.BlogService;
import com.xiaoyi.blog.service.TagService;
import com.xiaoyi.blog.service.TypeService;
import com.xiaoyi.blog.vo.BlogQuery;
import com.xiaoyi.blog.vo.SearchBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 小逸 on 2020/8/17.
 *
 * @author 小逸
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;


    @GetMapping("/blogs")
    public String blogs(@RequestParam(required = false, defaultValue = "1", value = "pagenum") int pageNum,
                        Model model){
        //按照排序字段 倒序 排序
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum,10,orderBy);
        List<BlogQuery> list = blogService.getAllBlog();
        PageInfo<BlogQuery> pageInfo = new PageInfo<BlogQuery>(list);
        model.addAttribute("types",typeService.getAllType());
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String search(SearchBlog searchBlog,Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        List<BlogQuery> blogBySearch = blogService.getBlogBySearch(searchBlog);
        PageHelper.startPage(pageNum, 5);
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogBySearch);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/blogs :: blogList"; // 只更新blogList
    }

    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/blogs";

    }

    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("tags", tagService.getAllTag());
        model.addAttribute("types", typeService.getAllType());
        model.addAttribute("blog", new Blog());
        return "admin/blogs-input";
    }

    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("tags", tagService.getAllTag());
        model.addAttribute("types", typeService.getAllType());
        model.addAttribute("blog", blogService.getBlog(id));
        return "admin/blogs-input";
    }

    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){
        blog.setUser((User) session.getAttribute("user"));
        //设置blog的type
        blog.setType(typeService.getType(blog.getType().getId()));
        //设置blog中typeId属性
        blog.setTypeId(blog.getType().getId());
        //设置用户id
        blog.setUserId(blog.getUser().getId());

        int b = blogService.saveBlog(blog);
        if(b == 0){
            attributes.addFlashAttribute("message", "新增失败");
        }else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/blogs";
    }

}
