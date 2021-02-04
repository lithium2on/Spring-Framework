<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> <!-- @@@ 매우 중요 @@@ -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- src/main/webapp/WEB-INF/view/projectRegisterForm.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr"/>
<title>Home</title>
</head>
<body>
	<h1>Project Register</h1>
	<c:url var="updateUrl" value="${path}/projectUpdate.do" />
	<form:form commandName="projectDto" action="${updateUrl}" name="projectDto" method="post">
	<form:input type="hidden" path="id" id="id" size="20" maxlength="20" value="${item.id}"/>
	<table>
	<tbody>
	<tr>
	   <th>제목</th>
	   <td><form:input path="passwd" id="passwd" size="20" maxlength="20" /></td>
	</tr>
	<tr>
	   <th>내용</th>
	   <td><form:textarea path="email" id="email" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="등록" /></td>
	</tr>
	</tbody>
	</table>
	</form:form>
</body>
</html>