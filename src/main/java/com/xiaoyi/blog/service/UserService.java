package com.xiaoyi.blog.service;

import com.xiaoyi.blog.po.User;

/**
 * Created by 小逸 on 2020/8/14.
 *
 * @author 小逸
 */
public interface UserService {

    User checkUser(String username, String password);
}
