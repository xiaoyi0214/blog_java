package com.xiaoyi.blog.service;

import com.github.pagehelper.Page;
import com.xiaoyi.blog.po.Type;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

/**
 * Created by 小逸 on 2020/8/17.
 *
 * @author 小逸
 */
public interface TypeService {

    Type saveType(Type type);

    void deleteTpye(Long id);

    Type getType(Long id);

    Page<Type> listType(SpringDataWebProperties.Pageable pageable);

    Type updateType(Long id, Type type);

}
