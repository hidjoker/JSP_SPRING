package JSP2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import dbutil.DBConn;
import dto.Member;

public class MemberDaoImpl implements MemberDao{

	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	@Override
	public boolean join(Member insertMember) {
		
		conn = DBConn.getConnection();
		
		String beforeSql = "SELECT COUNT(*) FROM member"
				+ " WHERE userId='"+insertMember.getUserId()+"'";
		
		String sql="INSERT INTO member (userId, nick, email)"
				+"VALUES(?,?,?)";
		
		try {
			//--- ?‚¬? „?— PK ì¤‘ë³µ?¸ì§? ê²??‚¬ ---
			st=conn.createStatement();
			rs=st.executeQuery(beforeSql);
			
			while(rs.next()) {
				if(rs.getInt(1)>0) return false;	
			}
			//-------------------------
			
			//--- INSERT ?ˆ˜?–‰(?šŒ?›ê°??ž…) ---
			ps=conn.prepareStatement(sql);
			ps.setString(1, insertMember.getUserId());
			ps.setString(2, insertMember.getNick());
			ps.setString(3, insertMember.getEmail());
			ps.executeUpdate();
			//--------------------------
			
			
			//--- INSERT ?›„ ?‚½?ž… ?ž˜ ?˜?—ˆ?Š”ì§? ê²??‚¬ ---
			st=conn.createStatement();
			rs=st.executeQuery(beforeSql);
			
			while(rs.next()) {
				if(rs.getInt(1)>0) return true;
				else return false;				
			}
			//------------------------------
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}		
		return false;
	}

}
