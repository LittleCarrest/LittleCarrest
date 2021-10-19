package com.littleCarrest.festival.model.dto;

public class FestivalDto {

	private String festivalIdx;
	private String name;
	private String startDate;
	private String endDate;
	private String tel;
	private String mapx;
	private String mapy;
	private String image;
	private String address;
	
	public FestivalDto() {
		// TODO Auto-generated constructor stub
	}

	public String getFestivalIdx() {
		return festivalIdx;
	}

	public void setFestivalIdx(String festivalIdx) {
		this.festivalIdx = festivalIdx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EventDto [festivalIdx=" + festivalIdx + ", name=" + name + ", startDate=" + startDate + ", endDate="
				+ endDate + ", tel=" + tel + ", mapx=" + mapx + ", mapy=" + mapy + ", image=" + image + ", address="
				+ address + "]";
	}
	
	
	
	

	
	
	
	
	
	
	
	
}
