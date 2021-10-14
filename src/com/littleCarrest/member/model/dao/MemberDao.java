package com.littleCarrest.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.common.exception.DataAccessException;
import com.littleCarrest.member.model.dto.Member;

public class MemberDao {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public Member memberAuthenticate(String userId, String password, Connection conn) {
		Member member = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
			
		try {
			String query = "select * from member where user_id = ? and password = ? ";			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			pstm.setString(2, password);
			rset = pstm.executeQuery();
				
			String[] fieldArr = {"user_id","password","email","nickname","tel","address","reg_date"
								,"info","profile","social_login"};
			
			if(rset.next()) {
				member =  convertRowToMember(rset,fieldArr);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset,pstm);
		}
			
		  return member;
	}
	
	
	private Member convertRowToMember(ResultSet rset) throws SQLException {
		
		Member member = new Member();
		
		member.setUserId(rset.getString("user_id")); 
		member.setPassword(rset.getString("password"));
		member.setEmail(rset.getString("email"));
		member.setNickname(rset.getString("nickname"));
		member.setTel(rset.getString("tel"));
		member.setAddress(rset.getString("address"));
		member.setRegDate(rset.getDate("reg_date"));
		member.setInfo(rset.getString("info"));
		member.setProfile(rset.getString("profile"));
		member.setSocialLogin(rset.getString("social_login"));
		
		return member;
		
	}
	
	private Member convertRowToMember(ResultSet rset, String[] fieldArr) throws SQLException {
		Member member = new Member();
		
		for (int i = 0; i < fieldArr.length; i++) {
			String field = fieldArr[i].toLowerCase();
			switch (field) {
			
			case "user_id":member.setUserId(rset.getString("user_id")); break;
			case "password":member.setPassword(rset.getString("password"));break;
			case "email":member.setEmail(rset.getString("email")); break;
			case "nickname":member.setNickname(rset.getString("nickname")); break;
			case "tel":member.setTel(rset.getString("tel"));break;
			case "address":member.setAddress(rset.getString("address"));break;
			case "reg_date":member.setRegDate(rset.getDate("reg_date"));break;
			case "info":member.setInfo(rset.getString("info"));break;
			case "profile":member.setProfile(rset.getString("profile"));break;
			case "social_login":member.setSocialLogin(rset.getString("social_login"));break;
			
			}
		}
		
		return member;
	}
	
	private Map<String,Object> convertRowToMap(ResultSet rset, String[] fieldArr) throws SQLException {
		
		Map<String,Object> res = new HashMap<String, Object>();
		
		for (int i = 0; i < fieldArr.length; i++) {
			String field = fieldArr[i].toLowerCase();
			res.put(field, rset.getObject(field));
		}
		
		return res;
	}

}
