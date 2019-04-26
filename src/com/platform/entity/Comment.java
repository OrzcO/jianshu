package com.platform.entity;

import java.util.Date;

public class Comment {
    private Integer id;

    private Integer aid;

    private String commentFrom;

    private String commentTo;

    private Integer depth;

    private String info;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getCommentFrom() {
        return commentFrom;
    }

    public void setCommentFrom(String commentFrom) {
        this.commentFrom = commentFrom == null ? null : commentFrom.trim();
    }

    public String getCommentTo() {
        return commentTo;
    }

    public void setCommentTo(String commentTo) {
        this.commentTo = commentTo == null ? null : commentTo.trim();
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}