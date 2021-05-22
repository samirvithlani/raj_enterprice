package com.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.product.ProductBean;
import com.dao.product.ProductDao;

/**
 * Servlet implementation class ViewProductController
 */
public class ViewProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// String url = request.getRequestURL().toString();

		/// url = url.substring(url.lastIndexOf("\\") + 1, url.length());

		List<ProductBean> phoneList = null;
		String flag = request.getParameter("flag");
		System.out.println(flag);
		int sort = 0;
		if (flag != null) {

			sort = Integer.parseInt(flag);

		} else {

			phoneList = new ProductDao().getAllPhones();
			request.setAttribute("phoneList", phoneList);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		phoneList = new ProductDao().getAllPhones(sort);
		request.setAttribute("phoneList", phoneList);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
