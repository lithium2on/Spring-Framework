<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head></head>
<body>

<c:choose>
    <c:when test="${sessionScope.loginCheck eq true}">
        ${sessionScope.id} 님이 로그인 되었습니다.  
        <button type="submit">로그아웃</button>
    </c:when>
    <c:otherwise>
        <form id="loginForm">
            <input name="id"/>
            <input name="pw"/>
            <button type="submit">로그인</button>
        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
