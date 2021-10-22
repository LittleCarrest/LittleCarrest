package com.littleCarrest.toursite.model.dto;

public class ToursiteSub {
	private String contentId;
	private String overview;
	
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	@Override
	public String toString() {
		return "ToursiteSub [contentId=" + contentId + ", overview=" + overview + "]";
	}
	
	
	
}
