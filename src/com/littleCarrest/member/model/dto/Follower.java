package com.littleCarrest.member.model.dto;

public class Follower {
	
	private String followerIdx;
	private String userIdx;
	private String followerId;
	
	public String getFollowerIdx() {
		return followerIdx;
	}
	public void setFollowerIdx(String followerIdx) {
		this.followerIdx = followerIdx;
	}
	public String getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(String userIdx) {
		this.userIdx = userIdx;
	}
	public String getFollowerId() {
		return followerId;
	}
	public void setFollowerId(String followerId) {
		this.followerId = followerId;
	}
	@Override
	public String toString() {
		return "Follower [followerIdx=" + followerIdx + ", userIdx=" + userIdx + ", followerId=" + followerId + "]";
	}
	
	

}
