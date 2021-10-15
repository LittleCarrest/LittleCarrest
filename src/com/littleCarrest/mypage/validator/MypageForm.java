package com.littleCarrest.mypage.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.littleCarrest.member.model.dto.Member;
import com.littleCarrest.member.model.service.MemberService;


public class MypageForm {
	
	private String nickname;
	private String info;
	private String password;		
	private String confirmPw;	
	private HttpServletRequest request;
	private MemberService memberService = new MemberService();
	private Map<String,String> failedAttribute =  new HashMap<String,String>();

	public MypageForm(ServletRequest request) {
		this.request = (HttpServletRequest) request;
		this.nickname = request.getParameter("nickname");
		this.info = request.getParameter("info");
		this.password = request.getParameter("password");
		this.confirmPw = request.getParameter("chk-pw");
	}



	public boolean test() {
		boolean isFailed = false;
		
		Member member = (Member) request.getSession().getAttribute("authentication");
		String userId = member.getUserId();
		
		if(password.equals("") || !password.equals(memberService.selectMemberById(userId).getPassword())) {
			failedAttribute.put("password",password);
			isFailed = true;
		}
		
		//비밀번호가 영어, 숫자, 특수문자 조합의 8~15자의 문자열인지 확인
		if(!Pattern.matches("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Zㄱ-힣0-9]).{8,15}", password)) {
			failedAttribute.put("newPw",password);
			isFailed = true;
		}
		
		//새 비밀번호와 일치하는지 확인
		if(!confirmPw.equals(password)) {
			failedAttribute.put("confirmPw",confirmPw);
			isFailed = true;
		}
		
		//null이면 기존 닉네임 값 대입
		if(nickname.equals("") || nickname == null) {
			nickname = member.getNickname();
		}
		
		//기존 세션객체 닉네임과 동일하지 않으면서 다른 유저닉네임과 중복된다면 fail
		if(!nickname.equals(member.getNickname()) && memberService.selectMemberByNickname(nickname) != null) {
			failedAttribute.put("nickname",nickname);
			isFailed = true;
		}

		if(isFailed) {
			request.getSession().setAttribute("editValid", failedAttribute);	
			request.getSession().setAttribute("editForm", this);	
			return false;
		}else {
			request.getSession().removeAttribute("editForm");
			request.getSession().removeAttribute("editValid");
			return true;
		}
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getConfirmPw() {
		return confirmPw;
	}



	public void setConfirmPw(String confirmPw) {
		this.confirmPw = confirmPw;
	}

	

}
