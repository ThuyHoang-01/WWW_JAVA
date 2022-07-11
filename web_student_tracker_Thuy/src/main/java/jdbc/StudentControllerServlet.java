package jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDbUtil studentDbUtil;

	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();

		// Create our student db until ... and pass in the conn pool / datasource
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Read the "command" parameter
			String theCommand = request.getParameter("command");

			// If the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}

			// Switch to approriate method
			switch (theCommand) {
			case "LIST":
				listStudents(request, response);
				break;
			case "ADD":
				addStudent(request, response);
				break;
			case "LOAD":
				loadStudent(request, response);
				break;
			case "UPDATE":
				updateStudent(request, response);
				break;
			case "DELETE":
				deleteStudent(request, response);
				break;
			default:
				listStudents(request, response);
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Get students from StudentDbUtil
		List<Student> students = studentDbUtil.getStudents();
		
		// Add students to the request
		request.setAttribute("STUDENT_LIST", students);
		
		// Send to JSP page (View)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Read student info from Form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		// Create new student Object
		Student student = new Student(firstName, lastName, email);
		
		// Add the student to StudentDbUtil
		studentDbUtil.addStudent(student);
		
		// Send back to main page (The student list)
		listStudents(request, response);
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Read student id from Form data
		String studentId = request.getParameter("studentId");
		
		// Get the student from StudentDbUtil
		Student student = studentDbUtil.getStudent(studentId);
		
		// Place student in the request
		request.setAttribute("THE_STUDENT", student);
		
		// Send to JSP page (View)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Read student info from Form data
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		// Create new Student Object
		Student student = new Student(id, firstName, lastName, email);
		
		// Update student to StudentDbUtil
		studentDbUtil.updateStudent(student);
		
		// Send back to main page (The student list)
		listStudents(request, response);
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Read student id from Form data
		String theStudentId = request.getParameter("studentId");
		
		// Delete student to StudentDbUtil
		studentDbUtil.deleteStudent(theStudentId);
		
		// Send back to main page (The student list)
		listStudents(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
