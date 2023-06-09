package com.coding404.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class UserDAO {
	//싱글톤 형태의 클래스로 생성하는편이 좋습니다.
	//1. 나자신의 객체를 스태틱으로 선언
	private static UserDAO instance = new UserDAO();
	//2. 직접 생성하지 못하도록 생성자 제한
	private UserDAO() {
		//생성자에서 드라이버클래스 호출
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
		
	}
	//3. getter를 통해서 객체를 반환
	public static UserDAO getInstance() {
		return instance;
	}
	
	//데이터베이스 연결 주소
	//+오라클 커넥터
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "JSP";
	private String upw = "JSP";	
	
	/**
	 * 
	 * @author 20230608 홍길동 중복검사
	 */
	public int idCheck(String id) {
		
		int result = 1;
		
		String sql = "select * from users where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			//1. Connector - 디비연결
			conn = DriverManager.getConnection(url, uid, upw);
			//2. Pstmt - sql을 실행하기 위한 클래스
			pstmt = conn.prepareStatement(sql);
			pstmt.setString( 1, id);
			//3. ResultSet
			rs = pstmt.executeQuery(); //select문
			
			if(rs.next()) { //중복 o
				result = 1;
			} else { //중복 x
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
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId() );
			pstmt.setString(2, vo.getPw() );
			pstmt.setString(3, vo.getName() );
			pstmt.setString(4, vo.getEmail() );
			pstmt.setString(5, vo.getGender() );
			
			pstmt.executeUpdate(); //성공시 1, 실패시 0
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}
	
	//로그인
	public UserVO login(String id, String pw) {
		
		//로그인 성공이면 객체가 반환, 로그인 실패면 null값이 반환
		UserVO vo = null;
		
		String sql = "select * from users where id = ? and pw = ?";
		
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
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
		
		return vo;
	}
	
	//회원정보 조회
	public UserVO getInfo(String id) {
		
		UserVO vo = null;
		
		String sql = "select * from users where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); //id
			
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {//id는 pk라서 1행
				
				String id2 = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String gender =rs.getString("gender");
				
				vo = new UserVO(id2, null, name, email, gender, null);
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
		
		
		
		return vo;
	}
	
	//회원정보 수정
	public int updateInfo(UserVO vo) {
		
		
		String sql = "update users "
					+"set pw = ?, name = ?, email = ?, gender = ?  where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw()); //id
			pstmt.setString(2, vo.getName()); //id
			pstmt.setString(3, vo.getEmail()); //id
			pstmt.setString(4, vo.getGender()); //id
			pstmt.setString(5, vo.getId()); //id
			
			rs = pstmt.executeUpdate(); //성공 1, 실패 0
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
			}
		}
		return rs;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
