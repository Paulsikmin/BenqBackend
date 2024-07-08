package com.benq.taste;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TasteServlet
 */
@WebServlet("/TasteServlet")
public class TasteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TasteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("user-name");
		String color    = request.getParameter("color");
		String pet      = request.getParameter("pet");
		String [] foods = request.getParameterValues("foods");
		
		Map<String, String> colorMap = new HashMap<String, String>();
		colorMap.put("red", "빨강");
		colorMap.put("blue", "파랑");
		colorMap.put("yellow", "노랑");
		colorMap.put("green", "초록");
		
		Map<String, String> petMap = new HashMap<String, String>();
		petMap.put("puppy", "강아지");
		petMap.put("kitty", "고양이");
		petMap.put("elephant", "코끼리");
		petMap.put("lion", "사자");
		
		Map<String, String> foodMap = new HashMap<String, String>();
		foodMap.put("jjm", "짜장면");
		foodMap.put("jjb", "짬뽕");
		foodMap.put("tsy", "탕수육");
		foodMap.put("mpdb", "마파두부");
		foodMap.put("pbc", "팔보채");
		
		String foodStr = "";
		for(String food : foods) {
			foodStr += foodMap.get(food) + ", ";
		}
		
//		response.sendRedirect("/taste/result.html");
		request.setAttribute("userName", userName);
		request.setAttribute("color", colorMap.get(color));
		request.setAttribute("pet", petMap.get(pet));
		request.setAttribute("foodStr", foodStr);
		request.getRequestDispatcher("/taste/tasteResult.jsp").forward(request, response);
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<html><head><title>개인 취향 테스트</title>");
//		out.println("</head><body>");
//		out.println("<h1>개인 취향 테스트 결과</h1>");
//		out.println("<p>이름? " + userName + "<br>");
//		out.println("좋아하는 색? <span style='color:"+color+";'><b>" 
//										+ colorMap.get(color) + "</b></span><br>");
//		out.println("좋아하는 동물은? " + petMap.get(pet) + "<br>");
//		out.println("좋아하는 음식은? " + foodStr);
//		out.println("</p>");
//		out.println("</body></html>");
	}

//	if("red".equals(color)) {
//	color = "<span style='color:red;'><b>빨강</b></span>";
//}else if("blue".equals(color)) {
//	color = "<span style='color:blue;'><b>파랑</b></span>";
//}else if("yellow".equals(color)) {
//	color = "<span style='color:yellow;'><b>노랑</b></span>";
//}else if("green".equals(color)) {
//	color = "<span style='color:green;'><b>초록</b></span>";
//}
}










