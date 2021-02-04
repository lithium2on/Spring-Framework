<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>Home</title>
</head>

<body>
	<h1>Project List</h1>

	<div>
		[<a href="<c:url value='/projectRegisterForm.do' />">등록</a>]
	</div>

	<table border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>passwd</th>
				<th>email</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.id}</td>
					<td>${item.passwd}</td>
					<td>${item.email}</td>
					<td><a href="${path}/projectUpdateForm.do?id=${item.id}">수정</a></td>
					<td><a href="${path}/projectDelete.do?id=${item.id}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>