package iuh.fit.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentMVCServlet")
public class StudentMVCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Step 1: Get the Student data from helper class (Model)
		List<Student> students = StudentDataUtil.getStudents();

		// Step 2: Add student to request object
		request.setAttribute("student_list", students);

		// Step 3: Get request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("view_students_mvc.jsp");

		// Step 4: Forward data to jsp
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
