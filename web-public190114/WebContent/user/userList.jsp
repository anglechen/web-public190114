<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	table,tr,td{
		border: 1px solid;
		text-align:center;
		font-size: 20px;
	}
	table{
		margin-top:20px;
	}
	thead tr td{
		font-size: 35px;
	}
</style>

</head>
<body>
	<div >
		<button id="add-btn">新增</button>
		<button id="mod-btn">修改</button>
		<button id="del-btn">删除</button>
	</div>
	<div id="add-div" style="display:none;">
		<jsp:include page="userAdd.jsp"></jsp:include>
	</div>
	<div id="query-div" >
		<jsp:include page="query.jsp"></jsp:include>
	</div>
	<div id="list-div">
		<table id = "userTable">
			<thead>
				<tr>
					<td><input type="checkbox"></td>
					<td>id</td>
					<td>账号</td>
					<td>密码</td>
					<td>姓名</td>
					<td>年龄</td>
					<td>出生日期</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<%-- <c:forEach var="u" items="${results}">
					<tr>
						<td><input type="checkbox"></td>
						<td>${u.id}</td>
						<td>${u.account}</td>
						<td>${u.password}</td>	
						<td>${u.name}</td>		
						<td>${u.age}</td>	
						<td>${u.birthday}</td>
						<td>${u.status}</td>						
					</tr>
				</c:forEach> --%>
			</tbody>
		</table>
	</div>
	
<script type="text/javascript" src="<%=basePaht%>/static/jquery-1.10.2.min.js"></script>	
<script type="text/javascript" src="<%=basePaht%>/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$("#add-btn").click(function(){
		$("#add-div").show();
	})
	//删除
	$("#userTable").on("click",".del",function(){
		debugger;
		$.ajax({
			url:"<%=basePaht%>/user/del",
			type:"post",
			data:{
				"id":$(this).val()
			},
			success:function(data){
				debugger;
				if(data.result == "success"){
					alert("删除成功");
					query();
				}
			}
		})
	})
	
	//查询
	$("#query-form #query-btn").click(function(){
		query();
	})
	
	//进入页面自动查询数据
	$(function(){
		query();
	})
	
	function query(){
		var account = $("#query-form [name='account']").val();
		var password = $("#query-form [name='password']").val();
		var name = $("#query-form [name='name']").val();
		var birthday = $("#query-form [name='birthday']").val();
		var age = $("#query-form [name='age']").val();
		var status = $("#query-form [name='status']").val();
		$.ajax({
			url:"<%=basePaht%>/user/list",
			data:{
				"account":account,
				"password":password,
				"name":name,
				"birthday":birthday,
				"age":age,
				"status":status
			},
			success:function(data){
				var results = data.result;
				var html = "";
				debugger;
				for(var i = 0; i<results.length;i++){
					html += "<tr>";
					html+="<td><input type='checkbox'></td>"
					html += "<td>" + results[i].id + "</td>";
					html += "<td>" + results[i].account + "</td>";
					html += "<td>" + results[i].password + "</td>";
					html += "<td>" + results[i].name + "</td>";
					html += "<td>" + results[i].age + "</td>";
					html += "<td>" + results[i].birthday + "</td>";
					var status = "";
					if(results[i].status  == 0){
						status ="无效";
					}else{
						status = "有效";
					}
					html += "<td>" + status + "</td>";
					html += "<td><button class='del' value="+ results[i].id +" >删除</button></td>";
					html += "</tr>"
				}
				$("#userTable tbody").html("");
				$("#userTable tbody").append(html);
				
			}
		})
		$("#add-div").hide();
	}
	
	//新增数据
	$("#add-form #save-btn").click(function(){
		var account = $("#add-form [name='account']").val();
		var password = $("#add-form [name='password']").val();
		var name = $("#add-form [name='name']").val();
		var birthday = $("#add-form [name='birthday']").val();
		var age = $("#add-form [name='age']").val();
		var status = $("#add-form [name='status']").val();
		$.ajax({
			url:"<%=basePaht%>/user/add",
			type:"post",
			data:{
				"account":account,
				"password":password,
				"name":name,
				"birthday":birthday,
				"age":age,
				"status":status
			},
			success:function(data){
				if(data.result == "success"){
					alert("新增成功");
					$("#add-div").hide();
				}else{
					alert("新增失败");
				}
				
			}
		})
	})

</script>


















</body>
</html>