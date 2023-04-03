package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.BoardDTO;

public class BoardDAO {
	
	// 모든 메소드가 사용할 공통 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	// Connection 관리를 위한 DataSource 필드
	private DataSource dataSource;
	
	// Singleton pattern으로 DAO 생성하기
	private static BoardDAO dao = new BoardDAO();
	private BoardDAO() {
		// context.xml에서 <Resource name="jdbc/GDJ61"	/>인 Resource를 읽어서 DataSource 객체 생성하기 (JNDI 방식)
		try {
			Context context = new InitialContext();
			Context envContext = (Context)context.lookup("java:comp/env");
			dataSource = (DataSource)envContext.lookup("/jdbc/GDJ61");
			/*
			 Context context = new InitialContext();
			 dataSource = (DataSource)context.lookup("java:comp/env/jdbc/GDJ61"); 
			 */
		} catch(NamingException e) {
			e.printStackTrace();
		}
		
		
	}
	public static BoardDAO getInstance() { // 메소드(static)->필드(static)
		return dao;
	}
	
	// 자원(Connection, PreparedStatement, ResultSet) 반납하기
	private void close() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null)con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 게시글 목록 반환하기
	public List<BoardDTO> selectBoardList() {
		
		// 1. ArrayList 생성
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		try {

			// 2. DataSource로부터 Connection 얻어 오기
			con = dataSource.getConnection();
			
			// 3. 실행할 쿼리문
			sql = "SELECT BOARD_NO, TITLE, CONTENT, MODIFIED_DATE, CREATED_DATE FROM BOARD ORDER BY BOARD_NO DESC";
			
			// 4. 쿼리문을 실행할 PreparedStatement 객체 생성
			ps = con.prepareStatement(sql);
			
			// 5. PreparedStatement 객체를 이용해 쿼리문 실행(SELECT문 실행은 executeQuery 메소드로 한다.)
			rs = ps.executeQuery();
			
			// 6. ResultSet 객체(결과 집합)를 이용해서 ArrayList로 만듬
			while(rs.next()) {
				
				// Step1. Board 테이블의 결과 행(ROW)을 읽는다.
				int board_no = rs.getInt("BOARD_NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Date modified_date = rs.getDate("MODIFIED_DATE");
				Date created_date = rs.getDate("CREATED_DATE");
				
				// Step2. 읽은 정보를 이용해서 BoardDTO 객체를 만든다.
				BoardDTO board = new BoardDTO(board_no, title, content, modified_date, created_date);
				
				// Step3. BoardDTO 객체를 ArrayList에 추가한다.
				boardList.add(board);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 예외 발생 여부와 상관 없이 항상 자원의 반납을 해야 한다.	
		close();
		}
		// 7. ArrayList 반환
			return boardList;
		
	}
	
	// 게시글 반환하기
	public BoardDTO selectBoardByNo(int board_no) {
		
		return null;
	}

	// 게시글 삽입하기
	public int insertBoard(BoardDTO board) {
		
		return 0;
	}
	
	// 게시글 수정하기
	public int updateBoard(BoardDTO board) {
		
		return 0;
	}
	
	// 게시글 삭제하기
	public int deleteBoard(int board_no) {
		
		return 0;
	}
}
