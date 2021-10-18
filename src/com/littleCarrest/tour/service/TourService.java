package com.littleCarrest.tour.service;

import java.sql.Connection;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.tour.model.dao.TourDao;
import com.littleCarrest.tour.model.dto.TourDto;

public class TourService {
	
	private TourDao tourDao = new TourDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();

	   public void insertTour(TourDto tour) {
		      Connection conn = template.getConnection();
		      
		      try {
		    	  tourDao.insertTour(tour, conn);
		    	  template.commit(conn);
		      } catch (Exception e) {
		         template.rollback(conn);
		      }finally {
		         template.close(conn);
		      }
		   }
}
