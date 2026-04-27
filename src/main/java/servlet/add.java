package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.HostelDAO;
import model.Student;

@WebServlet("/add")
public class add extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            // 🔹 1. Get form data
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String room = req.getParameter("room");
            String date = req.getParameter("date");
            String fees = req.getParameter("fees");
            String pending = req.getParameter("pending");

            // 🔹 2. Validation
            if (id == null || id.isEmpty() ||
                name == null || name.trim().isEmpty() ||
                room == null || room.trim().isEmpty()) {

                res.getWriter().println("<h3 style='color:red'>All fields are required!</h3>");
                return;
            }

            System.out.println("ADD CALLED → " + id + " " + name);

            // 🔹 3. Create Student object
            Student s = new Student();
            s.setStudentID(Integer.parseInt(id));   // ✅ FIX
            s.setStudentName(name.trim());
            s.setRoomNumber(room.trim());
            s.setAdmissionDate(Date.valueOf(date));
            s.setFeesPaid(Double.parseDouble(fees));
            s.setPendingFees(Double.parseDouble(pending));

            // 🔹 4. Call DAO
            HostelDAO dao = new HostelDAO();
            dao.addStudent(s);

            System.out.println("INSERT SUCCESS ✅");

            // 🔹 5. Redirect
            res.sendRedirect("display");

        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println("<h3 style='color:red'>Error: " + e.getMessage() + "</h3>");
        }
    }
}