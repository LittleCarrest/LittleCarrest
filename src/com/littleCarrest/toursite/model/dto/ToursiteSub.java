package com.littleCarrest.toursite.model.dto;

public class ToursiteSub {
	private String contentId;
	private String overview;
	private String homepage;
	
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
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	@Override
	public String toString() {
		return "ToursiteSub [contentId=" + contentId + ", overview=" + overview + ", homepage=" + homepage + "]";
	}

	
	
	
}
