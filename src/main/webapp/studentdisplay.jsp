<%@ page import="java.util.*,model.Student" %>

<!DOCTYPE html>
<html>
<head>
<title>Student List</title>

<style>
body {
    font-family: Arial;
    background: #eef;
}

.container {
    width: 800px;
    margin: 30px auto;
}

h2 {
    text-align: center;
}

.menu {
    text-align: center;
    margin-bottom: 15px;
}

.menu a {
    margin: 0 10px;
    padding: 8px 15px;
    background: #007bff;
    color: white;
    text-decoration: none;
    border-radius: 5px;
}

.menu a:hover {
    background: #0056b3;
}

table {
    width: 100%;
    border-collapse: collapse;
}

th, td {
    border: 1px solid black;
    padding: 8px;
    text-align: center;
}

a.action {
    color: blue;
    text-decoration: none;
}

a.action:hover {
    text-decoration: underline;
}
</style>

</head>
<body>

<div class="container">

<h2>Student List</h2>

<!-- ✅ MENU -->
<div class="menu">
    <a href="index.jsp"> Home</a>
    <a href="studentadd.jsp">Add Student</a>
</div>

<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Room</th>
<th>Fees Paid</th>
<th>Pending Fees</th>
<th>Action</th>
</tr>

<%
List<Student> list = (List<Student>) request.getAttribute("students");

if(list != null && !list.isEmpty()){
    for(Student s : list){
%>

<tr>
<td><%= s.getStudentID() %></td>
<td><%= s.getStudentName() %></td>
<td><%= s.getRoomNumber() %></td>
<td><%= s.getFeesPaid() %></td>
<td><%= s.getPendingFees() %></td>

<td>
    <a class="action" href="deleteStudent?id=<%= s.getStudentID() %>">Delete</a> |

    <a class="action" href="studentupdate.jsp?id=<%= s.getStudentID() %>
    &name=<%= s.getStudentName() %>
    &room=<%= s.getRoomNumber() %>
    &date=<%= s.getAdmissionDate() %>
    &paid=<%= s.getFeesPaid() %>
    &pending=<%= s.getPendingFees() %>">
    Update</a>
</td>

</tr>

<%
    }
} else {
%>

<tr>
<td colspan="6">No Data Found</td>
</tr>

<%
}
%>

</table>

</div>

</body>
</html>