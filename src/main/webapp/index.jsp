<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head><h1>FREAKYLOTTO</h1>

    <h2>PICK YOUR NUMBERS</h2>
    <form action="/generate" method="post">

        <input type="number" name="one" min="0" max="53" step="1">
        <input type="number" name="two" min="0" max="53" step="1">
        <input type="number" name="three" min="0" max="53" step="1">
        <input type="number" name="four" min="0" max="53" step="1">
        <input type="number" name="five" min="0" max="53" step="1">
        <input type="number" name="six" min="0" max="53" step="1">
        <input type="submit" value="PLAY" >
    </form>
    <h2>OR PICK THEM <a href="/generate">QUICK</a></h2></head>
<head>


    <c:forEach items="${tList}" var="aTicket">
        <li><c:out escapeXml="false" value="${aTicket}"/></li>
    </c:forEach>

</head>
</html>
