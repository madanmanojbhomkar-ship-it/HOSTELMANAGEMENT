<!DOCTYPE html>
<html>
<head>
<title>Add Student</title>

<style>
body {
    font-family: Arial, sans-serif;
    background: #eef;
}

.container {
    width: 320px;
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

input {
    width: 100%;
    padding: 8px;
    margin: 5px 0 15px 0;
    box-sizing: border-box;
}

button {
    width: 100%;
    padding: 10px;
    background: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background: #0056b3;
}
</style>

</head>
<body>

<div class="container">

<h2>Add Student</h2>

<form action="add" method="post">

<!-- ✅ ADDED STUDENT ID -->
<label>Student ID:</label>
<input type="number" name="id" required>

<label>Name:</label>
<input type="text" name="name" required>

<label>Room:</label>
<input type="text" name="room" required>

<label>Date:</label>
<input type="date" name="date" required>

<label>Fees Paid:</label>
<input type="number" name="fees" required>

<label>Pending Fees:</label>
<input type="number" name="pending" required>

<button type="submit">Add Student</button>

</form>

</div>

</body>
</html>