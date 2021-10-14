package com.littleCarrest.member.model.dto;

import java.sql.Date;


public class Member {
	
	private String userId;
	private String password;
	private String email;
	private String nickname;
	private String tel;
	private String address;
	private Date regDate;
	private String info;
	private String profile;
	private String socialLogin;
	
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getSocialLogin() {
		return socialLogin;
	}
	public void setSocialLogin(String socialLogin) {
		this.socialLogin = socialLogin;
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", email=" + email + ", nickname=" + nickname
				+ ", tel=" + tel + ", address=" + address + ", regDate=" + regDate + ", info=" + info + ", profile="
				+ profile + ", socialLogin=" + socialLogin + "]";
	}

}
