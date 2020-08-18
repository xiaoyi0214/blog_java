package com.xiaoyi.blog.po;

import java.util.Date;

public class BlogWithBLOBs extends Blog {
    private String content;

    private String description;

    public BlogWithBLOBs(Long id, String title, String firstPicture, String flag, Integer views, Integer appreciation, Integer shareStatement, Integer commentabled, Integer published, Integer recommend, Date createTime, Date updateTime, Long typeId, Long userId, String tagIds, String content, String description) {
        super(id, title, firstPicture, flag, views, appreciation, shareStatement, commentabled, published, recommend, createTime, updateTime, typeId, userId, tagIds);
        this.content = content;
        this.description = description;
    }

    public BlogWithBLOBs() {
        super();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}