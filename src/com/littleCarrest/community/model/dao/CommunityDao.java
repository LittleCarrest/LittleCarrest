package com.littleCarrest.community.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.common.exception.DataAccessException;
import com.littleCarrest.member.model.dao.MemberDao;
import com.littleCarrest.member.model.dto.Member;

public class CommunityDao {
	
	JDBCTemplate template = JDBCTemplate.getInstance();

	public List<String> selectCamperTag(String userId, Connection conn) {
		List<String> camperList = new ArrayList<String>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String nickname = null;
		int num = 0;
		int userCnt = 0;

		String sql = "select nickname from member where rownum = ? and user_id != ?";
		
		try {
			userCnt = selectUserCnt(conn);
			
			for (int i = 0; i < 11; i++) {
				num = (int)(Math.random() * userCnt + 1);
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, num);
				pstm.setString(2, userId);
				rset = pstm.executeQuery();

				nickname = rset.getString("nickname");
				camperList.add(nickname);
				System.out.println(nickname);
			}	
			
			System.out.println(camperList);
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset,pstm);
		}
		return camperList;
	}
	
	public int selectUserCnt(Connection conn){
		PreparedStatement pstm = null;
		ResultSet rset = null;
		int userCnt = 0;
		
		String sql = "select count(*) from member where is_leave = 0";
		
		try {
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			if (rset.next()) {
				userCnt = rset.getInt("count(*)");
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset,pstm);
		}
		return userCnt;
	}

	public List<Member> selectBestCamper(Connection conn) {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		List<Member> camperList = new ArrayList<Member>();
		MemberDao memberDao = new MemberDao();
		
		String sql = "SELECT * FROM MEMBER " + 
				"LEFT JOIN (SELECT COUNT(*) AS FOLLOWER_CNT,USER_IDX FROM FOLLOWER  GROUP BY USER_IDX) USING(USER_IDX) " + 
				"WHERE IS_LEAVE = 0 AND ROWNUM < 11 AND FOLLOWER_CNT IS NOT NULL " + 
				"ORDER BY FOLLOWER_CNT DESC";
		try {
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Member camper = new Member();
				//camper = memberDao
				
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset,pstm);
		}
		return camperList;
	}

}
