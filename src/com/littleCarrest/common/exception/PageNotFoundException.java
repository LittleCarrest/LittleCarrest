package com.littleCarrest.common.exception;

public class PageNotFoundException extends RuntimeException {
		
	private static final long serialVersionUID = 521587827126031031L;

	//기본 생성자
	public PageNotFoundException() {
		//stackTrace를 비워주자(console창 낭비) => 비어있는 stackTrace를 전달함으로써 콘솔창에 출력되지 않도록
		this.setStackTrace(new StackTraceElement[0]);
	}

	
}
