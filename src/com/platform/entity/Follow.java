package com.platform.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Follow {
    private Integer id;

    private Integer followFrom;

    private Integer followTo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm" , timezone = "GMT+8")
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFollowFrom() {
        return followFrom;
    }

    public void setFollowFrom(Integer followFrom) {
        this.followFrom = followFrom;
    }

    public Integer getFollowTo() {
        return followTo;
    }

    public void setFollowTo(Integer followTo) {
        this.followTo = followTo;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}