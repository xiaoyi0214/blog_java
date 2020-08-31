package com.xiaoyi.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by 小逸 on 2020/8/11.
 *
 * @author 小逸
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
//        int i = 9/0;

/*        String bolg = null;
        if(bolg == null){
            throw new NotFoundException("博客不存在");
        }*/
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
}
