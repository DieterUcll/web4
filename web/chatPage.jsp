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
    <jsp:param name="title" value="Chat page"/>
</jsp:include>

<main>
    <div>Status:<span id="currentStatus"></span></div>

    <form method="post">

        <label>Change status<br>
            <input list="status" name="status" id="statusInput"></label>
        <datalist id="status">
            <option value="online">
            <option value="offline">
            <option value="away">
        </datalist>
        <p>
            <input type="button" id="changeStatusButton" onclick="changeStatus()" value="Change Status">
        </p>
    </form>

    <table id="friendsTable">
        <tr>
            <th>Name</th>
            <th>Status</th>
        </tr>
    </table>

    <form method="post">

        <label>Add a Friend<br>
            <input name="friend" id="friendId"></label>
        <p>
            <input type="button" id="addFriendBtn" onclick="addFriends()" value="add friend">
        </p>
    </form>
</main>
<aside>
    <h3>Chat section</h3>
    <h4>Chatting with: <span id="receiverName"></span></h4>
    <div id="chatMessages"></div>
    <p>
        <input type="text" id="message">
    </p>
    <p>
        <input type="button" id="sendMessage" value="Send">
    </p>

</aside>
<script src="js/jquery.js"></script>
<script type="text/javascript" src="js/pollingScript.js"></script>
<script type="text/javascript" src="js/deelopdracht3.js"></script>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
</body>
</html>