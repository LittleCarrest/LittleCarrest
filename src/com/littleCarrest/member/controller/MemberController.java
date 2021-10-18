package com.littleCarrest.member.controller;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.littleCarrest.member.model.dto.Member;
import com.littleCarrest.member.model.service.MemberService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberService();
       
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");

		//localhost:7070/member/login-form
		//array -> [member, login-form]
		switch (uriArr[uriArr.length-1]) {
		case "login-page":
			  loginPage(request,response);
			break;
		case "login":
			  login(request,response);
			break;
		case "logout":
			  logout(request,response);
			break;
		case "join-page":
			  joinPage(request,response);
			break;
		case "join":
			  join(request,response);
			break;
		case "kakao-login":
			  kakaoLogin(request,response);
			break;
		case "kakao-join":
			  kakaoJoin(request,response);
			break;
		case "kakao-join-page":
			  kakaoJoinPage(request,response);
			break;			
		case "join-impl":
			  joinImpl(request,response);
			break;
		case "id-check":
			 checkId(request,response);
			break;
		case "nick-check":
			 nickCheck(request,response);
			break;
		case "search-id":
			searchId(request,response);
			break;
		case "match-id":
			matchId(request,response);
			break;			
		case "search-password":
			searchPassword(request,response);
			break;

		default: /*throw new PageNotFoundException();*/
			break;
		}

	}
	private void nickCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
		Member member = memberService.selectMemberByNick(nickname);
		
		if(member == null) {
			response.getWriter().print("available");
		}else {
			response.getWriter().print("disable");
		}	
		
	}

	private void searchPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi world");
	}

	private void matchId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	private void searchId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	private void checkId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		Member member = memberService.selectMemberById(userId);
		
		if(member == null) {
			response.getWriter().print("available");
		}else {
			response.getWriter().print("disable");
		}
	}

	private void joinImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		memberService.insertMember((Member)session.getAttribute("persistUser"));
		
		//같은 persisUser값이 두 번 DB에 입력되지 않도록 사용자 정보와 인증을 만료시킴
		session.removeAttribute("persistUser");
		session.removeAttribute("persist-token");
		response.sendRedirect("/member/login-page");
		
	}

	private void kakaoJoinPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setAttribute("kakaoId", request.getParameter("userId"));
	     request.getRequestDispatcher("/member/kakao-join").forward(request, response);
	}

	private void kakaoJoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String userId = request.getParameter("kakaoId");
	      
	      String nickname = request.getParameter("nickname");
	      String year = request.getParameter("birth");
	      String month = request.getParameter("month");
	      String day = request.getParameter("day");
	      String info = request.getParameter("information");
	      
	      Member kakaomember = new Member();
	      kakaomember.setUserId(userId);
	      kakaomember.setNickname(nickname);
	      kakaomember.setInfo(info);
	      
	      memberService.insertkakaoMember(kakaomember);   

	      request.getRequestDispatcher("/index").forward(request, response);      
		
	}

	private void kakaoLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String userId = request.getParameter("userId");
         
	      //존재하면 로그인 성공
	      Member member = memberService.selectMemberById(userId);
	      if(member == null || member.getUserId().equals("")) {
	         //멤버테이블에서 아이디를 조회해서 존재하지 않으면 계속 진행
	         request.setAttribute("kakaoId", userId);
	         response.getWriter().print("kakaoJoin");
	         return;
	      }
	      
	      request.getSession().setAttribute("authentication", member);
	      response.getWriter().print("kakaoLogin");
	}

	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String name = request.getParameter("userName");
		
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword(password);
		member.setNickname(nickname);
		member.setEmail(email);
		member.setUserName(name);
		
		String persistToken = UUID.randomUUID().toString();
		request.getSession().setAttribute("persistUser", member);
		request.getSession().setAttribute("persist-token", persistToken);
		
		memberService.authenticateEmail(member,persistToken);
		
		request.setAttribute("msg", "회원가입을 위한 이메일이 발송되었습니다.");
		request.setAttribute("url", "/member/login-page");
		request.getRequestDispatcher("/common/result").forward(request, response);
		
	}

	private void joinPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/join-page").forward(request, response);
		
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("authentication");
		response.sendRedirect("/");
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		Member member = memberService.memberAuthenticate(userId,password);
		
		if(member == null) {
			response.sendRedirect("/member/login-page?err=1");
			return;
		}
		
		request.getSession().setAttribute("authentication", member);
		response.sendRedirect("/index");
		
	}

	private void loginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/login-page").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
