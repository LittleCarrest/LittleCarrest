package com.littleCarrest.member.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.littleCarrest.member.model.service.MemberService;


public class KakaoJoinForm {
	
	private String nickname;
	private HttpServletRequest request;	
	private MemberService memberService = new MemberService();
	private Map<String,String> failedAttrubute =  new HashMap<String,String>();
	
	public KakaoJoinForm(ServletRequest request) {
		this.request = (HttpServletRequest) request;
		this.nickname = request.getParameter("nickname");
	}
	
	public boolean test() {
		boolean isFailed = false;
		
		//닉네임 검증 : 사용자가 입력한 닉네임이 DB에 이미 존재하는지 확인 (위 아이디 검증과 유사)
		if(nickname.equals("") || memberService.selectMemberByNickname(nickname) != null) {
			failedAttrubute.put("nickname",nickname);
			isFailed = true;
		}
		
		if(isFailed) {
			request.getSession().setAttribute("joinValid", failedAttrubute);	//joinFailed에 검증실패한 값 저장
			request.getSession().setAttribute("joinForm", this);	//사용자 입력 파라미터값 재사용 위함
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
	

}
