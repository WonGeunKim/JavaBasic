package DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBPool {

	public Connection conn;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	
	// 기본 생성자
	public DBPool() {
		
		try {
			
			// 커넥션 풀 (DataSource) 얻기
			Context initCtx = new InitialContext();
			Context ctx = (Context) initCtx.lookup("java:comp/env");
			DataSource source = (DataSource) ctx.lookup("dbcp_myoracle");
			
			// 커넥션 풀을 통해 연결
			conn = source.getConnection();
			
			System.out.println("DB 커넥션풀 연결 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 커넥션풀 연결 실패");
		}
		
	}
	
	
	// 연결 해제
	public void close() {
		
        try {            
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();  // 자동으로 커넥션 풀로 반납됨

            System.out.println("DB 커넥션 풀 자원 반납");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
}
