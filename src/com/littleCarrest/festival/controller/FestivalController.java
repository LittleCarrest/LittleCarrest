package com.littleCarrest.festival.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.littleCarrest.festival.model.dto.FestivalDto;
import com.littleCarrest.festival.model.service.FestivalService;

/**
 * Servlet implementation class TourController
 */
@WebServlet("/festival/*")
public class FestivalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	FestivalService festivalService = new FestivalService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FestivalController() {
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
		case "detail":	
			festivalDetail(request,response);
			break;
		case "spring":	
			spring(request,response);
			break;
		case "summer":	
			summer(request,response);
			break;

		default: /*throw new PageNotFoundException();*/
			break;
		}
	}

	private void summer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		List<FestivalDto> festivalOfSummers = new ArrayList<FestivalDto>();
		festivalOfSummers = festivalService.selectFestivalOfSummer();
		
		for (FestivalDto festivalDto : festivalOfSummers) {
			System.out.println(festivalDto.toString());
		}
		
		StringBuffer result = new StringBuffer();
		result.append("{\"spring\":");
		result.append("[");
		
		for(int i = 0; i < festivalOfSummers.size(); i++) {
			Gson gson = new Gson();
			String json = gson.toJson(festivalOfSummers.get(i));
			if(i < festivalOfSummers.size()-1) {
				result.append(json+",");
			} else {
				result.append(json);
			}
		}
		result.append("]}");
		
		response.getWriter().write(result.toString());
		
	}

	private void spring(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		List<FestivalDto> festivalOfSprings = new ArrayList<FestivalDto>();
		festivalOfSprings = festivalService.selectFestivalOfSpring();
		
		for (FestivalDto festivalDto : festivalOfSprings) {
			System.out.println(festivalDto.toString());
		}
		
		StringBuffer result = new StringBuffer();
		result.append("{\"spring\":");
		result.append("[");
		
		System.out.println(festivalOfSprings.size());
		
		for(int i = 0; i < festivalOfSprings.size(); i++) {
			Gson gson = new Gson();
			String json = gson.toJson(festivalOfSprings.get(i));
			if(i < festivalOfSprings.size()-1) {
				result.append(json+",");
			} else {
				result.append(json);
			}
		}
		result.append("]}");
		
		response.getWriter().write(result.toString());
		
	}

	private void festivalDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/sub02/tour-festival-detail").forward(request, response);
		
	}

	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FestivalDto festivalOfMonth = new FestivalDto();
		
		List<FestivalDto> festivalOfMonths = new ArrayList<FestivalDto>();
		festivalOfMonths = festivalService.selectFestivalOfMonths();
		
		request.setAttribute("festivalOfMonths", festivalOfMonths);
		request.getRequestDispatcher("/sub02/tour-festival").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
