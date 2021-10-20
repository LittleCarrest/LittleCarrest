package com.littleCarrest.toursite.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.common.exception.DataAccessException;
import com.littleCarrest.toursite.model.dto.Toursite;

public class ToursiteDao {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public void insertToursite(Toursite tour, Connection conn) {
		
		PreparedStatement pstm = null;
	
		String query = "insert into toursite(toursite_idx, addr, addr_spe, name, tel, image, mapx, mapy, booktour, typeid)"
				
					 + " values(sc_cc_idx.nextval,?,?,?,?,?,?,?,?,?) ";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, tour.getAddr());
			pstm.setString(2, tour.getAddrSpe());
			pstm.setString(3, tour.getName());
			pstm.setString(4, tour.getTel());
			pstm.setString(5, tour.getImage());
			pstm.setString(6, tour.getMapx());
			pstm.setString(7, tour.getMapy());
			pstm.setString(8, tour.getBooktour());
			pstm.setString(9, tour.getTypeid());
			pstm.executeQuery();
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
}
}
