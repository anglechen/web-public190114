<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	#add-form div{
		margin-top: 20px;
		margin-left: 60px;
	}
	form{
    		border: 1px solid;
	}
	h1{
    	text-align: center;
    }
</style>
</head>
<body>
	<%-- action="<%=basePaht%>/user/add" method="post" --%>
	<form id="add-form">
		<div>
			账号：<input name = "account" />
			密码：<input name = "password" type="password"/>
		</div>
		<div>
			姓名：<input name = "name" />
			年龄：<input name = "age" />
		</div>
		<div>
			日期：<input name = "birthday" onClick="WdatePicker()">
			状态：<select name="status">
					<option value="1">有效</option>
					<option value="0">无效</option>
				</select>
		</div>
		<div>
			<button id="save-btn" type="button">提交</button>
			<button type="reset">重置</button>
		</div>
		
		
	</form>
</body>
</html>