package com.littleCarrest.common.code;

public enum Config {

	//DOMAIN("http://www.littleCarrest.com"),
	DOMAIN("http://localhost:7070"),
	SMTP_AUTHENTICATION_ID("littlecarrest@gmail.com"),
	SMTP_AUTHENTICATION_PASSWORD("rladbswjd2"),
	OFFICIAL_MAIL("littlecarrest@gmail.com"),
	COMPANY_EMAIL("littlecarrest@gmail.com"),
	//UPLOAD_PATH("C:\\CODE\\after\\upload\\"); 운영서버
	UPLOAD_PATH("C:\\littlecarrest\\upload\\"); //개발서버
	
	public final String DESC;
	
	private Config(String desc) {
		this.DESC = desc;
	}
}
