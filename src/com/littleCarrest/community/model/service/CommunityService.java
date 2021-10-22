package com.littleCarrest.community.model.service;

import java.sql.Connection;
import java.util.List;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.common.file.FileDTO;
import com.littleCarrest.community.model.dao.CommunityDao;
import com.littleCarrest.community.model.dto.Community;
import com.littleCarrest.member.model.dto.Member;

public class CommunityService {
	
	JDBCTemplate template = JDBCTemplate.getInstance();
	CommunityDao communityDao = new CommunityDao();

	public Object getBoardDetail(String scIdx) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertBoard(Community community, List<FileDTO> fileDTOs, List<String> tags) {
		Connection conn = template.getConnection();
		try {
			communityDao.insertBoard(community, conn);
			
			for (FileDTO fileDTO : fileDTOs) {
				communityDao.insertFile(community,fileDTO, conn);
			}
			for (String tag : tags) {
				communityDao.insertHasgtag(tag, conn);
			}
			
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
		}finally {
			template.close(conn);
		}
		
	}


	public List<String> selectCamperTag(String userId) {
		Connection conn = template.getConnection();
		List<String> camperList =  null;
		
		try {
			camperList = communityDao.selectCamperTag(userId,conn);
		} finally {
			template.close(conn);
		}
		
		return camperList;
	}

	public List<Member> selectBestCamper() {
		Connection conn = template.getConnection();
		List<Member> camperList =  null;
		
		try {
			camperList = communityDao.selectBestCamper(conn);
		} finally {
			template.close(conn);
		}
		
		return camperList;
	}

	public Member selectMemberByIdx(String userIdx) {
		Connection conn = template.getConnection();
		Member member = null;
		
		try {
			member = communityDao.selectMemberByIdx(userIdx,conn);
		} finally {
			template.close(conn);
		}
		
		return member;
	}

}
