<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	</head>
	<body>
		<h1 align="center">添加用户</h1>
		<div class="container">
			<form class="form-horizontal" method="get" action="http://localhost:8080/ShowUserInfo/InsertServlet">
			  <div class="form-group">
				    <label for="name" class="col-sm-2 control-label">姓名</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
				    </div>
			  </div>
			  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
					      <div class="checkbox">
						        <label>
						          <input type="checkbox" name="gender" value="男"> 男
						        </label>
						     	<label>
						          <input type="checkbox" name="gender" value="女"> 女
						        </label>
					      </div>
				    </div>
			  </div>
			  <div class="form-group">
				    <label for="age" class="col-sm-2 control-label">年龄</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
				    </div>
			  </div>
			  <div class="form-group">
				    <label for="address" class="col-sm-2 control-label">地址</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="address" name="address" placeholder="请输入地址">
				    </div>
			  </div>
			  <div class="form-group">
				    <label for="qq" class="col-sm-2 control-label">qq</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="qq" name="qq" placeholder="请输入qq">
				    </div>
			  </div>
			  <div class="form-group">
				    <label for="email" class="col-sm-2 control-label">邮箱</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱">
				    </div>
			  </div>
			  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      	<button type="submit" class="btn btn-info">确定</button>
				      	<button id="reset" type="button" class="btn btn-default">重置</button>
				      	<button id="cancel" type="button" class="btn btn-default">取消</button>
				    </div>
			  </div>
			</form>		
		</div>
		
		<script type="text/javascript">
			var reset = document.getElementById("reset");
			var cancel = document.getElementById("cancel");
			
			<%--重置，清空之前的输入--%>
			reset.onclick = function () {
				<%--强制清空缓存刷新，之前的输入内容会被清空--%>
				reload(true);
			}
			
			<%--取消，返回到上一页面--%>
			cancel.onclick = function () {
				history.back();
			}
		</script>
	</body>
</html>











