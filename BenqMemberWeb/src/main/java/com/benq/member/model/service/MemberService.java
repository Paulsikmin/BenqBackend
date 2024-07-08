package com.benq.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.benq.common.JDBCTemplate;
import com.benq.member.model.dao.MemberDAO;
import com.benq.member.model.vo.Member;

public class MemberService {
	
	private MemberDAO mDao;
	
	public MemberService() {
		mDao = new MemberDAO();
	}

	public int insertMember(Member member) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = mDao.insertMember(conn, member);
//			if(result > 0) {
//				conn.commit();
//			}else {
//				conn.rollback();
//			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateMember(Member member) {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCTemplate.getConnection();
			result = mDao.updateMember(conn, member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteMember(String memberId) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = mDao.deleteMember(conn, memberId);
			// 결과에 따른 커밋/롤백
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Member checkLogin(Member member) {
		Connection conn = null;
		Member mOne = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			mOne = mDao.checkLogin(conn, member);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mOne;
	}

	public Member selectOneById(String memberId) {
		Connection conn = null;
		Member member = null;
		try {
			conn = JDBCTemplate.getConnection();
			member = mDao.selectOneById(conn, memberId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}

}

















