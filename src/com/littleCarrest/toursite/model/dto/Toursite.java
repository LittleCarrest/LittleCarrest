package com.littleCarrest.toursite.model.dto;

public class Toursite {

	private String toursiteIdx;
	private String addr;
	private String addrSpe;
	private String name;
	private String tel;
	private String image;
	private String mapx;
	private String mapy;
	private String booktour;
	private String typeid;
	
	public Toursite() {
		// TODO Auto-generated constructor stub
	}

	public String getToursiteIdx() {
		return toursiteIdx;
	}

	public void setToursiteIdx(String toursiteIdx) {
		this.toursiteIdx = toursiteIdx;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getBooktour() {
		return booktour;
	}

	public void setBooktour(String booktour) {
		this.booktour = booktour;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	@Override
	public String toString() {
		return "Toursite [toursiteIdx=" + toursiteIdx + ", addr=" + addr + ", addrSpe=" + addrSpe + ", name=" + name
				+ ", tel=" + tel + ", image=" + image + ", mapx=" + mapx + ", mapy=" + mapy + ", booktour=" + booktour
				+ ", typeid=" + typeid + "]";
	}
	
	
	
	
	
}
