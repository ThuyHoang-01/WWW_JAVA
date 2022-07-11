package iuh.fit.scr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MVCDemoServlet")
public class MVCDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Step 0: Add data
		// Gan du lieu vao request duoi dang attribute
		String[] students = { "Xuan Xuan", "Ha Ha", "Thu Thu", "Dong Dong" };
		request.setAttribute("student_list", students);

		// Step 1: get request dispatcher
		// Goi toi View (file .jsp) ma ta muon truyen du lieu
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view_students.jsp");

		// Step 2: forward the request to JSP
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
