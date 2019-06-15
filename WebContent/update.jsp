<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%--以上三个标签必须放在html文档的最前面 --%>
        
        <title>用户添加</title>
		
		<%--导入bootstrap样式表 --%>
		 <link href="css/bootstrap.min.css" rel="stylesheet">
		 <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	    <script src="js/jQuery.js"></script>
	    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	    <script src="js/bootstrap.min.js"></script>
	</head>
	<body>
		<h1 align="center">修改用户</h1>
		
		<div class="container">
			<form class="form-horizontal" method="get" action="http://localhost:8080/ShowUserInfo/UpdateServlet">
			 	<%--id属性隐藏显示，为了提交的时候能使用id --%>
			 	<input name="id" type="hidden" value="${user.id }">
			  <div class="form-group">
				    <label for="name" class="col-sm-2 control-label">姓名</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="name" name="name" value="${user.name }">
				    </div>
			  </div>
			  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
					      <div class="checkbox">
						        <label>
						          <input type="radio" name="gender" value="男" <c:if test="${user.gender == '男'}">checked="checked"</c:if>>男						        
						        </label>
						     	<label>
						          <input type="radio" name="gender" value="女" <c:if test="${user.gender  == '女'}">checked="checked"</c:if>> 女          
						        </label>
					      </div>
				    </div>
			  </div>
			  <div class="form-group">
				    <label for="age" class="col-sm-2 control-label">年龄</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="age" name="age" value="${user.age }">
				    </div>
			  </div>
			  <div class="form-group">
				    <label for="address" class="col-sm-2 control-label">地址</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="address" name="address" value="${user.address }">
				    </div>
			  </div>
			  <div class="form-group">
				    <label for="qq" class="col-sm-2 control-label">qq</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="qq" name="qq" value="${user.qq }">
				    </div>
			  </div>
			  <div class="form-group">
				    <label for="email" class="col-sm-2 control-label">邮箱</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="email" name="email" value="${user.email }">
				    </div>
			  </div>
			  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      	<button type="submit" class="btn btn-info">确定</button>
				      	<button id="cancel" type="button" class="btn btn-default">取消</button>
				    </div>
			  </div>
			</form>		
		</div>
		
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

		<script type="text/javascript">
			var cancel = document.getElementById("cancel");
			
			<%--取消，返回到上一页面--%>
			cancel.onclick = function () {
				history.back();
			}
		</script>
	</body>
</html>











