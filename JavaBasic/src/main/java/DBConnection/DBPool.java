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
			// "java:comp/env/" 까지는 고정이고 그 뒤는 context.xml 파일에 기입할 정보 중 name 값을 넣어주면 된다 
			
			// Context 객체에서 메소드를 통해 Object 타입으로 반환 받은 뒤 타입 캐스팅을 통해 변환
			// => Object 타입으로 받는 이유 : 외부 리소스 종류에 따라 관리하는 클래스가 달라질 수 있기 때문
			
			
			DataSource source = (DataSource) ctx.lookup("dbcp_myoracle");
			// DataSource는 DB Driver 연결, Connection 객체를 관리하는 역할을 하는 인터페이스
			
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
