package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.HostelDAO;

@WebServlet("/deleteStudent")
public class delete  extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // ✅ Handles form (POST)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        processRequest(req, res);
    }

    // ✅ Handles link (GET)  🔥 FIX FOR YOUR ERROR
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        processRequest(req, res);
    }

    // 🔥 COMMON METHOD
    private void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        try {
            String idStr = req.getParameter("id");

            if (idStr == null || idStr.isEmpty()) {
                res.getWriter().println("<h3 style='color:red'>ID missing</h3>");
                return;
            }

            int id = Integer.parseInt(idStr);

            HostelDAO dao = new HostelDAO();
            dao.deleteStudent(id);

            System.out.println("Deleted ID: " + id);

            res.sendRedirect("display");

        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println("<h3 style='color:red'>Error: " + e.getMessage() + "</h3>");
        }
    }
}