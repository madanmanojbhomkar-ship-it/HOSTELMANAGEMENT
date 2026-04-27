package dao;

import java.sql.*;
import java.util.*;
import model.Student;

public class HostelDAO {

    // 🔹 DB CONNECTION
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hostel_db", "root", "Saibaba@123");
    }

    // 🔹 ADD STUDENT
    public void addStudent(Student s) throws Exception {
        Connection con = getConnection();

        String sql = "INSERT INTO HostelStudents (StudentID, StudentName, RoomNumber, AdmissionDate, FeesPaid, PendingFees) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, s.getStudentID());
        ps.setString(2, s.getStudentName());
        ps.setString(3, s.getRoomNumber());
        ps.setDate(4, s.getAdmissionDate());
        ps.setDouble(5, s.getFeesPaid());
        ps.setDouble(6, s.getPendingFees());

        ps.executeUpdate();
        con.close();
    }

    // 🔹 UPDATE STUDENT
    public void updateStudent(Student s) throws Exception {
        Connection con = getConnection();

        String sql = "UPDATE HostelStudents SET StudentName=?, RoomNumber=?, AdmissionDate=?, FeesPaid=?, PendingFees=? WHERE StudentID=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, s.getStudentName());
        ps.setString(2, s.getRoomNumber());
        ps.setDate(3, s.getAdmissionDate());
        ps.setDouble(4, s.getFeesPaid());
        ps.setDouble(5, s.getPendingFees());
        ps.setInt(6, s.getStudentID());

        ps.executeUpdate();
        con.close();
    }

    // 🔹 DELETE STUDENT
    public void deleteStudent(int id) throws Exception {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM HostelStudents WHERE StudentID=?"
        );

        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }

    // 🔹 GET ALL STUDENTS
    public List<Student> getAllStudents() throws Exception {
        return getByQuery("SELECT * FROM HostelStudents");
    }

    // 🔹 REPORT: PENDING FEES
    public List<Student> getPendingFees() throws Exception {
        return getByQuery("SELECT * FROM HostelStudents WHERE PendingFees > 0");
    }

    // 🔥 FIXED: REPORT BY ROOM (IMPORTANT FIX)
    public List<Student> getStudentsByRoom(String room) throws Exception {

        List<Student> list = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM HostelStudents WHERE TRIM(RoomNumber) = TRIM(?)"
        );

        ps.setString(1, room);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Student s = new Student();

            s.setStudentID(rs.getInt("StudentID"));
            s.setStudentName(rs.getString("StudentName"));
            s.setRoomNumber(rs.getString("RoomNumber"));
            s.setAdmissionDate(rs.getDate("AdmissionDate"));
            s.setFeesPaid(rs.getDouble("FeesPaid"));
            s.setPendingFees(rs.getDouble("PendingFees"));

            list.add(s);
        }

        con.close();
        return list;
    }

    // 🔹 REPORT: DATE RANGE
    public List<Student> getStudentsByDate(String from, String to) throws Exception {

        List<Student> list = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM HostelStudents WHERE AdmissionDate BETWEEN ? AND ?"
        );

        ps.setDate(1, java.sql.Date.valueOf(from));
        ps.setDate(2, java.sql.Date.valueOf(to));

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Student s = new Student();

            s.setStudentID(rs.getInt("StudentID"));
            s.setStudentName(rs.getString("StudentName"));
            s.setRoomNumber(rs.getString("RoomNumber"));
            s.setAdmissionDate(rs.getDate("AdmissionDate"));
            s.setFeesPaid(rs.getDouble("FeesPaid"));
            s.setPendingFees(rs.getDouble("PendingFees"));

            list.add(s);
        }

        con.close();
        return list;
    }

    // 🔹 COMMON METHOD
    private List<Student> getByQuery(String sql) throws Exception {

        List<Student> list = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Student s = new Student();

            s.setStudentID(rs.getInt("StudentID"));
            s.setStudentName(rs.getString("StudentName"));
            s.setRoomNumber(rs.getString("RoomNumber"));
            s.setAdmissionDate(rs.getDate("AdmissionDate"));
            s.setFeesPaid(rs.getDouble("FeesPaid"));
            s.setPendingFees(rs.getDouble("PendingFees"));

            list.add(s);
        }

        con.close();
        return list;
    }
}