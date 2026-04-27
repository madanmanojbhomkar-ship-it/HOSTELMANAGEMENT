package servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.HostelDAO;

@WebServlet("/reportCriteria")
public class ReportCriteriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            HostelDAO dao = new HostelDAO();

            String type = req.getParameter("type");

            if (type.equals("room")) {
                // Room-based report
                String room = req.getParameter("room");

                req.setAttribute("students",
                        dao.getStudentsByRoom(room));

            } else if (type.equals("date")) {
                // Date range report
                String from = req.getParameter("from");
                String to = req.getParameter("to");

                req.setAttribute("students",
                        dao.getStudentsByDate(from, to));
            }

            // Forward to result page
            RequestDispatcher rd = req.getRequestDispatcher("report_result.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println("Error generating report: " + e.getMessage());
        }
    }
}