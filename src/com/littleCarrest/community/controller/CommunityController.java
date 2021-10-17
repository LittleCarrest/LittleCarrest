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
import com.littleCarrest.member.model.dto.Member;


/**
 * Servlet implementation class CommunityController
 */
@WebServlet("/community/*")
public class CommunityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CommunityService communityService = new CommunityService();
       
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

	private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member) request.getSession().getAttribute("authentication");

		FileUtil util = new FileUtil();
		MultiPartParams multiPartParams = util.fileUpload(request);
		System.out.println("multiPartParams : " + multiPartParams);
		String content = multiPartParams.getParameter("content");
		String category = multiPartParams.getParameter("category");
		
		List<FileDTO> fileDTOs = multiPartParams.getFilesInfo();
		

		System.out.println(category);
		System.out.println(content);
		System.out.println("file" + fileDTOs);
		
		Community community = new Community();
		//community.setNickname(member.getNickname());
		community.setContent(content);
		//community.setPicture(fileDTO);
		
		if(category.equals("g")) {
			communityService.insertBoardCamper(community);
			response.sendRedirect("/community/camper");
		}else {
			communityService.insertBoardGuide(community);
			response.sendRedirect("/community/guide");
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
		//List<String> campers = communityService.selectCamperTag(member.getUserId());
		List<Member> campers = communityService.selectBestCamper();
		System.out.println(campers);
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
