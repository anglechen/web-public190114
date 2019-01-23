<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<form action="<%=basePaht%>/login" method="post">
		用户名：<input name="account" />
		密码： <input name = "password" type="password"/>
		<button type="submit">登录</button>
	</form>

	
	<!-- 
	<c:if test="${testAttr !=null}">
		条件为true 显示这里的内容
	</c:if>

	<jsp:include page="main.jsp"></jsp:include>
	
	<h1>测试</h1>
	大家好，我是一个jsp测试页面！
	request参数：<%=request.getAttribute("testAttr") %>
	request参数获取$二：${testAttr}
	这里是html注释测试 -->
	<%-- 这里是jsp注释 --%>
	
</body>
</html>