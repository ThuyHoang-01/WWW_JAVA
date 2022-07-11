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

	private void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Student> getStudents() throws Exception {
		List<Student> students = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String query = "select * from student order by lastName desc";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String imageUrl = rs.getString("imageUrl");
				Student tempStudent = new Student(id, firstName, lastName, email, imageUrl);
				students.add(tempStudent);
			}
			return students;
		} finally {
			close(con, stmt, rs);
		}
	}

	public void addStudent(Student student) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
//			update add more id
			String query = "insert into student (firstName, lastName, email, imageUrl) values (?, ?, ?, ?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getEmail());
			stmt.setString(4, student.getImageUrl());
			stmt.execute();
		} finally {
			close(con, stmt, null);
		}
	}

	public void updateStudent(Student student) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			String query = "update student set firstName=?, lastName=?, email=?, imageUrl=? where id=?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getEmail());
			stmt.setString(4, student.getImageUrl());
			stmt.setInt(5, student.getId());
			stmt.execute();
		} finally {
			close(con, stmt, null);
		}
	}
	
	public void deleteStudent(String theStudentId) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			int studentId = Integer.parseInt(theStudentId);
			con = dataSource.getConnection();
			String query = "delete student where id=?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, studentId);
			stmt.execute();
		} finally {
			close(con, stmt, null);
		}
	}
	
	public Student getStudent(String theStudentId) throws Exception {
		Student student = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int studentId;
		try {
			studentId = Integer.parseInt(theStudentId);
			con = dataSource.getConnection();
			String query = "select * from student where id=?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, studentId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String imageUrl = rs.getString("imageUrl");
				student = new Student(studentId, firstName, lastName, email, imageUrl);
			} else {
				throw new Exception("Could not find student id: " + studentId);
			}
			return student;
		} finally {
			close(con, stmt, rs);
		}
	}
}
