package com.benq.calculator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstNum  = request.getParameter("first-num");
		String operator  = request.getParameter("operator");
		String secondNum = request.getParameter("second-num");
		int num1 = Integer.parseInt(firstNum);
		int num2 = Integer.parseInt(secondNum);
		int result = 0;
		switch(operator) {
			case "+" : result = num1 + num2; break;
			case "-" : result = num1 - num2; break;
			case "*" : result = num1 * num2; break;
			case "/" : result = num1 / num2; break;
			case "%" : result = num1 % num2; break;
		}
		request.setAttribute("firstNum", firstNum);
		request.setAttribute("secondNum", secondNum);
		request.setAttribute("operator", operator);
		request.setAttribute("calcResult", result);
		request.getRequestDispatcher("/calculator/resultCalc.jsp").forward(request, response);
	}

}
























