<%-- 
    Document   : editnote
    Created on : Feb 2, 2021, 12:42:30 PM
    Author     : 824664
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form action="note" method="POST">
            Title: <input type="text" name="titleName" value="${note.title}"><br>
            Contents: <textarea rows="6" cols="20" name="editContents">${note.contents}</textarea><br>

            <input type="submit" value="Save">
        </form>
    </body>
</html>
