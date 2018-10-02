package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConectionTest {

	public static void main(String[] args) {
		RetrieveResultSet("Select title from Materials");
		// ChangeData("Update Materials set title = ? where id = ?","A second Test", 1);
		// RetrieveResultSet("Select * from Materials");
	}

	public static void ChangeData(String sql, String title, int id) {

		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
			try {
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				conn = DriverManager.getConnection("jdbc:derby://localhost/library");
				stm = conn.prepareStatement(sql);
				stm.setString(1, title);
				stm.setInt(2, id);
				int results = stm.executeUpdate();
				System.out.println("Records amended:" + results);
			} 
			finally {
				
				if (stm != null) stm.close();
				if (conn != null) {
					conn.close();
				}

			
			}
		}

		catch (ClassNotFoundException e) {
			System.out.println("Somthing went wrong");
			System.out.println(e);
		} catch (SQLException e) {

			System.out.println("Somthing went wrong");
			System.out.println(e);
		}
		
	}

	public static void RetrieveResultSet(String sql) {

		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			try {
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				conn = DriverManager.getConnection("jdbc:derby://localhost/library");
				stm = conn.createStatement();
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					System.out.println(rs.getString("title"));
				}
			} finally {
				if (rs != null)rs.close();
				if (stm != null)stm.close();
				if (conn != null)
				{
					conn.close();
					System.out.println("Connection was closed");
				}

				System.out.println("Finally was closed");
			}
		}

		catch (ClassNotFoundException e) {
			System.out.println("Somthing went wrong");
			System.out.println(e);
		} catch (SQLException e) {

			System.out.println("Somthing went wrong");
			System.out.println(e);
		}
	}

}
