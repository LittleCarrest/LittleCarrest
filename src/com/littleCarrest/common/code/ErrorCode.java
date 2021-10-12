package com.littleCarrest.common.code;

public enum ErrorCode {
	
	DATABASE_ACCESS_ERROR("데이터베이스와 통신 중 에러가 발생하였습니다."),
	FAILED_VALIDATED_ERROR("데이터의 양식이 적합하지 않습니다."),
	MAIL_SEND_FAIL_ERROR("이메일 발송 중 에러가 발생하였습니다."),
	HTTP_CONNECT_ERROR("HTTP 통신 중 에러가 발생하였습니다."),
	AUTHENTICATION_FAILED_ERROR("유효하지 않은 인증입니다."),
	UNAUTHORIZED_PAGE("접근 권한이 없는 페이지 입니다.","/member/login-page"),
	REDIRECT_LOGIN_PAGE("로그인이 필요합니다.","/member/login-page"),
	FAILED_FILE_UPLOAD_ERROR("파일업로드에 실패했습니다."),
	UNEXIST_USER_ERROR("존재하지 않는 회원입니다."),
	UNMATCHED_USER_AUTH_ERROR("작성자가 아닙니다.");
	
	//ErrorCode enum클래스로부터 접근가능한 속성들
	public final String MESSAGE;
	public final String URL;

	ErrorCode(String msg){
		this.MESSAGE = msg;
		this.URL = "/index";	//생성자로써 상수들을 초기화해줘야 함
	}
	
	ErrorCode(String msg,String url){
		this.MESSAGE = msg;
		this.URL = url;
	}	
}
