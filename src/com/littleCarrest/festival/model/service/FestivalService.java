package com.littleCarrest.festival.model.service;

import java.sql.Connection;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.festival.model.dao.FestivalDao;
import com.littleCarrest.festival.model.dto.FestivalDto;

public class FestivalService {
	
	private FestivalDao festivalDao = new FestivalDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();

	   public void insertFestival(FestivalDto tour) {
		      Connection conn = template.getConnection();
		      
		      try {
		    	 festivalDao.insertFestival(tour, conn);
		    	 template.commit(conn);
		      } catch (Exception e) {
		         template.rollback(conn);
		      }finally {
		         template.close(conn);
		      }
		   }
}
