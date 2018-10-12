package JSP10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.dto.Board;
import board.util.Paging;
import dbutil.DBConn;

public class BoardDao {

	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public List<Board> selectAll() {
		
		System.out.println("daoÏßÑÏûÖ!");
		conn = DBConn.getConnection();
		String sql = "SELECT * FROM BOARD";
		List<Board> list = new ArrayList<>();

		try {
			System.out.println("?ä∏?ùº?ù¥Î¨? ÏßÑÏûÖ!");
			st= conn.createStatement();
			rs = st.executeQuery(sql);			
				
			while(rs.next()) {
				System.out.println("???ùºÎ¨? ÏßÑÏûÖ");
				
				Board board = new Board();
				
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriterId(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setContent(rs.getString(5));
				board.setHit(rs.getInt(6));
				board.setRecommend(rs.getInt(7));
				board.setWrittenDate(rs.getDate(8).toString());
				
				list.add(board);

			}	
			
			return list;

			
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {			
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;			
	}	
	
	public int selectCntAll() {
		conn = DBConn.getConnection();
		String sql = "SELECT count(*) FROM board";
		int cnt = 0;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			rs.next();
			cnt = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
		
	}
	
	public List selectPagingList(Paging paging) {
		
		String sql = "select* from(" + 
				"    select rownum rnum, b.* FROM(" + 
				"        Select * FROM board" + 
				"        ORDER BY boardno DESC" + 
				"    )B" + 
				"    ORDER BY rnum" + 
				")" + 
				"where rnum between ? and ?";
		
		List<Board> list = new ArrayList<>();

		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				System.out.println("???ùºÎ¨? ÏßÑÏûÖ");
				
				Board board = new Board();
				
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriterId(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setContent(rs.getString(5));
				board.setHit(rs.getInt(6));
				board.setRecommend(rs.getInt(7));
				board.setWrittenDate(rs.getDate(8).toString());
				
				list.add(board);

			}	
			
			return list;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
