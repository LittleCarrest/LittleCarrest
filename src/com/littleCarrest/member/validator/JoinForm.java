package com.littleCarrest.member.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.littleCarrest.member.model.service.MemberService;


public class JoinForm {
	
	private String userId;
	private String userName;
	private String password;
	private String confirmPassword;
	private String email;
	private String nickname;
	private String info;
	private String birth;
	private HttpServletRequest request;	
	private MemberService memberService = new MemberService();
	private Map<String,String> failedAttrubute =  new HashMap<String,String>();
	
	public JoinForm(ServletRequest request) {
		this.request = (HttpServletRequest) request;
		this.userId = request.getParameter("userId");
		this.userName = request.getParameter("userName");
		this.password = request.getParameter("password");
		this.confirmPassword = request.getParameter("chkPwd");
		this.email = request.getParameter("email");
		this.nickname = request.getParameter("nickname");
		this.info = request.getParameter("information");
		this.birth = request.getParameter("birth");
	}
	
	public boolean test() {
		boolean isFailed = false;
		//사용자 아이디가 DB에 이미 존재하는 지 확인
		if(userId.equals("") || memberService.selectMemberById(userId) != null) {
			failedAttrubute.put("userId",userId);
			isFailed = true;
		}
		
		//비밀번호가 영어, 숫자, 특수문자 조합의 8~15자의 문자열인지 확인
		if(!Pattern.matches("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Zㄱ-힣0-9]).{8,15}", password)) {
			failedAttrubute.put("password",password); 
			isFailed = true;
		}
		
		if(!confirmPassword.equals(password) ) {
			failedAttrubute.put("confirmPassword",confirmPassword); 
			isFailed = true;
		}
		
		//닉네임 검증 : 사용자가 입력한 닉네임이 DB에 이미 존재하는지 확인 (위 아이디 검증과 유사)
		if(nickname.equals("") || memberService.selectMemberByNickname(nickname) != null) {
			failedAttrubute.put("nickname",nickname);
			isFailed = true;
		}
		
		//이메일 검증 : '@가 포함되어 있는지 + '.'(마침표)뒤에 세글자(com/net..)인지 확인
		
		//생년월일 검증
		
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
	


	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getNickname() {
		return nickname;
	}

	public String getInfo() {
		return info;
	}

	public String getBirth() {
		return birth;
	}

	public String getUserName() {
		return userName;
	}	
	
	

}
