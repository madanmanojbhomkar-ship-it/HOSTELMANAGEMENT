<!DOCTYPE html>
<html>
<head>
<title>Reports</title>
<!-- paste CSS here -->
</head>
<body>

<div class="container">

<h2>Reports</h2>

<!-- 🔹 Pending Fees -->
<form action="report" method="post">
    <input type="hidden" name="type" value="pending">
    <button>Pending Fees Report</button>
</form>

<!-- 🔹 Room -->
<form action="report" method="post">
    <input type="hidden" name="type" value="room">
    <label>Enter Room:</label>
    <input type="text" name="room" required>
    <button>Room Report</button>
</form>

<!-- 🔹 Date -->
<form action="report" method="post">
    <input type="hidden" name="type" value="date">
    <label>From:</label>
    <input type="date" name="fromDate" required>
    <label>To:</label>
    <input type="date" name="toDate" required>
    <button>Date Report</button>
</form>

</div>

</body>
</html>