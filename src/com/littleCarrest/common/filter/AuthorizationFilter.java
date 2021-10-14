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
import com.littleCarrest.community.model.dto.Community;
import com.littleCarrest.community.model.service.CommunityService;
import com.littleCarrest.member.model.dto.Member;
import com.littleCarrest.member.model.service.MemberService;

public class AuthorizationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorizationFilter() {
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
			switch (uriArr[1]) {
				case "member":
					memberAuthorize(httpRequest, httpResponse, uriArr);
					break;
				case "community":
					communityAuthorize(httpRequest, httpResponse, uriArr);
					break;
				default:
					break;
			}
		}
		
		chain.doFilter(request, response);
	}

	
	private void communityAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
		switch (uriArr[2]) {
		//세션 인증 + IS_HOST == N일때만 접근 가능
		case "schedule-form": 	//글작성
			if(httpRequest.getSession().getAttribute("authentication") == null) {
				throw new HandleableException(ErrorCode.REDIRECT_LOGIN_PAGE);
			}
			break;
		case "upload":
			if(httpRequest.getSession().getAttribute("authentication") == null) {
				throw new HandleableException(ErrorCode.REDIRECT_LOGIN_PAGE);
			}
			break;
		case "edit":
			if(httpRequest.getSession().getAttribute("authentication") == null) {
				throw new HandleableException(ErrorCode.REDIRECT_LOGIN_PAGE);
			}
			communityHostIsSame(httpRequest,httpResponse,httpRequest.getParameter("scIdx"));
		case "delete":
			if(httpRequest.getSession().getAttribute("authentication") == null) {
				throw new HandleableException(ErrorCode.REDIRECT_LOGIN_PAGE);
			}
			communityHostIsSame(httpRequest,httpResponse,httpRequest.getParameter("scIdx"));
			break;
		default:
			break;
		}		
				
		
	}

	private void communityHostIsSame(HttpServletRequest httpRequest, HttpServletResponse httpResponse,	String scIdx) {
		Member member = (Member) httpRequest.getSession().getAttribute("authentication");
		
		CommunityService scheduleService = new CommunityService();
	
//		
//		Community community = (Community) scheduleService.getBoardDetail(scIdx).get("schedule");
//		if(!member.getUserId().equals(community.getUserId())) {
//			throw new HandleableException(ErrorCode.UNAUTHORIZED_PAGE);
//		}
		
	}

	private void boardAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
		Member member = (Member) httpRequest.getSession().getAttribute("authentication");

		switch (uriArr[2]) {
		case "board-form": 
			if(member == null) {
				throw new HandleableException(ErrorCode.REDIRECT_LOGIN_PAGE);
			}
			break;
		case "upload":
			if(member == null) {
				throw new HandleableException(ErrorCode.REDIRECT_LOGIN_PAGE);
			}
			break;
		case "delete-board":
			if(member == null) {
				throw new HandleableException(ErrorCode.REDIRECT_LOGIN_PAGE);
			}
//			if(authWriter(httpRequest,httpResponse,member, "board", httpRequest.getParameter("bd_idx"))) {
//				throw new HandleableException(ErrorCode.UNMATCHED_USER_AUTH_ERROR);
//			}
			break;
//		로그인 유저 == 작성자 비교 후 edit요청이 들어오는 경우
//		case "edit":
//			if(httpRequest.getSession().getAttribute("authentication") == null) {
//				throw new HandleableException(ErrorCode.REDIRECT_LOGIN_PAGE);
//			}
//			authBoardEditor(httpRequest,httpResponse);
//			break;
			
		default:
			break;
		}
	}
//	
//	private boolean authWriter(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Member member, String table, String idx) {
//		BoardService boardService = new BoardService();
//		String userId = boardService.getWriterId(table, idx);
//		
//		if(member.getUserId().equals(userId)) {
//			return false;
//		}else {
//			return true;
//		}
//		
//	}

	private void memberAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
		
		switch (uriArr[2]) {
		//가입시 이메일 인증절차(email-template)
		case "join-impl":
			String serverToken = httpRequest.getParameter("persist-token");
			String clientToken = httpRequest.getParameter("persist-token");
			
			if(serverToken == null || !serverToken.equals(clientToken)) {
				//같지않으면,
				throw new HandleableException(ErrorCode.AUTHENTICATION_FAILED_ERROR);
			}
			break;
		case "mypage":
			if(httpRequest.getSession().getAttribute("authentication") == null) {
				throw new HandleableException(ErrorCode.REDIRECT_LOGIN_PAGE);
			}
		default:
			break;
		}
		
	}

	


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
