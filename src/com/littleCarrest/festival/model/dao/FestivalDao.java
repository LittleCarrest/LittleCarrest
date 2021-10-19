package com.littleCarrest.festival.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.common.exception.DataAccessException;
import com.littleCarrest.festival.model.dto.FestivalDto;

public class FestivalDao {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public void insertFestival(FestivalDto tour, Connection conn) {
		
		PreparedStatement pstm = null;
	
		String query = "insert into festival(festival_idx, name, startdate, enddate, tel, mapx, mapy, image, address)"
				
					 + " values(sc_cc_idx.nextval,?,?,?,?,?,?,?,?) ";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, tour.getName());
			pstm.setString(2, tour.getStartDate());
			pstm.setString(3, tour.getEndDate());
			pstm.setString(4, tour.getTel());
			pstm.setString(5, tour.getMapx());
			pstm.setString(6, tour.getMapy());
			pstm.setString(7, tour.getImage());
			pstm.setString(8, tour.getAddress());
			pstm.executeQuery();
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
	}

	
	
	
	
	
}
