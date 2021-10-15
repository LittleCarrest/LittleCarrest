package com.littleCarrest.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.littleCarrest.common.code.ErrorCode;
import com.littleCarrest.common.exception.HandleableException;
import com.littleCarrest.member.validator.JoinForm;
import com.littleCarrest.member.validator.ModifyForm;
import com.littleCarrest.mypage.validator.MypageForm;

public class ValidatorFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidatorFilter() {
        // TODO Auto-generated constructor stub
    }

	/** 
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String[] uriArr = httpRequest.getRequestURI().split("/");
		
		if(uriArr.length != 0) {
			
			String redirectURI = null;

			switch (uriArr[1]) {
				case "member":
					redirectURI = memberValidation(httpRequest, httpResponse, uriArr);
					break;
				case "mypage":
					redirectURI = mypageValidation(httpRequest, httpResponse, uriArr);
					break;
					
				case "community":
					redirectURI = communityValidation(httpRequest, httpResponse, uriArr);
					break;

				default:
					break;
			}
			if(redirectURI != null) {
				httpResponse.sendRedirect(redirectURI);
				return;
			}
		}
		
		chain.doFilter(request, response);
	}

	private String mypageValidation(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
		String redirectURI = null;
		MypageForm mypageForm = new MypageForm(httpRequest);
		
		switch (uriArr[2]) {
		case "edit": 
			if(!mypageForm.test()) {  
				redirectURI = "/mypage/edit-profile?err=1";	
			}
			break;		
		}
		return redirectURI;
	}

	private String communityValidation(HttpServletRequest httpRequest, HttpServletResponse httpResponse,String[] uriArr) {

		return null;
	}



	private String memberValidation(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
		String redirectURI = null;
		JoinForm joinForm = new JoinForm(httpRequest);;
		ModifyForm modifyForm = new ModifyForm(httpRequest);
		
		switch (uriArr[2]) {
		case "join":
			String password = httpRequest.getParameter("password");
			if(password == null) {
				redirectURI = "/index";
			}
			
			if(!joinForm.test()) {  
				redirectURI = "/member/join-page?err=1";	
			}break;

		case "join-impl":
			String persistToken = httpRequest.getParameter("persist-token");	
			if(!persistToken.equals(httpRequest.getSession().getAttribute("persist-token"))) {	
				throw new HandleableException(ErrorCode.AUTHENTICATION_FAILED_ERROR);
			}
			break;

		case "modify":
			if(!modifyForm.test()) {
				redirectURI = "/member/modify-page?err=1";
			}break;
		default:
			break;
		}
		return redirectURI;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
