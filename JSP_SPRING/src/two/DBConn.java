package two;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	// DB ?���? ?���?
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";

	private static Connection conn = null; //?��결객�? 

	private DBConn() { } //DBConn 객체 ?��?�� 방�?

	// Connection 객체 반환 - Singleton Pattern 
	public static Connection getConnection() {
		if( conn == null ) { // DB?��결이 ?�� ?��?��?��?�� ?���? ?��?��
			try {
				Class.forName(DRIVER); //?��?��?��버로?��
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); //DB?���?

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn; //DB?��결객�? 반환
	}
}