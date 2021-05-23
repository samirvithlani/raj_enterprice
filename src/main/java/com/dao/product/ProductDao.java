package com.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.product.ProductBean;
import com.util.DBConnection;

public class ProductDao {

	Connection conn;
	PreparedStatement pstmt;

	public boolean deleteProduct(int pid) {

		boolean flag = false;

		conn = DBConnection.getDBConnection();
		if (conn != null) {

			String deleteSQL = "delete from product where pid=?";
			try {
				pstmt = conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, pid);
				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return flag;

	}

	public boolean addProduct(ProductBean productBean, String ptype) {
		boolean flag = false;

		conn = DBConnection.getDBConnection();
		if (conn != null) {

			String insertSQL = "insert into product(pname,pdetail,pprice,pimage,pstatus,ptype)values(?,?,?,?,?,?)";
			try {
				productBean.setpStatus(true);
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, productBean.getpName());
				pstmt.setString(2, productBean.getpDetail());
				pstmt.setDouble(3, new Double(productBean.getpPrice()));
				pstmt.setString(4, productBean.getpImageURL());
				pstmt.setBoolean(5, productBean.ispStatus());
				System.out.println("product type........................dao" + ptype);
				pstmt.setString(6, ptype);
				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;
				} else {
					flag = false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return flag;
	}

	public List<ProductBean> getAllPhones() {

		List<ProductBean> phoneList = new ArrayList();
		conn = DBConnection.getDBConnection();
		if (conn != null) {

			String selectSQL = "select * from product";
			try {
				pstmt = conn.prepareStatement(selectSQL);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {

					ProductBean productBean = new ProductBean();
					productBean.setpId(rs.getInt(1));
					productBean.setpName(rs.getString(2));
					productBean.setpDetail(rs.getString(3));
					productBean.setpPrice(rs.getString(4));
					productBean.setpImageURL(rs.getString(5));
					productBean.setpType(rs.getString(8));
					phoneList.add(productBean);

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return phoneList;

	}

	public List<ProductBean> getAllPhones(int sort) {

		List<ProductBean> phoneList = new ArrayList<ProductBean>();
		conn = DBConnection.getDBConnection();
		String selectSQL = null;
		if (conn != null) {

			if (sort == 3) {
				System.out.println("5000-10000");
				selectSQL = "select * from product where pprice between 5000 and 10000";
			}
			if (sort == 4) {
				System.out.println("10000-20000");
				selectSQL = "select * from product where pprice between 10000 and 20000";

			}
			if (sort == 5) {
				System.out.println("20000-30000");
				selectSQL = "select * from product where pprice between 20000 and 30000";
			}
			if (sort == 6) {
				System.out.println("30000-50000");
				selectSQL = "select * from product where pprice between 30000 and 50000";
			}
			if (sort == 7) {

				System.out.println("30000-50000");
				selectSQL = "select * from product where pprice between 500 and 3000";
			}
			try {
				pstmt = conn.prepareStatement(selectSQL);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {

					ProductBean productBean = new ProductBean();
					productBean.setpId(rs.getInt(1));
					productBean.setpName(rs.getString(2));
					productBean.setpDetail(rs.getString(3));
					productBean.setpPrice(rs.getString(4));
					productBean.setpImageURL(rs.getString(5));
					productBean.setpType(rs.getString(8));
					phoneList.add(productBean);

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return phoneList;

	}

}
