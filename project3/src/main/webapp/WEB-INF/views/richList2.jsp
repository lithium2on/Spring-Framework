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
				<th>NUM</th>
				<th>AMOUNT</th>
				<th>OWNERSHIP</th>
				<th>DEALYEAR</th>
				<th>DEALMONTH</th>
				<th>DEALDAY</th>
				<th>APARTMENTNAME</th>
				<th>DONG</th>
				<th>SIGUNGU</th>
				<th>AREAUSE</th>
				<th>JIBUN</th>
				<th>REGIONALCODE</th>
				<th>FLOOR</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.num}</td>
					<td>${item.amount}</td>
					<td>${item.ownership}</td>
					<td>${item.dealyear}</td>
					<td>${item.dealmonth}</td>
					<td>${item.dealday}</td>
					<td>${item.apartmentname}</td>
					<td>${item.dong}</td>
					<td>${item.sigungu}</td>
					<td>${item.areause}</td>
					<td>${item.jibun}</td>
					<td>${item.regionalcode}</td>
					<td>${item.floor}</td>
					<td><a href="${path}/projectUpdateForm.do?id=${item.num}">수정</a></td>
					<td><a href="${path}/projectDelete.do?id=${item.num}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>