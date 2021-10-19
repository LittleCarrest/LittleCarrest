package com.littleCarrest.member.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.littleCarrest.member.model.service.MemberService;


public class KakaoJoinForm {
	
	private String nickname;
	private String userName;
	private String kakaoId;
	private HttpServletRequest request;	
	private MemberService memberService = new MemberService();
	private Map<String,String> failedAttrubute =  new HashMap<String,String>();
	
	public KakaoJoinForm(ServletRequest request) {
		this.request = (HttpServletRequest) request;
		this.nickname = request.getParameter("nickname");
		this.userName = request.getParameter("userName");
		this.kakaoId = request.getParameter("kakaoId");
	}
	
	public boolean test() {
		boolean isFailed = false;
		
		if(userName.trim().isEmpty()) {
			failedAttrubute.put("userName",userName);
			isFailed = true;
		}
		
		if(memberService.selectMemberByNickname(nickname) != null || nickname.trim().isEmpty()) {
			failedAttrubute.put("nickname",nickname);
			isFailed = true;
		}
		
		if(isFailed) {
			request.getSession().setAttribute("joinValid", failedAttrubute);	//joinFailed에 검증실패한 값 저장
			request.getSession().setAttribute("joinForm", this);	//사용자 입력 파라미터값 재사용 위함
			System.out.println(this.kakaoId);
			return false;
		}else {
			request.getSession().removeAttribute("joinForm");
			request.getSession().removeAttribute("joinValid");
			return true;
		}
	}

	public String getNickname() {
		return nickname;
	}
	
	public String getUserName() {
		return userName;
	}	
	
	public String getKakaoId() {
		return kakaoId;
	}	
	

}
