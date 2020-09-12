package Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

	public static String READ_ALL = "select * from student";
	public static String CREATE = "insert into student(name, age) values(?,?)";
	public static String DELETE = "delete from student where id =?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public DAO(Connection connection) {
		this.connection = connection;
	}

	public List<Student> readAll() throws SQLException {
		List<Student> studentList = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			studentList.add(Mapper.showStudent(result));
		}
		return studentList;
	}

	public void insert(Student student) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, student.getName());
		preparedStatement.setInt(2, student.getAge());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

}
