<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head><h1>FREAKYLOTTO</h1>

    <a href="/generate">Generate </a>

    <uL>
        <c:forEach items="${tList}" var="aTicket">
            <li> <c:out escapeXml="false" value="${aTicket}"/>  </li>
        </c:forEach>

</body>
</html>
