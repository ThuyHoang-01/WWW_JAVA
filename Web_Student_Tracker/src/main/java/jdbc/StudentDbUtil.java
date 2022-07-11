package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	private DataSource dataSource;

	public StudentDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Student> getStudents() throws Exception {
		List<Student> students = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			// Get a connection
			myConn = dataSource.getConnection();

			// Create SQL statement
			String query = "select * from student order by id";
			myStmt = myConn.createStatement();

			// Execute query
			myRs = myStmt.executeQuery(query);

			// Process result set
			while (myRs.next()) {
				int id = myRs.getInt("id");
				String firstName = myRs.getString("firstName");
				String lastName = myRs.getString("lastName");
				String email = myRs.getString("email");

				// Create new Student Object
				Student tempStudent = new Student(id, firstName, lastName, email);

				// Add it to the list of students
				students.add(tempStudent);
			}
			return students;
		} finally {
			// Close JDBC Object
			close(myConn, myStmt, myRs);
		}
	}

	public void addStudent(Student student) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// Get DB Connection
			myConn = dataSource.getConnection();

			// Create SQL query for Insert
			String query = "insert into student (firstName, lastName, email) values (?, ?, ?)";

			// Prepare statement
			myStmt = myConn.prepareStatement(query);

			// Set the param values for the student
			myStmt.setString(1, student.getFirstName());
			myStmt.setString(2, student.getLastName());
			myStmt.setString(3, student.getEmail());

			// Execute SQL statement
			myStmt.execute();
		} finally {
			// Clean up JDBC Objects
			close(myConn, myStmt, null);
		}
	}

	public void updateStudent(Student student) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// Get DB Connection
			myConn = dataSource.getConnection();

			// Create SQL query for Update
			String query = "update student set firstName=?, lastName=?, email=? where id=?";

			// Prepare statement
			myStmt = myConn.prepareStatement(query);

			// Set params
			myStmt.setString(1, student.getFirstName());
			myStmt.setString(2, student.getLastName());
			myStmt.setString(3, student.getEmail());
			myStmt.setInt(4, student.getId());

			// Execute SQL statement
			myStmt.execute();
		} finally {
			// Clean up JDBC Objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteStudent(String studentID) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// Get DB Connection
			myConn = dataSource.getConnection();

			int studentId = Integer.parseInt(studentID);

			// Create SQL query for Delete
			String query = "delete student where id=?";

			// Prepare statement
			myStmt = myConn.prepareStatement(query);

			// Set params
			myStmt.setInt(1, studentId);

			// Execute SQL statement
			myStmt.execute();
		} finally {
			// Clean up JDBC Objects
			close(myConn, myStmt, null);
		}
	}

	public Student getStudent(String studentID) throws Exception {
		Student student = null;

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		int studentId;

		try {
			// Get DB Connection
			myConn = dataSource.getConnection();

			studentId = Integer.parseInt(studentID);

			// Create SQL query for Select
			String query = "select * from student where id=?";

			// Prepare statement
			myStmt = myConn.prepareStatement(query);

			// Set params
			myStmt.setInt(1, studentId);

			// Execute SQL statement
			myRs = myStmt.executeQuery();

			// Retrieve data from result set row
			if (myRs.next()) {
				String firstName = myRs.getString("firstName");
				String lastName = myRs.getString("lastName");
				String email = myRs.getString("email");

				// Use the studentId during construction
				student = new Student(studentId, firstName, lastName, email);
			} else {
				throw new Exception("Could not find student id: " + studentId);
			}

			return student;
		} finally {
			// Clean up JDBC Objects
			close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close(); // Does not really close... just puts back in connection pool
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
