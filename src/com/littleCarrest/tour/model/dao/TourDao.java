package com.littleCarrest.tour.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.common.exception.DataAccessException;
import com.littleCarrest.tour.model.dto.TourDto;

public class TourDao {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public void insertTour(TourDto tour, Connection conn) {
		PreparedStatement pstm = null;
	
		String query = "insert into camping(cp_idx, cp_name, line_intro, intro,status,addr,addr_spe,mapx,mapy,tel,homepage,location)"
				
					 + " values(sc_cc_idx.nextval,?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, tour.getCpName());
			pstm.setString(2, tour.getLineIntro());
			pstm.setString(3, tour.getIntro());
			pstm.setString(4, tour.getStatus());
			pstm.setString(5, tour.getAddr());
			pstm.setString(6, tour.getAddrSpe());
			pstm.setString(7, tour.getMapx());
			pstm.setString(8, tour.getMapy());
			pstm.setString(9, tour.getTel());
			pstm.setString(10, tour.getHomepage());
			pstm.setString(11, tour.getLocation());
			pstm.executeQuery();
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
	}
	
	
	
	
	
}
