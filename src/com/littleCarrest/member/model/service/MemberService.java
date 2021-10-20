package com.littleCarrest.member.model.service;

import java.sql.Connection;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.common.file.FileDTO;
import com.littleCarrest.common.http.HttpConnector;
import com.littleCarrest.common.http.RequestParams;
import com.littleCarrest.common.mail.MailSender;
import com.littleCarrest.member.model.dao.MemberDao;
import com.littleCarrest.member.model.dto.Member;

public class MemberService {

	private MemberDao memberDao = new MemberDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public Member selectMemberById(String userId) {
		Connection conn = template.getConnection();
		Member member = null;
		
		try {
			member = memberDao.selectMemberById(userId, conn);
		} finally {
			template.close(conn);
		}
		return member;
	}
	
	public Member selectMemberByNickname(String nickname) {
		Connection conn = template.getConnection();
		Member member = null;
		try {
			member = memberDao.selectByNickname(nickname, conn);
		} finally {
			template.close(conn);	
		}
		return member;	
	}

	public Member memberAuthenticate(String userId, String password) {
		Connection conn = template.getConnection();
		Member member = null;
		
		try {
			member = memberDao.memberAuthenticate(userId, password, conn);		
		}finally {
			template.close(conn);
		}
		
		return member;
	}

	public void authenticateEmail(Member member, String persistToken) {
		HttpConnector conn = new HttpConnector();
		
		String queryString = conn.urlEncodedForm( RequestParams.builder()
				.param("mail-template", "join-auth-email")
				.param("persistToken", persistToken)
				.param("userId", member.getUserId())
				.build()); 

		String mailTemplate = conn.get("http://localhost:7070/mail?"+queryString);
		MailSender sender = new MailSender();
		sender.sendEmail(member.getEmail(), "환영합니다. " + member.getUserId() + "님", mailTemplate);
	}

	public int insertMember(Member member) {
		
		Connection conn = template.getConnection();
		int res = 0;
		
		try {
			//회원가입처리
			res = memberDao.insertMember(member, conn);
			//방금 가입한 회원의 아이디로 정보를 다시 조회			
			Member m = memberDao.selectMemberById(member.getUserId(), conn);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		}finally {
			template.close(conn);
		}
		
		return res;
		
	}
	public FileDTO selectProfile(String userId) {
		Connection conn = template.getConnection();
		FileDTO profile = new FileDTO();
		
		try {
			profile = memberDao.selectProfile(userId, conn);
		}finally {
			template.close(conn);	
		}
		return profile;
	}

	public int insertProfile(String userId, FileDTO fileDTO) {
		Connection conn = template.getConnection();
		int res = 0;
		
		try {
			memberDao.insertProfile(userId, fileDTO, conn);
			res = memberDao.updateMemberProfile(userId, fileDTO, conn);
			
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
		}finally {
			template.close(conn);
		}	
		return res;
	}

	public int updateProfile(String userId, FileDTO fileDTO) {
		Connection conn = template.getConnection();
		int res = 0;
		
		try {
			res = memberDao.updateProfile(userId,fileDTO, conn);	//file_info테이블에 프로필 업데이트 
			memberDao.updateMemberProfile(userId,fileDTO, conn);	

			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
		}finally {
			template.close(conn);
		}
		return res;
	}

	public Member selectMemberByNick(String nickname) {
		Connection conn = template.getConnection();
		Member member = null;
		
		try {
			member = memberDao.selectMemberByNick(nickname, conn);
		} finally {
			template.close(conn);
		}
		
		return member;
	}

	public int insertkakaoMember(Member kakaomember) {
		
		Connection conn = template.getConnection();
		int res = 0;
		
		try {
			//회원가입처리
			res = memberDao.kakaoinsert(kakaomember, conn);
			//방금 가입한 회원의 아이디로 정보를 다시 조회			
			Member m = memberDao.selectMemberById(kakaomember.getUserId(), conn);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		}finally {
			template.close(conn);
		}
		
		return res;
		
	}

	public Member searchById(String userName, String email) {
		Connection conn = template.getConnection();
		Member member = null;
		
		try {
			member = memberDao.searchById(userName,email,conn);
		} finally {
			template.close(conn);
		}

		return member;
	}
}
