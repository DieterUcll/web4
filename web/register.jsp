<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<main>
        <form method="post" action="Controller?action=RegisterUser">
            <p>
                <label for="email">Your email </label>
                <input type="text" id="email" name="email" value="rudy@ucll.be">
            </p>
            <p>
                <label for="firstname">Your First Name </label>
                <input type="text" id="firstname" name="firstname" value="rudy">
            </p>
            <p>
                <label for="lastname">Your Last Name </label>
                <input type="text" id="lastname" name="lastname" value="swennen">
            </p>
            <p>
                <label for="gender">Your Gender </label>
                <input type="text" id="gender" name="gender" value="unknown">
            </p>
            <p>
                <label for="password">Your password</label>
                <input type="password" id="password" name="password" value="t">
            </p>
            <p>
                <label for="repassword">Retype Your password</label>
                <input type="password" id="repassword" name="repassword" value="t">
            </p>
            <p>
                <input type="submit" id="registerbutton" value="Register Here">
            </p>
        </form>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
</body>
</html>