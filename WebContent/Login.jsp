<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%--以上三个标签必须放在html文档的最前面 --%>
		<title>管理员登录</title>
		
		<%--导入bootstrap样式表 --%>
		 <link href="css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<h1 align="center" style="margin-bottom: 50px;">管理员登录</h1>
		<form class="form-horizontal" action="http://localhost:8080/ShowUserInfo/Login">
			  <div class="form-group">
				    <label for="username" class="col-sm-offset-2 col-sm-2 control-label">用户名：</label>
				    <div class="col-sm-4">
				      	<input type="text" class="form-control" id="username" name="name" placeholder="请输入姓名">
				    </div>
			  </div>
			  <div class="form-group">
				    <label for="pwd" class="col-sm-offset-2 col-sm-2 control-label">密码：</label>
				    <div class="col-sm-4">
				      	<input type="password" class="form-control" id="pwd" name="pwd" placeholder="请输入密码">
				    </div>
			  </div>
			  <div class="form-group">
				    <label for="iden" class="col-sm-offset-2 col-sm-2 control-label">验证码：</label>
				    <div class="col-sm-4">
				    	<input type="text" class="form-control" id="iden"  name="iden" placeholder="请输入验证码">
				    	<img id="img"  class="col-sm-5" alt="验证码" src="http://localhost:8080/ShowUserInfo/IdentifyCode">
				    </div>
			  </div>
			  <div class="row">
			 	 
			  </div>
			  <div class="form-group">
				    <div class="col-sm-offset-4 col-sm-8">
				      	<button type="submit" class="btn btn-info">登录</button>
				    </div>
			  </div>
		</form>
		<%--显示警告信息 --%>
		<div class="container">
			<div class="row">
				<c:if test="${not empty requestScope.error }">
					<div class="alert alert-warning alert-dismissible" role="alert">
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						  <strong style="text-align: center;">${requestScope.error }</strong> 
					</div>
				</c:if>
			</div>
		</div>
		 <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	    <script src="js/jQuery.js"></script>
	    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	    <script src="js/bootstrap.min.js"></script>
		<script type="text/javascript">
			var img = document.getElementById("img");
			img.onclick = function() {
				var date = new Date().getTime();
				img.src = "http://localhost:8080/ShowUserInfo/IdentifyCode?" + date;
			}
		</script>
	</body>
</html>