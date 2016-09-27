<%--
  Created by IntelliJ IDEA.
  User: olinnyk
  Date: 9/27/16
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Testing websockets</title>

    <spring:url value="/resources/js/jquery/jquery-3.1.1.min.js" var="jqueryJs" />
    <spring:url value="/resources/js/websocket.js" var="websocketJs" />

    <script src="${jqueryJs}"></script>
    <script src="${websocketJs}"></script>

</head>
<body>
<div>

    <input type="submit" value="1. Open connection" onclick="openConnection()" />
    <input type="submit" value="2. Start listen messages from server" onclick="startListenMessagesFromServer()" />
    <input type="submit" value="3. Send hello to server" onclick="sendMessage()" />

</div>
<div id="messages"></div>
</body>
</html>
