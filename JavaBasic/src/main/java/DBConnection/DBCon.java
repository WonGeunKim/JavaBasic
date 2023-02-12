package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;

public class DBCon {

	public Connection conn;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	// 기본 생성자
	public DBCon() {
		
		try {
			
			// JDBC 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			// DB 연결
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			conn = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(기본)");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	
	// 두번째 생성자
	public DBCon(String driver, String url, String id, String pwd) {
		
		try {
			
			// JDBC 드라이버 로드
			Class.forName(driver);
			
			// DB 연결
			conn = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(두번째)");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 세번째 생성자
	public DBCon(ServletContext app) {
		
		try {
			
			// JDBC 드라이버 로드
			String driver = app.getInitParameter("OracleDriver");
			Class.forName(driver);
			
			// DB 연결
			String url = app.getInitParameter("OracleURL");
			String id = app.getInitParameter("OracleId");
			String pwd = app.getInitParameter("OraclePwd");
			
			conn = DriverManager.getConnection(url, id, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 연결 해제
	public void close() {
		
		try {
			
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
			System.out.println("JDBC 자원 해체");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
