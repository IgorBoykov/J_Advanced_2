package Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "4467Igor619";
	private static String URL = "jdbc:mysql://localhost:3306/Human ?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";

	public static Connection openConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
	}

}
