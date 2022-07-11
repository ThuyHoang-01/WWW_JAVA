package iuh.fit.mvc;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {
	public static List<Student> getStudents() {
		// Create empty list
		List<Student> students = new ArrayList<>();

		// Add sample data ( thêm + sửa + xóa )S
		students.add(new Student("Mary", "Jane", "mary@code.com"));
		students.add(new Student("John", "Doe", "john@code.com"));
		students.add(new Student("Ajay", "Rao", "ajay@code.com"));
		
		// Return the list
		return students;
	}
}
