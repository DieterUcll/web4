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
    <c:if test="${errors.size()>0 }">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors}">
                    <li>${error }</li>
                </c:forEach>
            </ul>
        </div>
    </c:if> <c:choose>
    <c:when test="${user!=null}">
        <p>Welcome ${user.getFirstName()}!</p>
        <form method="post" action="Controller?action=LogOut">
            <p>
                <input type="submit" id="logoutbutton" value="Log Out">
            </p>
        </form>
    </c:when>
    <c:otherwise>
        <form method="post" action="Controller?action=LogIn">
            <p>
                <label for="email">Your email </label>
                <input type="text" id="email" name="email" value="jan@ucll.be">
            </p>
            <p>
                <label for="password">Your password</label>
                <input type="password" id="password" name="password" value="t">
            </p>
            <p>
                <input type="submit" id="loginbutton" value="Log in">
            </p>
        </form>
    </c:otherwise>
</c:choose>

    <p>Was het een interessante projectweek?</p>
    <div id="reactions"></div>
    <form method="post">
        <input type="text" id="nameInput" name="name" value="elke">
        <input type="text" id="opinionInput" name="opinion" value="saai">
        <input type="number" min="1" max="10" id="ratingInput" name="rating" value="2">
        <input type="submit" id="postComment" onclick="send()" value="Reageer">
    </form>





    <p>Wat ben je van plan om te doen vandaag?</p>
    <p>Naar welke muziek ben je momenteel aan het luisteren?</p>
    <p>Wat zijn de examenvragen voor het vak Web4?</p>

</main>
<script type="text/javascript" src="js/pushScript.js"></script>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
</body>
</html>