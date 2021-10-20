package com.littleCarrest.camping.model.service;


import java.sql.Connection;

import com.littleCarrest.camping.model.dao.CampingDao;
import com.littleCarrest.camping.model.dto.CampingSearch;
import com.littleCarrest.common.db.JDBCTemplate;

public class CampingService {
	
	private CampingDao searchDao = new CampingDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();

	   public void insertCamping(CampingSearch camping) {
		      Connection conn = template.getConnection();
		      
		      try {
		    	  searchDao.insertCamping(camping, conn);
		    	  template.commit(conn);
		      } catch (Exception e) {
		         template.rollback(conn);
		      }finally {
		         template.close(conn);
		      }
		   }
}
