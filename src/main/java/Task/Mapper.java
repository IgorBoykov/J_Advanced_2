package Task;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mapper {
	public static Student showStudent(ResultSet resSet) throws SQLException {
		int id = resSet.getInt("id");
		String name = resSet.getString("name");
		int age = resSet.getInt("age");

		return new Student(id, name, age);
	}

}
