package com.xiaoyi.blog.service;

import com.github.pagehelper.Page;
import com.xiaoyi.blog.po.Type;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;

/**
 * Created by 小逸 on 2020/8/17.
 *
 * @author 小逸
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Override
    public Type saveType(Type type) {
        return null;
    }

    @Override
    public void deleteTpye(Long id) {

    }

    @Override
    public Type getType(Long id) {
        return null;
    }

    @Override
    public Page<Type> listType(SpringDataWebProperties.Pageable pageable) {
        return null;
    }

    @Override
    public Type updateType(Long id, Type type) {
        return null;
    }
}
