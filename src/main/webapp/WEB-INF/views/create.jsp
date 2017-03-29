<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Created</title>
    </head>
    <body>
    <h2>Submitted Employee Information</h2>
    <table>
        <tr>
            <td>ID :</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td>Login :</td>
            <td>${user.login}</td>
        </tr>
        <tr>
            <td>Pass :</td>
            <td>${user.password}</td>
        </tr>
        <tr>
            <td>Role :</td>
            <td>${user.role}</td>
        </tr>
    </table>
    </body>
</html>
