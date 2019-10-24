package edu.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCProxy {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.out.println("Class Load Failed");
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Connection Failed");
		}
		
		return conn;
	}
	
	public static void close(Connection conn, Statement st, ResultSet rs) {
		if(rs != null) try { rs.close(); } catch (SQLException e) {e.printStackTrace();}
		if(st != null) try { st.close(); } catch (SQLException e) {e.printStackTrace();}
		if(conn != null) try { conn.close(); } catch (SQLException e) {e.printStackTrace();}
	}
	
	public static void close(Connection conn, Statement st) {
		if(st != null) try { st.close(); } catch (SQLException e) {e.printStackTrace();}
		if(conn != null) try { conn.close(); } catch (SQLException e) {e.printStackTrace();}
	}
}
