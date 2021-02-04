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
	<h1>아파트 실거래가 </h1>



	<table border="1">
		<thead>
			<tr>

				<th>아파트 명</th>
				<th>전용면적</th>
				<th>실거래가</th>
				<th>층수</th>
				<th>실거래일</th>

				<th>지역</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>

					<td>${item.apartmentname}</td>
					<td>${item.areause}</td>
					<td>${item.amount}만원</td>
					<td>${item.floor}</td>
					<td>${item.dealyear}년${item.dealmonth}월${item.dealday}일</td>



					<td>${item.sigungu}${item.dong}${item.jibun}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>

