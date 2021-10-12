package com.littleCarrest.common.wrapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestWrapper extends HttpServletRequestWrapper{
	
	private HttpServletRequest request;		// 초기화

	public RequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;	
	}
	
	
	//매번 uriArr[]를 만들어야하는 번거로움을 줄이기 위해 메서드화 하자
	//나중에 쓸 때 다운casting해서 이 메서드를 가져다 쓸 수 있다.
	//*********************** 왜 다운캐스팅이지???
	public String[] getRequestURIArray() {
		String uri = this.getRequestURI();
		String[] uriArr = uri.split("/");
		return uriArr;
	}
	
	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		return request.getRequestDispatcher("/WEB-INF/views/" + path +".jsp");
	}
	public RequestDispatcher getRequestDispatcher(String path, String prefix, String suffix) {
		return request.getRequestDispatcher(prefix + path + suffix);
	}

}
