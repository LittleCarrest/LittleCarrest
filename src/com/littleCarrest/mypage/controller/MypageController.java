package com.littleCarrest.mypage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.littleCarrest.common.file.FileDTO;
import com.littleCarrest.common.file.FileUtil;
import com.littleCarrest.member.model.dto.Follower;
import com.littleCarrest.member.model.dto.Member;
import com.littleCarrest.member.model.service.MemberService;
import com.littleCarrest.mypage.model.service.MypageService;


/**
 * Servlet implementation class MypageController
 */
@WebServlet("/mypage/*")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberService memberService = new MemberService();
	MypageService mypageService = new MypageService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");

		switch (uriArr[uriArr.length-1]) {
		case "home":
			  home(request,response);
			break;
		case "edit-profile":
			  editProfile(request,response);
			break;
		case "edit":
			  edit(request,response);
			break;
		case "upload-profile":
			  uploadProfile(request,response);
			break;
		case "chk-nickname":
			  chkNickname(request,response);
			break;
		default: /*throw new PageNotFoundException();*/
			break;
		}
	
	
	}
	//프로필 이미지 등록
	private void uploadProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUtil util = new FileUtil();
		Map<String,FileDTO> param = util.profileUpload(request);
		
		System.out.println("param : " + param);
		
		Member member = (Member) request.getSession().getAttribute("authentication");
		String userId = member.getUserId();	
				
		FileDTO fileDTO = param.get("com.littleCarrest.files");
		
		if(memberService.selectProfile(userId).getRenameFileName() == null) {
			int res = memberService.insertProfile(userId, fileDTO);
			
			if(res == 0) {
				request.setAttribute("msg", "프로필 등록에 실패하였습니다.");
				request.setAttribute("url", "/mypage/edit-profile");
			}
		
		}else {
			int updateProfile = memberService.updateProfile(userId, fileDTO);
			
			if(updateProfile == 0) {
				request.setAttribute("msg", "프로필 등록에 실패하였습니다.");
				request.setAttribute("url", "/mypage/edit-profile");
			}

		}

		member = memberService.selectMemberById(userId);
		request.getSession().setAttribute("authentication", member);	//세션에 멤버객체 재등록(프로필 포함)
		
		request.setAttribute("msg", "프로필 등록에 성공하였습니다.");
		request.setAttribute("url", "/mypage/home");
		
		request.getRequestDispatcher("/common/result").forward(request, response);
		
	}

	private void chkNickname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
		Member member = memberService.selectMemberByNickname(nickname);
		if(member == null) {
			response.getWriter().print("available");	//js에게 전달
		}else {
			response.getWriter().print("disable");
		}
	}
	//회원정보수정(아이디, 패스워드, 닉네임, 자기소개)
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member member = (Member) request.getSession().getAttribute("authentication");
		String userId = member.getUserId();
		String password = (String) request.getAttribute("password");
		
		member.setUserId(userId);
		member.setNickname(request.getParameter("nickname"));
		member.setInfo(request.getParameter("info"));
		member.setPassword(password);
		
		int res = mypageService.updateMember(member);
		
		if(res > 0) {
			request.setAttribute("msg", "회원정보 수정을 완료하였습니다.");
			request.setAttribute("url", "/mypage/edit-profile");
		}else {
			request.setAttribute("msg", "회원정보 수정에 실패하였습니다.");
			request.setAttribute("back", "1");
		}
		request.getRequestDispatcher("/common/result").forward(request, response);
		
	}

	private void editProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member) request.getSession().getAttribute("authentication");
		request.getSession().setAttribute("authentication", member);

		request.getRequestDispatcher("/member/mypage/edit-profile").forward(request, response);
		
	}

	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member) request.getSession().getAttribute("authentication"); 
		Map<String,Object> follow = mypageService.selectFollower(member.getUserIdx());
		
		
		request.setAttribute("follower", follow.get("follower"));
		request.setAttribute("following", follow.get("following"));
		request.getRequestDispatcher("/member/mypage/mypage").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
