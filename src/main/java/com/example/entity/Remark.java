package com.example.entity;

public class Remark {
	private Integer id;
	
	private String content;
	
    private String accid;//用户名
    
    private String username;//用户昵称

    private String userphoto;//头像

    private String currentPosition;//评论位置

    private String createTime;//创建时间

    private Integer forumId;//论坛id
    
    private Integer woundful;//点赞
    
    private Integer stamp;//踩
    
    private Integer star;//评分
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid == null ? null : accid.trim();
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto == null ? null : userphoto.trim();
    }

    public Integer getWoundful() {
        return woundful;
    }

    public void setWoundful(Integer woundful) {
        this.woundful = woundful;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getStamp() {
        return stamp;
    }

    public void setStamp(Integer stamp) {
        this.stamp = stamp ;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition == null ? null : currentPosition.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getstar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }
}
