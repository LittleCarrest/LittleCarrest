package com.littleCarrest.seach.service;

import java.sql.Connection;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.common.exception.DataAccessException;
import com.littleCarrest.seach.model.dao.SearchDao;
import com.littleCarrest.seach.model.dto.CampingSearch;

public class SearchService {
	
	private SearchDao searchDao = new SearchDao();
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
