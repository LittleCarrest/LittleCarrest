package com.littleCarrest.toursite.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.common.exception.DataAccessException;
import com.littleCarrest.toursite.model.dto.Toursite;
import com.littleCarrest.toursite.model.dto.ToursiteSub;

public class ToursiteDao {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public void insertToursite(Toursite tour, Connection conn) {
		
		PreparedStatement pstm = null;
	
		String query = "insert into toursite(content_id, addr, name, image, mapx, mapy)"
				
					 + " values(?,?,?,?,?,?) ";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, tour.getContentId());
			pstm.setString(2, tour.getAddr());
			pstm.setString(3, tour.getName());
			pstm.setString(4, tour.getImage());
			pstm.setString(5, tour.getMapx());
			pstm.setString(6, tour.getMapy());
			pstm.executeQuery();
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
}
	
public void insertToursiteSub(ToursiteSub tour, Connection conn) {
		
		PreparedStatement pstm = null;
	
		String query = "insert into toursite(content_id, overview)"
				
					 + " values(?,?) ";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, tour.getContentId());
			pstm.setString(2, tour.getOverview());
			pstm.executeQuery();
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
}

	
	
}
