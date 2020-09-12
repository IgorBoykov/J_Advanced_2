package Task;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		DAO studentDao = new DAO(ConnectionUtil.openConnection());

		studentDao.readAll().forEach(System.out::println);
		System.out.println();

		List<Student> list = new ArrayList();
		list.add(new Student("Igor", 28));
		list.add(new Student("Natali", 22));

		list.forEach(student -> {
			try {
				studentDao.insert(student);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});

		studentDao.delete(1);
		
		Student stud1 = studentDao.read_id(3);
		System.out.println(stud1);
		System.out.println();

		stud1.setAge(stud1.getAge() + 1);
		studentDao.update(stud1);

		studentDao.readAll().forEach(System.out::println);
	}

}
