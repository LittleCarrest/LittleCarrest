package com.littleCarrest.festival.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

	public List<FestivalDto> selectFestivalOfMonths(Connection conn) {
		
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formatedNow = now.format(formatter);
		
		List<FestivalDto> festivalOfMonths = new ArrayList<FestivalDto>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String sql = "select * from festival where startdate > ?";
				
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,formatedNow);
			rset = pstm.executeQuery();
	
			while(rset.next()) {
				
				FestivalDto festival = new FestivalDto();
				festival.setName(rset.getString("name"));
				festival.setStartDate(rset.getString("startdate"));
				festival.setEndDate(rset.getString("enddate"));
				festival.setTel(rset.getString("tel"));
				festival.setMapx(rset.getString("mapx"));
				festival.setMapy(rset.getString("mapy"));
				festival.setImage(rset.getString("image"));
				festival.setAddress(rset.getString("address"));
				
				festivalOfMonths.add(festival);
				
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset, pstm);
		}
		
		return festivalOfMonths;
		
	}

	public List<FestivalDto> selectFestivalOfSpring(Connection conn) {
		
		List<FestivalDto> festivalOfSpring = new ArrayList<FestivalDto>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String sql = "select * from(select * from festival where startdate > 20210301 and enddate < 20210630 order by dbms_random.value)where rownum <= 4";
				
		try {
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
	
			while(rset.next()) {
				
				FestivalDto festival = new FestivalDto();
				festival.setName(rset.getString("name"));
				festival.setStartDate(rset.getString("startdate"));
				festival.setEndDate(rset.getString("enddate"));
				festival.setTel(rset.getString("tel"));
				festival.setMapx(rset.getString("mapx"));
				festival.setMapy(rset.getString("mapy"));
				festival.setImage(rset.getString("image"));
				festival.setAddress(rset.getString("address"));
				
				festivalOfSpring.add(festival);
				
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset, pstm);
		}
		
		return festivalOfSpring;
	}

	public List<FestivalDto> selectFestivalOfSummer(Connection conn) {
		
		List<FestivalDto> festivalOfSummer = new ArrayList<FestivalDto>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String sql = "select * from(select * from festival where startdate > 20210701 and enddate < 20210930 order by dbms_random.value)where rownum <= 4";
				
		try {
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
	
			while(rset.next()) {
				
				FestivalDto festival = new FestivalDto();
				festival.setName(rset.getString("name"));
				festival.setStartDate(rset.getString("startdate"));
				festival.setEndDate(rset.getString("enddate"));
				festival.setTel(rset.getString("tel"));
				festival.setMapx(rset.getString("mapx"));
				festival.setMapy(rset.getString("mapy"));
				festival.setImage(rset.getString("image"));
				festival.setAddress(rset.getString("address"));
				
				festivalOfSummer.add(festival);
				
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset, pstm);
		}
		
		return festivalOfSummer;
		
	}
	
}
