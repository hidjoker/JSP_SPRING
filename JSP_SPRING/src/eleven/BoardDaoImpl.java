package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBUtil.DBConn;
import board.dto.Board;
import board.util.Paging;

public class BoardDaoImpl implements BoardDao {

	// DB 연결 객체
	private Connection conn = DBConn.getConnection();
	
	// JDBC 객체
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List selectAll() {
		
		// 전체조회 쿼리
		String sql =
				"SELECT" + 
				"    boardno," + 
				"    title," + 
				"    writerid," + 
				"    writer," + 
				"    content," + 
				"    hit," + 
				"    recommend," + 
				"    writtendate" + 
				" FROM board" + 
				" ORDER BY boardno";
		
		// 결과 List
		List boardList = new ArrayList();
		try {
			// PreparedStatement 생성
			ps = conn.prepareStatement(sql);
			
			// ResultSet 반환
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				Board board = new Board();
				
				board.setBoardno( rs.getInt("boardno") );
				board.setTitle( rs.getString("title") );
				board.setWriterid( rs.getString("writerid") );
				board.setWriter( rs.getString("writer") );
				board.setContent( rs.getString("content") );
				board.setHit( rs.getInt("hit") );
				board.setRecommend( rs.getInt("recommend") );
				board.setWrittendate( rs.getDate("writtendate") );
				
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return boardList;
	}

	@Override
	public int selectCntAll() {
		String sql = "SELECT count(*) FROM board";
		
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

	@Override
	public List selectPagingList(Paging paging) {
		
		String sql
			= "SELECT * FROM (" + 
			"    SELECT rownum rnum, B.* FROM (" + 
			"        SELECT * FROM board" + 
			"        ORDER BY boardno DESC" + 
			"    ) B" + 
			"    ORDER BY rnum" + 
			" )" + 
			" WHERE rnum BETWEEN ? AND ?";
		
		List boardList = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo() );
			ps.setInt(2, paging.getEndNo() );

			// ResultSet 반환
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				Board board = new Board();
				
				board.setBoardno( rs.getInt("boardno") );
				board.setTitle( rs.getString("title") );
				board.setWriterid( rs.getString("writerid") );
				board.setWriter( rs.getString("writer") );
				board.setContent( rs.getString("content") );
				board.setHit( rs.getInt("hit") );
				board.setRecommend( rs.getInt("recommend") );
				board.setWrittendate( rs.getDate("writtendate") );
				
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return boardList;
	}

	@Override
	public void insertBoard(Board board) {
		
		String sql = "INSERT INTO BOARD(boardno,title,writer,content,hit,recommend)"
				+ "VALUES(?,?,?,?,?,?)";
		int check = 0;
		try {
			System.out.println("트라이문 진입!");
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno());
			ps.setString(2, board.getTitle());
			ps.setString(3, board.getWriter());
			ps.setString(4, board.getContent());
			ps.setInt(5, board.getHit());
			ps.setInt(6, board.getRecommend());
			
			ps.executeQuery();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}











