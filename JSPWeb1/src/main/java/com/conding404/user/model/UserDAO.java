package com.conding404.user.model;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	//싱글턴 형테의 클래스로 생성하는 편이 좋습니다.
	//1.나자신의 객체를 스태틱으로 선언
	private static UserDAO instance = new UserDAO();
	//2.직접 생성하지 못하도록 생성자 제한
	private UserDAO() {
		//생성자에서 드라이버 클래스 호출
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			
		}
	}
	//3.getter 를 통해서 샛체를 반환
	public static UserDAO getInstance() {
		return instance;
		
	}
	
	//데이터베이스 연결 주소
	//+오라클 커넥터
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "JSP";
	private String upw = "JSP";
	
	/*
	 * 20230608 아이디 중복 검사
	 */
	
	public int idCheck(String id) {
		int result = 1;
		String sql = "select * from users where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//1.Connector
			conn = DriverManager.getConnection(url, uid, upw);
			
			//2.Pstmt - sql을 실헹하기 위한 클래스
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			//3.ResultSet
			rs = pstmt.executeQuery();//select문 
			if(rs.next()) {//중복 있음
				result = 1;
			} else {//중복없음
			result = 0;
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				
			}
		}
		return result;
	}
	
	//회원가입
	public void join(UserVO vo) {
		
		String sql = "insert into users(id, pw, name, email, gender) values(?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DriverManager.getConnection(url,uid,upw);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getGender());
			
			pstmt.executeUpdate();//성공시 1, 실패시 0

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

	//로그인
	public UserVO login(String id, String pw) {
		
		//로그인 성공이면 객체가 반환, 로그인 실패면 반환
		UserVO vo = null;
		
		String sql ="select * from users where id = ? and pw = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {

				String id2 = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				vo = new UserVO(id2, null, name, email, gender, regdate);
			}
			
		} catch (Exception e) {
			
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				
			}
		}
		
		return vo;
	}
}
