package com.littleCarrest.common.exception;

import com.littleCarrest.common.code.ErrorCode;

//예외처리가 강제되지 않는 UnCheckedException 
//DAO에서 SQLException 대신 DataAccessException을 반환해서, Service단에서 예외처리가 강제되는 것을 방지
public class DataAccessException extends HandleableException{

	private static final long serialVersionUID = 6889942025283782021L;

	public DataAccessException(Exception e) {
		super(ErrorCode.DATABASE_ACCESS_ERROR,e);
	}
}
