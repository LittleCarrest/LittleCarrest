package com.littleCarrest.common.file;

import java.sql.Date;

public class FileDTO {
	
	private String flIdx;
	private String typeIdx;
	private String originFileName;
	private String renameFileName;
	private String savePath;
	private Date regDate;
	private int is_del;
	
	public FileDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFlIdx() {
		return flIdx;
	}

	public void setFlIdx(String flIdx) {
		this.flIdx = flIdx;
	}

	public String getTypeIdx() {
		return typeIdx;
	}

	public void setTypeIdx(String typeIdx) {
		this.typeIdx = typeIdx;
	}

	public String getOriginFileName() {
		return originFileName;
	}

	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}

	public String getRenameFileName() {
		return renameFileName;
	}

	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	public int getIs_del() {
		return is_del;
	}

	public void setIs_del(int is_del) {
		this.is_del = is_del;
	}



	@Override
	public String toString() {
		return "FileDTO [flIdx=" + flIdx + ", typeIdx=" + typeIdx + ", originFileName=" + originFileName
				+ ", renameFileName=" + renameFileName + ", savePath=" + savePath + ", regDate=" + regDate + ", is_del="
				+ is_del + "]";
	}

	public String getDownloadURL() { 
		return "/file/" + savePath + renameFileName + "?originName=" + originFileName;
	}
	
}
