package JSP11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	// DB ?°ę˛? ? ëŗ?
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";

	private static Connection conn = null; //?°ę˛°ę°ė˛? 

	private DBConn() { } //DBConn ę°ė˛´ ??ą ë°Šė?

	// Connection ę°ė˛´ ë°í - Singleton Pattern 
	public static Connection getConnection() {
		if( conn == null ) { // DB?°ę˛°ė´ ? ??´?? ?ë§? ??
			try {
				Class.forName(DRIVER); //??ŧ?´ë˛ëĄ?
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); //DB?°ę˛?

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn; //DB?°ę˛°ę°ė˛? ë°í
	}
}



