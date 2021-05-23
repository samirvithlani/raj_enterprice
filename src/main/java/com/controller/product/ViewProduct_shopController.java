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
 * Servlet implementation class ViewProduct_shopController
 */
public class ViewProduct_shopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<ProductBean> phoneList = null;
		String flag = request.getParameter("flag");
		System.out.println(flag);
		int sort = 0;
		if (flag != null) {

			sort = Integer.parseInt(flag);
			if (sort == 3 || sort == 4 || sort == 5 || sort == 6 || sort ==7) {

				System.out.println("inside else if");
				phoneList = new ProductDao().getAllPhones(sort);
				request.setAttribute("phoneList", phoneList);
				request.getRequestDispatcher("shop.jsp").forward(request, response);

			}

		} else {

			System.out.println("else.....");
			phoneList = new ProductDao().getAllPhones();
			request.setAttribute("phoneList", phoneList);
			request.getRequestDispatcher("shop.jsp").forward(request, response);
		}

	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
