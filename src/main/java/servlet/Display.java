package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.HostelDAO;
import model.Student;

@WebServlet("/display")
public class Display extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 🔹 1. Create DAO object
            HostelDAO dao = new HostelDAO();

            // 🔹 2. Fetch all students from database
            List<Student> list = dao.getAllStudents();

            // 🔹 3. Debug (VERY IMPORTANT)
            System.out.println("TOTAL RECORDS FETCHED: " + list.size());

            // 🔹 4. Send data to JSP (MATCH THIS NAME WITH JSP)
            request.setAttribute("students", list);

            // 🔹 5. Forward to display page
            request.getRequestDispatcher("studentdisplay.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

            response.setContentType("text/html");
            response.getWriter().println(
                "<h3 style='color:red'>Error loading students: " + e.getMessage() + "</h3>"
            );
        }
    }
}