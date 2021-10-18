package com.littleCarrest.tour.model.dto;

public class TourDto {

	private String cpIdx;
	private String cpName;
	private String lineIntro;
	private String intro;
	private String status;
	private String addr;
	private String addrSpe;
	private String mapx;
	private String mapy;
	private String tel;
	private String homepage;
	private String location;
	public String getCpIdx() {
		return cpIdx;
	}
	public void setCpIdx(String cpIdx) {
		this.cpIdx = cpIdx;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getLineIntro() {
		return lineIntro;
	}
	public void setLineIntro(String lineIntro) {
		this.lineIntro = lineIntro;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddrSpe() {
		return addrSpe;
	}
	public void setAddrSpe(String addrSpe) {
		this.addrSpe = addrSpe;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "CampingSearch [cpIdx=" + cpIdx + ", cpName=" + cpName + ", lineIntro=" + lineIntro + ", intro=" + intro
				+ ", status=" + status + ", addr=" + addr + ", addrSpe=" + addrSpe + ", mapx=" + mapx + ", mapy=" + mapy
				+ ", tel=" + tel + ", homepage=" + homepage + ", location=" + location + "]";
	}

	
	
	
	
	
	
	
	
}
