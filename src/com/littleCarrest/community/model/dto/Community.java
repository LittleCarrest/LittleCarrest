package com.littleCarrest.community.model.dto;

import java.sql.Date;

import com.littleCarrest.common.file.FileDTO;

public class Community {
	
	private String bdIdx;
	private String user_idx;
	private String nickname;
	private String content;
	private Date regDate;
	private int liked;
	private String category;
	private String tag_idx;
	private int is_del;
	private String picture;
	
	public String getBdIdx() {
		return bdIdx;
	}
	public void setBdIdx(String bdIdx) {
		this.bdIdx = bdIdx;
	}
	public String getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(String user_idx) {
		this.user_idx = user_idx;
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
	public String getTag_idx() {
		return tag_idx;
	}
	public void setTag_idx(String tag_idx) {
		this.tag_idx = tag_idx;
	}
	public int getIs_del() {
		return is_del;
	}
	public void setIs_del(int is_del) {
		this.is_del = is_del;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(FileDTO fileDTO) {
		if(fileDTO.getSavePath() == null) {
			this.picture = null;
		}else {
			this.picture = fileDTO.getSavePath() + fileDTO.getRenameFileName();

		}
	}
	
	@Override
	public String toString() {
		return "Community [bdIdx=" + bdIdx + ", user_idx=" + user_idx + ", nickname=" + nickname + ", content="
				+ content + ", regDate=" + regDate + ", liked=" + liked + ", category=" + category + ", tag_idx="
				+ tag_idx + ", is_del=" + is_del + ", picture=" + picture + "]";
	}


	
}
