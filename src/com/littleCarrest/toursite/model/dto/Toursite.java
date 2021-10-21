package com.littleCarrest.toursite.model.dto;

public class Toursite {

	private String contentId;
	private String addr;
	private String name;
	private String image;
	private String mapx;
	private String mapy;
	
	
	public Toursite() {
		// TODO Auto-generated constructor stub
	}


	public String getContentId() {
		return contentId;
	}


	public void setContentId(String contentId) {
		this.contentId = contentId;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getMapx() {
		return mapx;
	}


	public void setMapx(String mapx) {
		this.mapx = mapx;
	}


	public String getMapy() {
		return mapy;
	}


	public void setMapy(String mapy) {
		this.mapy = mapy;
	}


	@Override
	public String toString() {
		return "Toursite [contentId=" + contentId + ", addr=" + addr + ", name=" + name + ", image=" + image + ", mapx="
				+ mapx + ", mapy=" + mapy + "]";
	}

	
	
	
	
	
	
	
}
