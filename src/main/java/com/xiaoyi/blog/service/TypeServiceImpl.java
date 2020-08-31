package com.xiaoyi.blog.service;

import com.xiaoyi.blog.dao.TypeMapper;
import com.xiaoyi.blog.po.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 小逸 on 2020/8/17.
 *
 * @author 小逸
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Transactional
    @Override
    public int saveType(Type type) {
        return typeMapper.insert(type);
    }

    @Override
    public int deleteTpye(Long id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Type getType(Long id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.selectByName(name);
    }

    @Override
    public List<Type> getAllType() {
        return typeMapper.getAllType();
    }

    @Override
    public int updateType(Long id, Type type) {
        return typeMapper.updateByPrimaryKey(type);
    }
}
