package com.littleCarrest.festival.controller;

import java.io.IOException;
import java.util.ArrayList;
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

		default: /*throw new PageNotFoundException();*/
			break;
		}
	}

	private void spring(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FestivalDto> festivalOfSprings = new ArrayList<FestivalDto>();
		festivalOfSprings = festivalService.selectFestivalOfSpring();
		
		for (FestivalDto festivalDto : festivalOfSprings) {
			System.out.println(festivalDto.toString());
		}
		
		for (FestivalDto festivalDto : festivalOfSprings) {
			Gson gson = new Gson();
			String Json = gson.toJson(festivalDto);
			response.getWriter();
		}
		
		
		
	}

	private void festivalDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/sub02/tour-festival-detail").forward(request, response);
		
	}

	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FestivalDto festivalOfMonth = new FestivalDto();
		FestivalDto festivalOfSeason = new FestivalDto();
		
		List<FestivalDto> festivalOfMonths = new ArrayList<FestivalDto>();
		
		List<FestivalDto> festivalOfSpring = new ArrayList<FestivalDto>();
		List<FestivalDto> festivalOfSummer = new ArrayList<FestivalDto>();
		List<FestivalDto> festivalOfFall = new ArrayList<FestivalDto>();
		List<FestivalDto> festivalOfWinter = new ArrayList<FestivalDto>();
		
		festivalOfMonths = festivalService.selectFestivalOfMonths();
		
		festivalOfSpring = festivalService.selectFestivalOfSeasons();
		festivalOfSummer = festivalService.selectFestivalOfSeasons();
		festivalOfFall = festivalService.selectFestivalOfSeasons();
		festivalOfWinter = festivalService.selectFestivalOfSeasons();
		
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
