package com.xiaoyi.blog.web.admin;

import com.xiaoyi.blog.handler.ControllerExceptionHandler;
import com.xiaoyi.blog.po.User;
import com.xiaoyi.blog.service.UserService;
import com.xiaoyi.blog.util.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by 小逸 on 2020/8/14.
 *
 * @author 小逸
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
    private  final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes){
        User user = userService.checkUser(username, MD5Utils.code(password));
        if (user != null){
            user.setPassword(null); // 密码不保存
            session.setAttribute("user", user); // 保持登录状态
            return "admin/index";
        } else {

            // return "admin/login";  // 这种方式会有问题
            attributes.addFlashAttribute("message", "用户名或密码错误！");
            // model.addAttribute("message","用户名或密码错误！"); // 重定向用model有问题
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
