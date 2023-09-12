<%@ page import="org.example.entities.Note" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notes</title>
    <style>
        .note {
            border: 1px solid #ccc;
            padding: 10px;
            margin: 10px;
            background-color: #f9f9f9;
        }
        .button-container {
            text-align: center;
            margin-top: 20px;
        }
        .button {
            margin: 10px;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>Notes</h1>
<% List<Note> notes = (List<Note>) request.getAttribute("notes"); %>
<%
    for (Note note : notes) {
%>
<div class="note">
    <h2><%= note.getTitle() %></h2>
    <p><%= note.getContent() %></p>
    <button class="button" onclick="editNote(<%= note.getId() %>)">Edit</button>
    <button class="button" onclick="deleteNote(<%= note.getId() %>)">Delete</button>
</div>
<%
    }
%>
<div class="button-container">
    <button class="button" onclick="addNote()">Add Note</button>
</div>

<script>
    // JavaScript functions for edit, delete, and add buttons
    function editNote(noteId) {
        window.location.href = "${pageContext.request.contextPath}/notes/edit/" + noteId.toString();
    }

    function deleteNote(noteId) {
        window.location.href = "${pageContext.request.contextPath}/notes/delete/" + noteId.toString();
    }

    function addNote() {
        window.location.href = "${pageContext.request.contextPath}/notes/add";
    }
</script>

</body>
</html>
