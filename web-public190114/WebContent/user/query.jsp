<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div id = "query-form" style="margin-top:20px;">

			账号：<input name = "account" />
			密码：<input name = "password" type="password"/>

			姓名：<input name = "name" />
			
			<!--  
			年龄：<input name = "age" />
			日期：<input name = "birthday" onClick="WdatePicker()">
			状态：<select name="status">
					<option value="1">有效</option>
					<option value="0">无效</option>
				</select>
			-->	
			<button id="query-btn" type="button">查询</button>
			<button type="reset">重置</button>

</div>		
</body>
</html>