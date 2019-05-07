package com.platform.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Comment_likes {
    private Integer id;

    private Integer uid;

    private Integer cid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm" , timezone = "GMT+8")
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}