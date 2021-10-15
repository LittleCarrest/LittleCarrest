package com.littleCarrest.member.model.service;

import java.sql.Connection;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.member.model.dao.MemberDao;
import com.littleCarrest.member.model.dto.Member;

public class MemberService {

	private MemberDao memberDao = new MemberDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public Member selectMemberById(String userId) {
		Connection conn = template.getConnection();
		Member member = null;
		
		try {
			/* member = memberDao.selectMemberById(userId, conn); */
		} finally {
			template.close(conn);
		}
		return member;
	}

	public Member selectMemberByNickname(String nickname) {
		Connection conn = template.getConnection();
		Member member = null;
		try {
			/* member = memberDao.selectByNickname(nickname, conn); */
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

}
