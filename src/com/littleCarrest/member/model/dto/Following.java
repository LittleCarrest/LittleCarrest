package com.littleCarrest.member.model.dto;

public class Following {
	
	private String followingIdx;
	private String userIdx;
	private String followingId;
	
	public String getFollowingIdx() {
		return followingIdx;
	}
	public void setFollowingIdx(String followingIdx) {
		this.followingIdx = followingIdx;
	}
	public String getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(String userIdx) {
		this.userIdx = userIdx;
	}
	public String getFollowingId() {
		return followingId;
	}
	public void setFollowingId(String followingId) {
		this.followingId = followingId;
	}
	@Override
	public String toString() {
		return "Following [followingIdx=" + followingIdx + ", userIdx=" + userIdx + ", followingId=" + followingId
				+ "]";
	}
	
	
	
}
