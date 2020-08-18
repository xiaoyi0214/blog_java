package com.xiaoyi.blog.dao;

import com.xiaoyi.blog.po.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TypeMapper {
    int deleteById(Long id);

    int saveType(Type record);

    int insertSelective(Type record);

    Type getType(Long id);

    int updateByPrimaryKeySelective(Type record);

    int updateType(Type record);
}