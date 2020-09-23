package com.xiaoyi.blog.po;

import java.util.Date;

public class BlogWithBLOBs extends Blog {
    private String content;

    private String description;


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