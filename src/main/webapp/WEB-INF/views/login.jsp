<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>"/>
    </head>
    <body>
        <h2>Please sign in!</h2>
        <c:url value="/j_spring_security_check" var="loginUrl" />
        <form action="${loginUrl}" method="post">
            <table>
                <tr>
                    <td><label>login</label></td>
                    <td><input type="text" name="j_username"/></td>
                </tr>
                <tr>
                    <td><label>password</label></td>
                    <td><input type="password" name="j_password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
