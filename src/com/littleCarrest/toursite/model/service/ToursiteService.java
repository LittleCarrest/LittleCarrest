package com.littleCarrest.toursite.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.toursite.model.dao.ToursiteDao;
import com.littleCarrest.toursite.model.dto.Toursite;
import com.littleCarrest.toursite.model.dto.ToursiteSub;

public class ToursiteService {
	private ToursiteDao toursiteDao = new ToursiteDao();
	private ToursiteDao toursiteDaoSub = new ToursiteDao();
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
	   
	   public void insertToursiteSub(ToursiteSub tour) {
		      Connection conn = template.getConnection();
		      
		      try {
		    	 toursiteDaoSub.insertToursiteSub(tour, conn);
		    	 template.commit(conn);
		      } catch (Exception e) {
		         template.rollback(conn);
		      }finally {
		         template.close(conn);
		      }
		   }

	   
		public List<String> selectContentId() {

			List<String> contentIdList = new ArrayList<String>();
			Connection conn = template.getConnection();
			
			try {
				contentIdList = toursiteDao.selectContentId(conn);
			} catch (Exception e) {
				template.rollback(conn);
			} finally {
				template.close(conn);
			}
			
			return contentIdList;
		}
}
