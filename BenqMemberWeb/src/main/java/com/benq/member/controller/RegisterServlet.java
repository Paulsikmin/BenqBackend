package com.benq.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.benq.member.model.service.MemberService;
import com.benq.member.model.vo.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/member/join.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect("/WEB-INF/views/member/register.jsp"); // X
		request.getRequestDispatcher("/WEB-INF/views/member/register.jsp").forward(request, response); // O
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId   = request.getParameter("member-id");
		String memberPw   = request.getParameter("memberPw");
		String memberName = request.getParameter("member-name");
		String gender     = request.getParameter("gender");
		String age 		  = request.getParameter("age");
		String email      = request.getParameter("email");
		String phone	  = request.getParameter("phone");
		String address    = request.getParameter("address");
		String hobby      = request.getParameter("hobby");
		
		// 회원가입 비즈니스 로직
//		Member member = new Member();
//		Member member = new Member(memberId, memberPw, ....);
		Member member = new Member(memberId, memberPw, memberName, gender, Integer.parseInt(age), email, phone, address, hobby);
		MemberService mService = new MemberService();
		int result = mService.insertMember(member);
		
		if(result > 0) {
			// 성공 메시지 출력
			// 1. redirect
			// response.sendRedirect("");
			// 2. requestDispatcher
			// request.setAttribute("msg", "성공");
			// request.getRequestDispatcher("").forward(request, response);
			response.sendRedirect("/index.jsp");
		}else {
			// 실패 메시지 출력
//			response.sendRedirect("/common/error/errorPage.jsp"); // errorPage.jps를 WEB-INF 아래로 옮겼기 때문에 불가능
			request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
		}
	}

}



















