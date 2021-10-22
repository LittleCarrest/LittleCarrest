package com.littleCarrest.community.controller;

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
import com.littleCarrest.common.file.MultiPartParams;
import com.littleCarrest.community.model.dto.Community;
import com.littleCarrest.community.model.service.CommunityService;
import com.littleCarrest.member.model.dto.Follower;
import com.littleCarrest.member.model.dto.Member;
import com.littleCarrest.mypage.model.service.MypageService;


/**
 * Servlet implementation class CommunityController
 */
@WebServlet("/community/*")
public class CommunityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CommunityService communityService = new CommunityService();
	private MypageService mypageService = new MypageService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		
		switch (uriArr[uriArr.length-1]) {
		case "camper":	
			camper(request,response);
			break;
		case "user-page":	
			userPage(request,response);
			break;
		case "guide":	
			guide(request,response);
			break;
		case "board-form":	
			boardForm(request,response);
			break;
		case "upload":	
			upload(request,response);
			break;
		default: /*throw new PageNotFoundException();*/
			break;
		}
	}

	private void userPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userIdx = request.getParameter("user");
		Member member = communityService.selectMemberByIdx(userIdx);
		Map<String,Object> follow = mypageService.selectFollower(member.getUserIdx());
		
		request.setAttribute("user", member);
		request.setAttribute("follower", follow.get("follower"));
		request.setAttribute("following", follow.get("following"));
		
		request.getRequestDispatcher("/sub03/user-page").forward(request, response);
		
	}

	private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member) request.getSession().getAttribute("authentication");

		FileUtil util = new FileUtil();
		MultiPartParams multiPartParams = util.fileUpload(request);
		String content = multiPartParams.getParameter("content");
		String category = multiPartParams.getParameter("category");
		List<String> tags = multiPartParams.getParameterValues("tag");
//		System.out.println(tag);
//		for (String string : tag) {
//			System.out.println(string);
//		}
		
		List<FileDTO> fileDTOs = multiPartParams.getFilesInfo();
		
		Community community = new Community();
		community.setUserIdx(member.getUserIdx());
		community.setNickname(member.getNickname());
		community.setContent(content);
		community.setCategory(category);
		//System.out.println(community);
		
		if(category == null) {
			request.setAttribute("msg", "카테고리를 선택하세요");
			request.setAttribute("back", "1");
			request.getRequestDispatcher("common/result");
		}
		
		communityService.insertBoard(community, fileDTOs, tags);
		
		if(category.equals("g")) {
			response.sendRedirect("/community/guide");
		}else {
			response.sendRedirect("/community/camper");
		}
		
		
	}

	private void boardForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/sub03/board-form").forward(request, response);
		
	}

	private void guide(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/sub03/guide").forward(request, response);
		
	}

	private void camper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member =  (Member) request.getSession().getAttribute("authentication");
		List<Member> campers = communityService.selectBestCamper();
		request.setAttribute("campers", campers);
		request.getRequestDispatcher("/sub03/camper").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
