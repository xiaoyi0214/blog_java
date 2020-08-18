package com.xiaoyi.blog.service;

import com.xiaoyi.blog.dao.UserMapper;
import com.xiaoyi.blog.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 小逸 on 2020/8/14.
 *
 * @author 小逸
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        User user = userMapper.queryByUsernameAndPassword(username, password);
        return user;
    }
}
