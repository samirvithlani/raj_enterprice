package com.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bean.product.ProductBean;
import com.dao.product.ProductDao;

/**
 * Servlet implementation class AddProductController
 */
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String filePath = getServletContext().getInitParameter("file-upload");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String fileName = null;
		File file = null;
		String phonetype = null;

		ProductBean productBean = new ProductBean();

		try {
			items = upload.parseRequest(request);// Parse Request

			for (int i = 0; i < items.size(); i++) {

				FileItem item = items.get(i);

				if (item.isFormField()) {

					fieldName = item.getFieldName();
					fieldValue = item.getString();

					if (fieldName.equalsIgnoreCase("txtPhoneName")) {
						String value = fieldValue;
						System.out.println("phone Name =" + value);
						productBean.setpName(value);

					}

					if (fieldName.equalsIgnoreCase("txtPhoneDetail")) {
						String value = fieldValue;
						System.out.println("phone detail" + value);
						productBean.setpDetail(value);

					}

					if (fieldName.equalsIgnoreCase("pht")) {

						phonetype = fieldValue;
						System.out.println("phone type 1" + phonetype);
						productBean.setpType(phonetype);
						System.out.println("phone type 2" + productBean.getpType());

					}

					if (fieldName.equalsIgnoreCase("txtPhonePrice")) {

						String value = fieldValue;
						System.out.println("phonePrice =" + value);
						productBean.setpPrice(value);

					}

				}

				else {
					fieldName = item.getFieldName();
					System.out.println("FieldName : " + fieldName);
					fileName = item.getName();
					System.out.println("File Name : " + fileName);

					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
					System.out.println("File Name 1 : " + fileName);

					ServletContext context = getServletContext();
					// String appPath = context.getRealPath("\\");
					// System.out.println("Path : " + appPath);

					String path = "/upload";
					String abspath = getServletContext().getRealPath(path);
					System.out.println(abspath);

					file = new File(abspath + File.separator + fileName);

					try {

						if (fileName.isEmpty()) {

							// Validations....
						} else {
							System.out.println("MIME : " + context.getMimeType(fileName));
							if (context.getMimeType(fileName).equals("image/gif")
									|| context.getMimeType(fileName).equals("image/jpeg")
									|| context.getMimeType(fileName).equals("image/png")
									|| context.getMimeType(fileName).equals("application/pdf")
									|| context.getMimeType(fileName).equals("text/x-vcard"))

							{
								item.write(file);

								productBean.setpImageURL(file.getName());

								// request.setAttribute("fileName", file.getName());
								// request.getRequestDispatcher("success.jsp").forward(request, response);

							} else {

								request.setAttribute("photo",
										"<font color=red>*Please upload files that end in types .png,.jpeg only.</font>");
								request.getRequestDispatcher("student.jsp").forward(request, response);
							}
						}

						// dao

						if (new ProductDao().addProduct(productBean,phonetype)) {

							
							System.out.println("phone type dao if"+phonetype);
							response.sendRedirect("ViewProductController");
						} else {

							System.out.println("ERRORR");

						}

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
