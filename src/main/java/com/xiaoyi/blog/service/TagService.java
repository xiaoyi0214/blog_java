package com.xiaoyi.blog.service;

import com.xiaoyi.blog.po.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 小逸 on 2020/8/31.
 *
 * @author 小逸
 */
public interface TagService {

    int saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    List<Tag> getAllTag();

    int updateTag(Tag tag);

    int deleteTag(Long id);
}
