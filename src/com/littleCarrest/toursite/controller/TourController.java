package com.littleCarrest.toursite.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.littleCarrest.toursite.model.service.ToursiteService;

/**
 * Servlet implementation class TourController
 */
@WebServlet("/toursite/*")
public class TourController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ToursiteService toursiteService = new ToursiteService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourController() {
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

		default: /*throw new PageNotFoundException();*/
			break;
		}
	}

	private void festivalDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/sub02/tour-festival-detail").forward(request, response);
		
	}


	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/sub02/tour-site").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
