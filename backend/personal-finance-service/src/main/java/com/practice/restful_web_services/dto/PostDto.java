package com.practice.restful_web_services.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PostDto {
    private String id;
    private String content;
    private String mediaUrl;
    private LocalDateTime createdDate;
    private String userId;
    private List<String> likeIds;
    private List<String> commentIds;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMediaUrl() {
		return mediaUrl;
	}
	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<String> getLikeIds() {
		return likeIds;
	}
	public void setLikeIds(List<String> likeIds) {
		this.likeIds = likeIds;
	}
	public List<String> getCommentIds() {
		return commentIds;
	}
	public void setCommentIds(List<String> commentIds) {
		this.commentIds = commentIds;
	}

}
