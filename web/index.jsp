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
    <div id="reactions1"></div>
    <form method="post">
        <input type="text" id="nameInput1" name="name" value="dieter1">
        <input type="text" id="opinionInput1" name="opinion" value="saai">
        <input type="number" min="1" max="10" id="ratingInput1" name="rating" value="2">
        <input type="button" id="postComment1" onclick="send(1)" value="Reageer">
    </form>

    <p>Wat ben je van plan om te doen vandaag?</p>
    <div id="reactions2"></div>
    <form method="post">
        <input type="text" id="nameInput2" name="name" value="dieter2">
        <input type="text" id="opinionInput2" name="opinion" value="saai">
        <input type="number" min="1" max="10" id="ratingInput2" name="rating" value="2">
        <input type="button" id="postComment2" onclick="send(2)" value="Reageer">
    </form>


    <p>Naar welke muziek ben je momenteel aan het luisteren?</p>
    <div id="reactions3"></div>
    <form method="post">
        <input type="text" id="nameInput3" name="name" value="dieter3">
        <input type="text" id="opinionInput3" name="opinion" value="saai">
        <input type="number" min="1" max="10" id="ratingInput3" name="rating" value="2">
        <input type="button" id="postComment3" onclick="send(3)" value="Reageer">
    </form>

    <p>Wat zijn de examenvragen voor het vak Web4?</p>
    <div id="reactions4"></div>
    <form method="post">
        <input type="text" id="nameInput4" name="name" value="dieter4">
        <input type="text" id="opinionInput4" name="opinion" value="saai">
        <input type="number" min="1" max="10" id="ratingInput4" name="rating" value="2">
        <input type="button" id="postComment4" onclick="send(4)" value="Reageer">
    </form>

</main>
<script type="text/javascript" src="js/pushScript.js"></script>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
</body>
</html>