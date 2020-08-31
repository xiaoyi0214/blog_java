package com.xiaoyi.blog.service;

import com.xiaoyi.blog.po.Type;

import java.util.List;

/**
 * Created by 小逸 on 2020/8/17.
 *
 * @author 小逸
 */
public interface TypeService {

    int saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    List<Type> getAllType();

    int updateType(Long id, Type type);

    int deleteTpye(Long id);

}
