package com.littleCarrest.seach.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.common.exception.DataAccessException;
import com.littleCarrest.seach.model.dto.CampingSearch;

public class SearchDao {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public void insertCamping(CampingSearch camping, Connection conn) {
		PreparedStatement pstm = null;
	
		String query = "insert into camping(cp_idx, cp_name, line_intro, intro,status,addr,addr_spe,mapx,mapy,tel,homepage,location)"
				
					 + " values(sc_cc_idx.nextval,?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, camping.getCpName());
			pstm.setString(2, camping.getLineIntro());
			pstm.setString(3, camping.getIntro());
			pstm.setString(4, camping.getStatus());
			pstm.setString(5, camping.getAddr());
			pstm.setString(6, camping.getAddrSpe());
			pstm.setString(7, camping.getMapx());
			pstm.setString(8, camping.getMapy());
			pstm.setString(9, camping.getTel());
			pstm.setString(10, camping.getHomepage());
			pstm.setString(11, camping.getLocation());
			pstm.executeQuery();
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
	}
	
	
	
	
	
}
