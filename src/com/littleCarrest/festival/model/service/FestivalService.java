package com.littleCarrest.festival.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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

	public List<FestivalDto> selectFestivalOfMonths() {
		List<FestivalDto> festivalOfMonths = new ArrayList<FestivalDto>();
		
		 Connection conn = template.getConnection();
	      
	      try {
	    	  festivalOfMonths = festivalDao.selectFestivalOfMonths(conn);
	    	 template.commit(conn);
	      } catch (Exception e) {
	         template.rollback(conn);
	      }finally {
	         template.close(conn);
	      }
		
		return festivalOfMonths;
	}

	public List<FestivalDto> selectFestivalOfSeasons() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<FestivalDto> selectFestivalOfSpring() {
		List<FestivalDto> festivalOfSpring = new ArrayList<FestivalDto>();
		
		 Connection conn = template.getConnection();
	      
	      try {
	    	  festivalOfSpring = festivalDao.selectFestivalOfSpring(conn);
	    	 template.commit(conn);
	      } catch (Exception e) {
	         template.rollback(conn);
	      }finally {
	         template.close(conn);
	      }
		
		return festivalOfSpring;
	}
}
