package com.littleCarrest.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.littleCarrest.common.db.JDBCTemplate;
import com.littleCarrest.common.exception.DataAccessException;
import com.littleCarrest.member.model.dto.Follower;
import com.littleCarrest.member.model.dto.Following;


public class MypageDao {
	
	JDBCTemplate template = JDBCTemplate.getInstance();

	public List<Follower> selectFollower(String userIdx, Connection conn) {
		List<Follower> followerList = new ArrayList<Follower>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String query = "select follower_idx,follower_id from follower where user_idx = ?";
		
		try {			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userIdx);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Follower follower = new Follower();
				follower.setFollowerIdx(rset.getString("follower_idx"));
				follower.setFollowerId(rset.getString("follower_id"));
				followerList.add(follower);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}

		return followerList;
	}

	public List<Following> selectFollowing(String userIdx, Connection conn) {
		List<Following> followingList = new ArrayList<Following>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String query = "select following_idx,following_id from following where user_idx = ?";
		
		try {			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userIdx);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Following following = new Following();
				following.setFollowingIdx(rset.getString("following_idx"));
				following.setFollowingId(rset.getString("following_id"));
				followingList.add(following);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}

		return followingList;
	}
}
