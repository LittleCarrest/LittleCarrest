package com.littleCarrest.mypage.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.member.model.dao.MemberDao;
import com.littleCarrest.member.model.dto.Follower;
import com.littleCarrest.member.model.dto.Following;
import com.littleCarrest.member.model.dto.Member;
import com.littleCarrest.mypage.model.dao.MypageDao;

public class MypageService {

	JDBCTemplate template = JDBCTemplate.getInstance();
	MypageDao mypageDao = new MypageDao();
	MemberDao memberDao = new MemberDao();
	
	public int updateMember(Member member) {
		Connection conn = template.getConnection();
		
		int res = 0;
		try {
			if(member.getSocialLogin().equals('Y')) {
				res = memberDao.updateSocailMember(member,conn);
				return res;
			}
			res = memberDao.updateMember(member,conn);
			System.out.println(res);
			
		} catch (Exception e) {
			template.rollback(conn);
		}finally {
			template.close(conn);
		}
		return res;
	}

	public Map<String,Object> selectFollower(String userIdx) {
		Connection conn = template.getConnection();
		Map<String,Object> follow = new HashMap<String, Object>();
		List<Follower> followerList = null;
		List<Following> followingList = null;
		try {
			followerList = mypageDao.selectFollower(userIdx, conn);
			followingList = mypageDao.selectFollowing(userIdx, conn);
			
			follow.put("follower", followerList);
			follow.put("following", followingList);
			
		} finally {
			template.close(conn);
		}
		
		return follow;
	}

}
