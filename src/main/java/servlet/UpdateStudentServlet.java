package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.HostelDAO;
import model.Student;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String room = req.getParameter("room");
            String date = req.getParameter("date");
            double paid = Double.parseDouble(req.getParameter("paid"));
            double pending = Double.parseDouble(req.getParameter("pending"));

            Student s = new Student();
            s.setStudentID(id);
            s.setStudentName(name);
            s.setRoomNumber(room);
            s.setAdmissionDate(Date.valueOf(date));
            s.setFeesPaid(paid);
            s.setPendingFees(pending);

            HostelDAO dao = new HostelDAO();
            dao.updateStudent(s);

            System.out.println("UPDATED ID: " + id);

            // 🔥 FIXED HERE
            res.sendRedirect("display");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}