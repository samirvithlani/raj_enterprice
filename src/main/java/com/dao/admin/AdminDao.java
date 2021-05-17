package com.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.admin.AdminBean;
import com.util.DBConnection;

public class AdminDao {

	Connection conn;
	PreparedStatement pstmt;

	public AdminBean loginAdmin(String aEmail, String aPassword) {

		conn = DBConnection.getDBConnection();
		AdminBean adminBean = null;
		if (conn != null) {

			String loginSQL = "select * from admin where aemail =? and apassword =?";
			try {

				pstmt = conn.prepareStatement(loginSQL);

				pstmt.setString(1, "samir@gmail.com");
				pstmt.setString(2, "sam123");

				ResultSet rs = pstmt.executeQuery();
				System.out.println(rs);

				while (rs.next()) {
					adminBean = new AdminBean();
					System.out.println("inside while");
					adminBean.setaId(rs.getInt("aid"));
					adminBean.setaName(rs.getString("aname"));
					adminBean.setaEmail(rs.getString("aemail"));
					adminBean.setaPassword(rs.getString("apassword"));
					adminBean.setaMobile(rs.getString("amobile"));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return adminBean;
	}
	
	
}
