package com.benq.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.benq.member.model.service.MemberService;
import com.benq.member.model.vo.Member;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/member/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// UPDATE MEMBER_TBL SET EMAIL = ?, PHONE = ?, ADDRESS = ?, HOBBY = ? WHERE MEMBER_ID = ?
			// 한글 깨지지 않아야 함.
			request.setCharacterEncoding("UTF-8");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String hobby = request.getParameter("hobby");
			String memberId = request.getParameter("memberId");
			Member member = new Member();
			member.setEmail(email);
			member.setPhone(phone);
			member.setAddress(address);
			member.setHobby(hobby);
			member.setMemberId(memberId);
			MemberService mService = new MemberService();
			int result = mService.updateMember(member);
			if(result > 0) {
				// 마이페이지로 가서 수정 확인
				// 완료된 후 마이페이지 서블릿을 호출하면 됨
				response.sendRedirect("/member/mypage.do?memberId="+memberId);
			}else {
				request.setAttribute("msg", "정보수정이 완료되지 않았습니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
			}
		} catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp");
			view.forward(request, response);
		}
		
		
	}

}









