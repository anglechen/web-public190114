<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	你好
	<%-- <%=request.getAttribute("name") %> --%>
<%-- 	request: ${requestScope.name}
	session取出来的值是：${sessionScope.name} --%>
	${name}
	<c:if test="${sessionScope.name =='request'}">
		request
	</c:if>
	<br>
	<c:forEach var="l" items="${list}">
		<li>${l}</li>
	</c:forEach>
	
	<%
		DateTimeFormatter df =  DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		String local = LocalDateTime.now().format(df);
/* 		response.setIntHeader("Refresh", 1); */
	%>
	<%=local %>
	<form method="post" action="./upload" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="uploadFile" />
    <br/><br/>
    <input type="submit" value="上传" />
	
	
</body>
</html>