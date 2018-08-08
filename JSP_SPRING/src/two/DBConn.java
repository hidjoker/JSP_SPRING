package two;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	// DB ?—°ê²? ? •ë³?
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";

	private static Connection conn = null; //?—°ê²°ê°ì²? 

	private DBConn() { } //DBConn ê°ì²´ ?ƒ?„± ë°©ì?

	// Connection ê°ì²´ ë°˜í™˜ - Singleton Pattern 
	public static Connection getConnection() {
		if( conn == null ) { // DB?—°ê²°ì´ ?•ˆ ?˜?–´?ˆ?„ ?•Œë§? ?™?‘
			try {
				Class.forName(DRIVER); //?“œ?¼?´ë²„ë¡œ?“œ
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); //DB?—°ê²?

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn; //DB?—°ê²°ê°ì²? ë°˜í™˜
	}
}