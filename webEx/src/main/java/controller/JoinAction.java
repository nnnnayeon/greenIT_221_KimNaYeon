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
 * Servlet implementation class JoinAction
 */
//@WebServlet("/JoinAction")
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		UserDAO dao = UserDAO.getInstance();
		UserDTO user = null;
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String[] password = request.getParameterValues("password");
		String name = request.getParameter("name");
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("day"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String mobile = request.getParameter("mobile");
		
		user = new UserDTO(id, password[0], name, year, month, day, gender, email, country, mobile);
		
		String url = "";
		if(!dao.addUser(user)){
			// 중복으로 인한 회원가입 실패
			// join.jsp
			System.out.println("회원가입 실패");
			url = "_02.join.jsp";
		}
		else{
			// 회원가입 성공
			// login.jsp 로 페이지 이동
			System.out.println("회원가입 성공");
			url = "_00.index.jsp";
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
