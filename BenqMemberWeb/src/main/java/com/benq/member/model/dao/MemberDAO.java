package com.benq.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.benq.member.model.vo.Member;

public class MemberDAO {

	public int insertMember(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT)";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPw());
		pstmt.setString(3, member.getMemberName());
		pstmt.setString(4, member.getGender());
		pstmt.setInt(5, member.getAge());
		pstmt.setString(6, member.getEmail());
		pstmt.setString(7, member.getPhone());
		pstmt.setString(8, member.getAddress());
		pstmt.setString(9, member.getHobby());
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	public int updateMember(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER_TBL SET EMAIL = ?, PHONE = ?, ADDRESS = ?, HOBBY = ? WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getEmail());
		pstmt.setString(2, member.getPhone());
		pstmt.setString(3, member.getAddress());
		pstmt.setString(4, member.getHobby());
		pstmt.setString(5, member.getMemberId());
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	public int deleteMember(Connection conn, String memberId) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	public Member checkLogin(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member mOne = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPw());
		rset = pstmt.executeQuery();
		if(rset.next()) {
			mOne = new Member();
			mOne.setMemberId(rset.getString("MEMBER_ID"));
			mOne.setMemberName(rset.getString("MEMBER_NAME"));
		}
		pstmt.close();
		rset.close();
		return mOne;
	}

	public Member selectOneById(Connection conn, String memberId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			member = new Member();
			member.setMemberId(rset.getString("MEMBER_ID"));
			member.setMemberName(rset.getString("MEMBER_NAME"));
			member.setGender(rset.getString("GENDER"));
			member.setAge(rset.getInt("AGE"));
			member.setEmail(rset.getString("EMAIL"));
			member.setPhone(rset.getString("PHONE"));
			member.setAddress(rset.getString("ADDRESS"));
			member.setHobby(rset.getString("HOBBY"));
			member.setRegDate(rset.getDate("REG_DATE"));
		}
		return member;
	}

}













