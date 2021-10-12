package com.littleCarrest.community.model.dto;

import java.sql.Date;

public class Community {
	
	private String bdIdx;
	private String userId;
	private String nickname;
	private String title;
	private String subject;
	private String content;
	private Date regDate;
	private int viewCnt;
	private int liked;
	private String profileSavePath;
	private String profileRenameFileName;
	
	public String getBdIdx() {
		return bdIdx;
	}
	public void setBdIdx(String bdIdx) {
		this.bdIdx = bdIdx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}	
	public int getLiked() {
		return liked;
	}
	public void setLiked(int liked) {
		this.liked = liked;
	}
	public String getProfileSavePath() {
		return profileSavePath;
	}
	public void setProfileSavePath(String profileSavePath) {
		this.profileSavePath = profileSavePath;
	}
	public String getProfileRenameFileName() {
		return profileRenameFileName;
	}
	public void setProfileRenameFileName(String profileRenameFileName) {
		this.profileRenameFileName = profileRenameFileName;
	}
	@Override
	public String toString() {
		return "Community [bdIdx=" + bdIdx + ", userId=" + userId + ", nickname=" + nickname + ", title=" + title
				+ ", subject=" + subject + ", content=" + content + ", regDate=" + regDate + ", viewCnt=" + viewCnt
				+ ", liked=" + liked + ", profileSavePath=" + profileSavePath + ", profileRenameFileName="
				+ profileRenameFileName + "]";
	}




}
