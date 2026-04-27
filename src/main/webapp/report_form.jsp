<!DOCTYPE html>
<html>
<head>
<title>Reports</title>

<style>
body {
    font-family: Arial, sans-serif;
    background: #eef;
}

.container {
    width: 350px;
    margin: 50px auto;
    padding: 20px;
    background: white;
    border-radius: 8px;
    box-shadow: 0px 0px 10px rgba(0,0,0,0.2);
}

h2 {
    text-align: center;
    color: #333;
}

label {
    font-weight: bold;
}

input, select {
    width: 100%;
    padding: 8px;
    margin: 5px 0 15px 0;
    box-sizing: border-box;
}

button {
    width: 100%;
    padding: 10px;
    background: #17a2b8;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background: #117a8b;
}
</style>

</head>
<body>

<div class="container">

<h2>Generate Report</h2>

<form action="reportCriteria" method="post">

<label>Select Report Type:</label>
<select name="type" required>
    <option value="">-- Select --</option>
    <option value="room">Students by Room</option>
    <option value="date">Students by Date Range</option>
</select>

<label>Room Number:</label>
<input type="text" name="room" placeholder="Enter room number">

<label>From Date:</label>
<input type="date" name="from">

<label>To Date:</label>
<input type="date" name="to">

<button type="submit">Generate Report</button>

</form>

</div>

</body>
</html>