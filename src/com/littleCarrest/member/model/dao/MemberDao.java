package com.littleCarrest.member.model.dao;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.common.exception.DataAccessException;
import com.littleCarrest.common.file.FileDTO;
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
				
			String[] fieldArr = {"user_idx","user_id","user_name","password","email","nickname","reg_date"
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
	
	//유진 10/15
	public Member selectMemberById(String userId, Connection conn) {
		Member member = null;			
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String query = "select * from member where user_Id = ?";
		
		try {			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				member = convertRowToMember(rset);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}

		return member;
	}

	//유진 10/15
	public Member selectByNickname(String nickname, Connection conn) {
		Member member = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String sql = "select * from member where nickname = ?";

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nickname);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				member = convertRowToMember(rset);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset, pstm);
		}
		
		return member;
	}
	//유진 10/15
	public int updateMember(Member member, Connection conn) {
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "update member set nickname = ? "
				+ ", password = ? "
				+ ", info = ? "
				+ "where user_id = ?";
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, member.getNickname());
			pstm.setString(2, member.getPassword());
			pstm.setString(3, member.getInfo());
			pstm.setString(4, member.getUserId());	
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		
		return res;
		
	}
	
	public int updateSocailMember(Member member, Connection conn) {
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "update member set nickname = ? "
				+ ", info = ? "
				+ "where user_id = ?";
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, member.getNickname());
			pstm.setString(3, member.getInfo());
			pstm.setString(4, member.getUserId());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		
		return res;
		
	}
	
	public Member convertRowToMember(ResultSet rset) throws SQLException {
		
		Member member = new Member();
		member.setUserIdx(rset.getString("user_idx")); 
		member.setUserId(rset.getString("user_id")); 
		member.setUserName(rset.getString("user_name")); 
		member.setPassword(rset.getString("password"));
		member.setEmail(rset.getString("email"));
		member.setNickname(rset.getString("nickname"));
		member.setRegDate(rset.getDate("reg_date"));
		member.setInfo(rset.getString("info"));
		member.setProfile(rset.getString("profile"));
		member.setSocialLogin(rset.getString("social_login"));
		
		return member;
		
	}
	
	public Member convertRowToMember(ResultSet rset, String[] fieldArr) throws SQLException {
		Member member = new Member();
		
		for (int i = 0; i < fieldArr.length; i++) {
			String field = fieldArr[i].toLowerCase();
			switch (field) {
			
			case "user_idx":member.setUserIdx(rset.getString("user_idx")); break;
			case "user_id":member.setUserId(rset.getString("user_id")); break;
			case "user_name":member.setUserName(rset.getString("user_name")); break;
			case "password":member.setPassword(rset.getString("password"));break;
			case "email":member.setEmail(rset.getString("email")); break;
			case "nickname":member.setNickname(rset.getString("nickname")); break;
			case "reg_date":member.setRegDate(rset.getDate("reg_date"));break;
			case "info":member.setInfo(rset.getString("info"));break;
			case "profile":member.setProfile(rset.getString("profile"));break;
			case "social_login":member.setSocialLogin(rset.getString("social_login"));break;
			
			}
		}
		
		return member;
	}
	
	public Map<String,Object> convertRowToMap(ResultSet rset, String[] fieldArr) throws SQLException {
		
		Map<String,Object> res = new HashMap<String, Object>();
		
		for (int i = 0; i < fieldArr.length; i++) {
			String field = fieldArr[i].toLowerCase();
			res.put(field, rset.getObject(field));
		}
		
		return res;
	}

	public int insertMember(Member member, Connection conn) {
		int res = 0;		
		PreparedStatement pstm = null;
		
		String query = "insert into member(user_idx,user_name,user_id,password,email,nickname)"
					 + " values(sc_mem_idx.nextval,?,?,?,?,?) ";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, member.getUserName());
			pstm.setString(2, member.getUserId());
			pstm.setString(3, member.getPassword());
			pstm.setString(4, member.getEmail());
			pstm.setString(5, member.getNickname());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		
		return res;
	}

	public void insertProfile(String userId, FileDTO fileDTO, Connection conn) {
		PreparedStatement pstm = null;
		
		String sql = "insert into file_info "
				+ "(fl_idx,type_idx,origin_file_name,rename_file_name,save_path) "
				+ "values(sc_fl_idx.nextval,?,?,?,?)";

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userId);
			pstm.setString(2, fileDTO.getOriginFileName());
			pstm.setString(3, fileDTO.getRenameFileName());
			pstm.setString(4, fileDTO.getSavePath());
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		
	}
	

	public FileDTO selectProfile(String userId, Connection conn) {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		FileDTO profile = new FileDTO();
		
		String sql = "select rownum,type_idx, origin_file_name, rename_file_name, save_path "
				+ "from (select type_idx, origin_file_name, rename_file_name, save_path "
				+ "from file_info where type_idx = ? "
				+ "order by reg_date desc) where rownum = 1";

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				profile.setTypeIdx(rset.getString("type_idx"));
				profile.setOriginFileName(rset.getString("origin_file_name"));
				profile.setRenameFileName(rset.getString("rename_file_name"));
				profile.setSavePath(rset.getString("save_path"));
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset, pstm);
		}
		
		return profile;
	}

	public int updateProfile(String userId, FileDTO fileDTO, Connection conn) {
		int res = 0;
		PreparedStatement pstm = null;
		
		String sql = "update file_info set origin_file_name = ? "
				+ ", rename_file_name = ?"
				+ ", save_path = ? "
				+ ", reg_date = sysdate "
				+ "where type_idx = ?";
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, fileDTO.getOriginFileName());
			pstm.setString(2, fileDTO.getRenameFileName());
			pstm.setString(3, fileDTO.getSavePath());
			pstm.setString(4, userId);
			res = pstm.executeUpdate();
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}

		
		return res;
	}
	

	public int updateMemberProfile(String userId, FileDTO fileDTO, Connection conn) {
		int res = 0;
		PreparedStatement pstm = null;
		
		String sql = "update member set profile = ? where user_id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, fileDTO.getSavePath() + fileDTO.getRenameFileName());
			pstm.setString(2, userId);
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		
		return res;
		
	}

	public Member selectMemberByNick(String nickname, Connection conn) {
		Member member = null;			
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String query = "select * from member where NICKNAME = ?";
		
		try {			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, nickname);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				member = convertRowToMember(rset);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return member;
	}

	public int kakaoinsert(Member kakaomember, Connection conn) {
		
		int res = 0;		
		PreparedStatement pstm = null;
		
		String query = "insert into social_member(user_idx,kakao_id)"
					 + " values(sc_mem_idx.currval,?) ";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, kakaomember.getUserId());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		
		return res;
		
	}

	public Member searchById(String userName, String email, Connection conn) {
		Member member = null;			
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String query = "select * from member where user_name = ? and email = ?";
		
		try {			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userName);
			pstm.setString(2, email);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				member = convertRowToMember(rset);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return member;
	}

	public String changePass(String userId, String email, Connection conn) {
		
		PreparedStatement pstm = null;
		String randompass = getRamdomPassword(10);
		String query = "update member set password = ? where user_id = ? and email = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, randompass);
			pstm.setString(2, userId);
			pstm.setString(3, email);
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		
		return randompass;
		
	}

	private String getRamdomPassword(int size) {
		
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'
				, 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x'
				, 'y', 'z', '!', '@', '#', '$', '%', '^', '&' }; 
		StringBuffer sb = new StringBuffer(); 
		SecureRandom sr = new SecureRandom(); 
		
		sr.setSeed(new Date().getTime()); 
		int idx = 0; int len = charSet.length; 
		for (int i=0; i<size; i++) 
		{ 
		idx = sr.nextInt(len);
		sb.append(charSet[idx]); 
		} 
		
		return sb.toString(); 
		
	}

	public Member searchByPass(String userId, String email, Connection conn) {
		
		Member member = null;			
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String query = "select * from member where user_id = ? and email = ?";
		
		try {			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			pstm.setString(2, email);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				member = convertRowToMember(rset);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return member;
		
	}








}
