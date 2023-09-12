<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Note</title>
    <style>
        /* Add CSS styles for a nice UI */
        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .input-field {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Add Note</h1>
    <form action="addNote" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" class="input-field">

        <label for="content">Content:</label>
        <textarea id="content" name="content" class="input-field" rows="4"></textarea>

        <button type="submit" class="button">Add Note</button>
    </form>
</div>
</body>
</html>