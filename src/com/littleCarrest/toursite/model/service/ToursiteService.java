package com.littleCarrest.toursite.model.service;

import java.sql.Connection;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.toursite.model.dao.ToursiteDao;
import com.littleCarrest.toursite.model.dto.Toursite;

public class ToursiteService {
	private ToursiteDao toursiteDao = new ToursiteDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();

	   public void insertToursite(Toursite tour) {
		      Connection conn = template.getConnection();
		      
		      try {
		    	  toursiteDao.insertToursite(tour, conn);
		    	 template.commit(conn);
		      } catch (Exception e) {
		         template.rollback(conn);
		      }finally {
		         template.close(conn);
		      }
		   }
}
