package com.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.admin.AdminBean;
import com.dao.admin.AdminDao;

/**
 * Servlet implementation class AdminLoginController
 */
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String aEmail = request.getParameter("txtAdminEmail");
		String aPassword = request.getParameter("txtAdminPassword");

		AdminBean adminBean = new AdminDao().loginAdmin(aEmail, aPassword);
		
		if(adminBean!=null) {
			
			HttpSession session  = request.getSession();
			session.setAttribute("adminBean", adminBean);
			response.sendRedirect("admin/addProduct.jsp");
		}
		else {
			
			response.sendError(405);
		}
		

		doGet(request, response);
	}

}
