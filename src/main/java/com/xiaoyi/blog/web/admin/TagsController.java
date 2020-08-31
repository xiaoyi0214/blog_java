package com.xiaoyi.blog.web.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyi.blog.po.Tag;
import com.xiaoyi.blog.service.TagService;
import com.xiaoyi.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by 小逸 on 2020/8/27.
 *
 * @author 小逸
 */
@Controller
@RequestMapping("/admin")
public class TagsController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")           //Model是thymeleaf的内容，是前端的页面展示模型，并用来传值。这一段是分页处理。
    public String types(@RequestParam(required = false, defaultValue = "1", value = "pagenum")int pagenum, Model model){
        PageHelper.startPage(pagenum, 5);
        List<Tag> allType = tagService.getAllTag();
        //得到分页结果对象
        PageInfo<Tag> pageInfo = new PageInfo<>(allType);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String toAddTag(Model model){
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }

    @GetMapping("/tags/{id}/input")
    public String toAddTag(@PathVariable Long id, Model model){
        model.addAttribute("tag", tagService.getTag(id));
        return "admin/tags-input";
    }

    @PostMapping("/tags")
    public String addTag(Tag tag,  RedirectAttributes attributes ){
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null){
            attributes.addFlashAttribute("msg", "不能添加重复的标签");
            return "redirect:/admin/tags/input";
        }else {
            attributes.addFlashAttribute("msg", "添加成功");
            tagService.saveTag(tag);
            return "redirect:/admin/tags";
        }
    }

    @PostMapping("/tags/{id}")
    public String addTag(@PathVariable Long id, Tag tag, RedirectAttributes attributes){
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 !=null){
            if (tag1.getId().equals(id)){
                attributes.addFlashAttribute("msg", "您未做更改");
            }else {
                attributes.addFlashAttribute("msg", "已存在相同的标签");
            }
            return "redirect:/admin/tags/input";
        }else {
            attributes.addFlashAttribute("msg", "添加成功");
            tagService.updateTag(tag);
            return "redirect:/admin/tags";
        }
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/tags";
    }






}
