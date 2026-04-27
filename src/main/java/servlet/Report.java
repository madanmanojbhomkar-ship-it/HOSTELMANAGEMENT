package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.HostelDAO;
import model.Student;

@WebServlet("/report")
public class Report extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> list = null;

        try {
            String type = request.getParameter("type");
            HostelDAO dao = new HostelDAO();

            if ("pending".equals(type)) {
                list = dao.getPendingFees();

            } else if ("room".equals(type)) {
                String room = request.getParameter("room");
                if (room == null || room.trim().isEmpty()) {
                    throw new Exception("Room cannot be empty");
                }
                list = dao.getStudentsByRoom(room.trim());

            } else if ("date".equals(type)) {
                String from = request.getParameter("fromDate");
                String to = request.getParameter("toDate");

                if (from == null || to == null || from.isEmpty() || to.isEmpty()) {
                    throw new Exception("Dates required");
                }

                list = dao.getStudentsByDate(from, to);
            }

            request.setAttribute("students", list);

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }

        request.getRequestDispatcher("report_result.jsp").forward(request, response);
    }
}