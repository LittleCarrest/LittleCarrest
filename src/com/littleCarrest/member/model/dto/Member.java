package com.littleCarrest.member.model.dto;

import java.sql.Date;

import com.littleCarrest.common.file.FileDTO;


public class Member {
	
	private String userIdx;
	private String userName;
	private String userId;
	private String password;
	private String email;
	private String nickname;
	private Date regDate;
	private String info;
	private String profile;
	private String socialLogin;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	
	public String getUserIdx() {
		return userIdx;
	}


	public void setUserIdx(String userIdx) {
		this.userIdx = userIdx;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getProfile() {
		return profile;
	}
	
	public void setProfile(String profile) {
		this.profile = profile;
	}

	public void setProfile(FileDTO profile) {
		if(profile.getSavePath() == null) {
			this.profile = null;
		}else {
			this.profile = profile.getSavePath() + profile.getRenameFileName();

		}
	}

	public String getSocialLogin() {
		return socialLogin;
	}

	public void setSocialLogin(String socialLogin) {
		this.socialLogin = socialLogin;
	}
	
	


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "Member [userIdx=" + userIdx + ", userName=" + userName + ", userId=" + userId + ", password=" + password
				+ ", email=" + email + ", nickname=" + nickname + ", regDate=" + regDate + ", info=" + info
				+ ", profile=" + profile + ", socialLogin=" + socialLogin + "]";
	}


}
