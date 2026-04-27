<%@ page import="java.util.*,model.Student" %>

<!DOCTYPE html>
<html>
<head>
<title>Report Result</title>
<!-- paste CSS -->
</head>
<body>

<div class="container">

<h2>Report Result</h2>

<%
String error = (String) request.getAttribute("error");
if(error != null){
%>
    <p style="color:red;"><%= error %></p>
<%
} else {
    List<Student> list = (List<Student>) request.getAttribute("students");

    if(list == null || list.isEmpty()){
%>
        <h3 style="text-align:center;">No Data Found</h3>
<%
    } else {
%>

<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Room</th>
<th>Fees</th>
<th>Pending</th>
</tr>

<%
for(Student s : list){
%>
<tr>
<td><%= s.getStudentID() %></td>
<td><%= s.getStudentName() %></td>
<td><%= s.getRoomNumber() %></td>
<td><%= s.getFeesPaid() %></td>
<td><%= s.getPendingFees() %></td>
</tr>
<%
}
%>

</table>

<%
    }
}
%>

</div>

</body>
</html>