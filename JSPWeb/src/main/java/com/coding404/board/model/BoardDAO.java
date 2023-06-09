package com.coding404.board.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.coding404.user.model.UserDAO;

public class BoardDAO {
	//싱글톤 형태의 클래스로 생성하는편이 좋습니다.
		//1. 나자신의 객체를 스태틱으로 선언
		private static BoardDAO instance = new BoardDAO();
		//2. 직접 생성하지 못하도록 생성자 제한
		private BoardDAO() {
			//생성자에서 드라이버클래스 호출
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (Exception e) {
			}
			
		}
		//3. getter를 통해서 객체를 반환
		public static BoardDAO getInstance() {
			return instance;
		}
		
		//데이터베이스 연결 주소
		//+오라클 커넥터
		private String url = "jdbc:oracle:thin:@localhost:1521:xe";
		private String uid = "JSP";
		private String upw = "JSP";	
		
		//글 등록
		public void regist(String writer,String title, String content) {
			
			String sql = "INSERT INTO BOARD(BNO, WRITER, TITLE, CONTENT) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?)";
			
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				
				conn = DriverManager.getConnection(url, uid, upw);
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, writer);
				pstmt.setString(2, title);
				pstmt.setString(3, content);
				
				pstmt.executeUpdate(); //끝
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		
		//목록을 조회
		public List <BoardVO> getList() {

			List <BoardVO> list = new ArrayList<>();
			
			String sql = "SELECT * FROM BOARD ORDER BY BNO DESC";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				
				conn = DriverManager.getConnection(url, uid, upw);
				
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery(); //끝
				
				/*
				 * 조회된 데이터를 순서대로 vo에 담고 리스트에 추가하는 프로그램 코드
				 */
				while(rs.next()) {
					//1행에 대한 처리
					int bno = rs.getInt("bno");
					String writer = rs.getString("writer");
					String title = rs.getString("title");
					String content = rs.getString("content");
					int hit = rs.getInt("hit");
					Timestamp regdate = rs.getTimestamp("regdate");
					
					BoardVO vo = new BoardVO(bno, writer, title, content, hit, regdate);
					
					list.add(vo);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				} catch (Exception e2) {
					
				}
			}
			
			
			return list;
		}
		
		//글내용을 조회
		public BoardVO getContent(String bno) {
			BoardVO vo = null;
			String sql = "select * from board where bno = ?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				
				conn = DriverManager.getConnection(url, uid, upw);
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bno);
				
				rs = pstmt.executeQuery(); //끝
				
				if(rs.next()) {
					int bno2 = rs.getInt("bno");
					String writer = rs.getString("writer");
					String title = rs.getString("title");
					String content = rs.getString("content");
					int hit = rs.getInt("hit");
					Timestamp regdate = rs.getTimestamp("regdate");
					
					vo = new BoardVO(bno2, writer, title, content, hit, regdate);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
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
		
		
		public void update(String bno,
						   String title,
						   String content) {
			
			String sql = "update board set title = ?, content = ? where bno = ?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DriverManager.getConnection(url,uid, upw);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setString(3, bno);
				
				pstmt.executeUpdate(); //끝
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
					
				}
			}
			
		}

		public void delete() {
			String sql = "delete from board where bno = ?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			
		}
		
}
