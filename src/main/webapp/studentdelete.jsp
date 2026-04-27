<!DOCTYPE html>
<html>
<head>
<title>Delete Student</title>

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
    background: #dc3545;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background: #a71d2a;
}
</style>

</head>
<body>

<div class="container">

<h2>Delete Student</h2>

<form action="deleteStudent" method="post">

<label>Student ID:</label>
<input type="number" name="id" required>

<button type="submit">Delete</button>

</form>

</div>

</body>
</html>