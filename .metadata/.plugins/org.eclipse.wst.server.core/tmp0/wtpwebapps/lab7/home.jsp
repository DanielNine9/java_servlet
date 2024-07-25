
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${not empty sessionScope.user}">
        Welcome, ${sessionScope.user.fullname}
    </c:when>
	<c:otherwise>
        Welcome to my website
    </c:otherwise>
</c:choose>
