<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	접속완료! 
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href='projectList.do'>이동</a>
<a href='richList.do'>richlist 이동</a>

</body>
</html>
