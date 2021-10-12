package com.littleCarrest.common.exception;

import com.littleCarrest.common.code.ErrorCode;

public class HandleableException extends RuntimeException{

	private static final long serialVersionUID = 7847451612288681161L;
	
	public ErrorCode error;
	
	//log를 남기지 않고 사용자에게 알림메세지만 전달하는 용도의 생성자
	public HandleableException(ErrorCode error) {
		this.error = error;
		this.setStackTrace(new StackTraceElement[0]); //stackTrace를 비워준다.
	}
	
	public HandleableException(ErrorCode error, Exception e) {
		this.error = error;
		e.printStackTrace();
		this.setStackTrace(new StackTraceElement[0]); //stackTrace를 비워준다.
	}

}
