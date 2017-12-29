<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>商户登陆</title>
<jsp:include page="/jsp/commen/init.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="plugins/bootstrap3/bootstrap.min.css" />
</head>
<body>
	<div align="center" style="margin-top: 120px">
		<div class="easyui-panel" title="商户登陆" style="width: 500px">
			<div style="padding: 10px 60px 20px 60px" class="form-horizontal">
				<form id="ff" method="post" action="ts_user.do?method=login">

					<div class="form-group">
<!-- 						<label for="inputEmail3" class="col-sm-2 control-label">用户名</label> -->
						<div class="col-sm-12">
							<input class="form-control input-lg" name="username" id="usernameId"
								placeholder="用户名">
						</div>
					</div>
					<div class="form-group">
<!-- 						<label for="inputPassword3" class="col-sm-2 control-label">密码</label> -->
						<div class="col-sm-12">
							<input type="password" class="form-control input-lg"
								name="userpwd" placeholder="密码">
						</div>
					</div>
					
				</form>
				<div class="form-group">
						<div class="col-sm-12">
							<button type="button" onclick="submitForm()" class="btn btn-primary btn-lg btn-block">登录</button>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="button" onclick="clearForm()" class="btn btn-primary btn-lg btn-block">清除</button>
						</div>
					</div>
			</div>
		</div>
	</div>

	<script>
		function submitForm() {

			$('#ff').form('submit', {
				url : "ts_user.do?method=login",
				success : function(data) {
					if (data == "ok") {
						window.location.href = '/fsssadmin/jsp/index.jsp';
					} else {
						$.messager.alert('提示', "登录失败", "error");
					}
				}
			});
		}
	    document.onkeydown = function(e){
	        if(!e) e = window.event;//火狐中是 window.event
	        if((e.keyCode || e.which) == 13){
	        	submitForm();
	        }
	    }

		function clearForm() {
// 			$("input[name='username']").html('');
// 			$("input[name='userpwd']").html('');
// 			$('#usernameId').html('');
// 			alert("ssss"+$("#usernameId").html());
			}
	</script>
</body>
</html>