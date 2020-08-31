package com.xiaoyi.blog.service;

import com.xiaoyi.blog.dao.TagMapper;
import com.xiaoyi.blog.po.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 小逸 on 2020/8/31.
 *
 * @author 小逸
 */
@Service
public class TagServiceImpl implements TagService{

    @Autowired
    private TagMapper tagMapper;

    @Override
    public int saveTag(Tag tag) {
        return tagMapper.insert(tag);
    }

    @Override
    public Tag getTag(Long id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.selectByTagName(name);
    }

    @Override
    public List<Tag> getAllTag() {
        return tagMapper.getAllTag();
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateByPrimaryKey(tag);
    }

    @Override
    public int deleteTag(Long id) {
        return tagMapper.deleteByPrimaryKey(id);
    }
}
