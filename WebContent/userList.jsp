<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%--以上三个标签必须放在html文档的最前面 --%>
		<title>所有用户信息</title>
		<%--导入bootstrap样式表 --%>
		 <link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	    <script src="js/jQuery.js"></script>
	    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	    <script src="js/bootstrap.min.js"></script>
		 <style type="text/css">
		 	table{
		 		width: 70%;
		 	}
		 </style>
	</head>
	<body>
		<h1 align="center">所有用户信息</h1>
		<br>
		<br>
		<div class="container">
			<div class="row">
					<div class="pull-left">
						<%--联合查询表单 --%>
						<form class="form-inline" method="get" action="http://localhost:8080/ShowUserInfo/PageServlet?rows=5&currentPage=1">
							  <div class="form-group">
								    <label for="name">姓名</label>
								    <input type="text" class="form-control" id="name" name="name" value="${map.name[0] }" placeholder="请输入姓名">
							  </div>
							  <div class="form-group">
								    <label for="age">年龄</label>
								    <input type="text" class="form-control" id="age" name="age" value="${map.age[0] }" placeholder="请输入籍贯">
							  </div>
							  <div class="form-group">
								    <label for="address">地址</label>
								    <input type="text" class="form-control" id="address" name="address" value="${map.address[0] }" placeholder="请输入地址">
							  </div>
							  <button type="submit" class="btn btn-default">查询</button>
						</form>
					</div>
					<div class="pull-right">
						<a  class="btn btn-info" href="http://localhost:8080/ShowUserInfo/add.jsp" role="button">添加用户</a>
						<a  id="delSelected" class="btn btn-info" href="javascript:;" role="button">删除选中</a>
					</div>
			</div>
			<br>
			
			<%--用表单包裹table，是为了方便提交表格中的多选框，方便后台获取选中的id --%>
			<form id="delform" method="get" action="http://localhost:8080/ShowUserInfo/DeleteSelected">
				<div class="row">
					<table class="table table-hover table-bordered">
						<tr class="bg-success">
							<td><input id="allChecked" type="checkbox"></td>
							<td>编号</td>
							<td>姓名</td>
							<td>性别</td>
							<td>年龄</td>
							<td>地址</td>
							<td>qq</td>
							<td>邮箱</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${pageBean.list }" var="temp">
							<tr>
								<td><input name="uid" value="${temp.id }" type="checkbox"></td>
								<td>${temp.id }</td>
								<td>${temp.name }</td>
								<td>${temp.gender }</td>
								<td>${temp.age }</td>
								<td>${temp.address }</td>
								<td>${temp.qq }</td>
								<td>${temp.email }</td>
								<td style="margin: 10px;">
									<a class="btn btn-default" href="http://localhost:8080/ShowUserInfo/QueryServlet?id=${temp.id }">修改</a>
									<a class="btn btn-default" href="javascript:deleteOne(${temp.id},'${temp.name }');">删除</a>
								</td>			
							</tr>	
						</c:forEach>
					</table>
				</div>
			</form>
			
			<%--分页符 --%>
			<div class="row">
				<nav aria-label="Page navigation">
				  <ul class="pagination">

					    	  <c:if test="${pageBean.currentPage >1}">
								<li>
							      <a href="http://localhost:8080/ShowUserInfo/PageServlet?rows=5&currentPage=${pageBean.currentPage - 1}&name=${map.name[0]}&age=${map.age[0]}&address=${map.address[0]}" aria-label="Previous">
							       	   <span aria-hidden="true">&laquo;</span>
							      </a>
						      	</li>
						      </c:if>
				      
						      <c:if test="${pageBean.currentPage <= 1}">
						      	<li class="disabled" >
						      		<a href="javascript:;" aria-label="Previous">
						       	   		<span aria-hidden="true">&laquo;</span>
						      		</a>
						      	</li>
						      </c:if>

					    <c:forEach begin="1" end="${pageBean.totalPage }" var="page">
					    	  <c:if test="${pageBean.currentPage == page }">
					    	  		<li class="active" ><a href="http://localhost:8080/ShowUserInfo/PageServlet?rows=5&currentPage=${page }&name=${map.name[0]}&age=${map.age[0]}&address=${map.address[0]}">${page }</a></li>
					    	  </c:if>
					    	  <c:if test="${pageBean.currentPage != page }">
					    	  		<li ><a  href="http://localhost:8080/ShowUserInfo/PageServlet?rows=5&currentPage=${page }&name=${map.name[0]}&age=${map.age[0]}&address=${map.address[0]}">${page }</a></li>
					    	  </c:if>
					    </c:forEach>
					    
						
						<c:if test="${pageBean.currentPage < pageBean.totalPage}">
							<li>
							      <a href="http://localhost:8080/ShowUserInfo/PageServlet?rows=5&currentPage=${pageBean.currentPage + 1}&name=${map.name[0]}&age=${map.age[0]}&address=${map.address[0]}" aria-label="Next">
							       	   <span aria-hidden="true">&raquo;</span>
							      </a>
							</li>
					  </c:if>
				      <c:if test="${pageBean.currentPage >= pageBean.totalPage}">
				      	<li class="disabled" >
				      		<a href="javascript:;" aria-label="Next">
				       	   		<span aria-hidden="true">&raquo;</span>
				      		</a>
				      	</li>
				 	</c:if>
				  	<span style="font-size: 30px; margin-bottom: 20px;margin-left: 10px;">${pageBean.totalRecord }条记录，共${pageBean.totalPage }页</span>
				  </ul>
				</nav>
			</div>	
			
			<%--错误信息提示框 --%>
			<div class="row">
				<c:if test="${not empty requestScope.error }">
					<div class="alert alert-warning alert-dismissible" role="alert">
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						  <strong style="text-align: center;">${requestScope.error }</strong> 
					</div>
				</c:if>
			</div>		
		</div>
		
		<script type="text/javascript">
			function deleteOne(id, name) {
				<%--二次确认删除才跳转，否则什么都不做--%>
				if(confirm("确定删除编号：" + id + ", 姓名：" + name + " 的用户信息吗？")){
					location.href = "http://localhost:8080/ShowUserInfo/DeleteServlet?id=" + id;
				}
			}
			
			<%--表单提交--%>
			var delSelected = document.getElementById("delSelected");
			var delform = document.getElementById("delform");
			delSelected.onclick = function () {
				if(confirm("确定删除选中的记录吗？")){
					<%--单击 删除选中 就提交表单--%>
					delform.submit();
					
				}
			}
			
			<%--全选--%>
			var allChecked = document.getElementById("allChecked");
			allChecked.onclick = function () {
				var uids = document.getElementsByName("uid");
				for(var i = 0; i < uids.length; i ++){
					uids[i].checked = allChecked.checked;					
				}
			}
		</script>
	</body>
</html>





