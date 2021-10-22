package com.littleCarrest.community.model.dto;

import java.sql.Date;

import com.littleCarrest.common.file.FileDTO;

public class Community {
	
	private String bdIdx;
	private String userIdx;
	private String nickname;
	private String content;
	private Date regDate;
	private int liked;
	private String category;
	private String tagIdx;
	private int isDel;
	
	public String getBdIdx() {
		return bdIdx;
	}
	public void setBdIdx(String bdIdx) {
		this.bdIdx = bdIdx;
	}
	public String getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(String userIdx) {
		this.userIdx = userIdx;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getLiked() {
		return liked;
	}
	public void setLiked(int liked) {
		this.liked = liked;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTagIdx() {
		return tagIdx;
	}
	public void setTagIdx(String tagIdx) {
		this.tagIdx = tagIdx;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	@Override
	public String toString() {
		return "Community [bdIdx=" + bdIdx + ", userIdx=" + userIdx + ", nickname=" + nickname + ", content=" + content
				+ ", regDate=" + regDate + ", liked=" + liked + ", category=" + category + ", tagIdx=" + tagIdx
				+ ", isDel=" + isDel + "]";
	}
	

	
	
}
