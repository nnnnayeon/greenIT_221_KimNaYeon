package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exWeb.UserDAO;
import exWeb.UserDTO;

/**
 * Servlet implementation class LoginAction
 */
//@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// doGet() 메소드 : http request method - GET
		
		UserDAO dao = UserDAO.getInstance();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserDTO user = new UserDTO(id, password);
		
		String url = "";
		if(!dao.loginUser(id, password)){
			System.out.println("로그인 실패");
			url = "_00.index.jsp";
		}
		else{
			System.out.println("로그인 성공");
			url = "_04.main.jsp";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("log",user.getId());
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// doPost() 메소드 : http request method - GET
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
