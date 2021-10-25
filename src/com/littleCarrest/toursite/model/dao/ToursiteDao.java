package com.littleCarrest.toursite.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	//관광지 테이블에서 존재하는 모든 열의 CONTEN_ID를 조회
	public List<String> selectContentId(Connection conn) {
		
			List<String> contentIdList = new ArrayList<>();
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			String query = "select content_id from toursite";
							
			try {
				pstm = conn.prepareStatement(query);
				rset = pstm.executeQuery();
				
				while(rset.next()) {
					String contentId = rset.toString();
					contentIdList.add(contentId);
				}
			} catch (SQLException e) {
				throw new DataAccessException(e);
			} finally {
				template.close(rset, pstm);
			}
			
			return contentIdList;
			
	}

	
	
}
