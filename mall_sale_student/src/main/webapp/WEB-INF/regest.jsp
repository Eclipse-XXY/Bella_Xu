<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/sign.css"/>
<style type="text/css">
body{ background-color:#fff}
input{background-color:#fff}
</style>
<script type="text/javascript">
	function b(){}
</script>
<title>注册界面</title>
</head>
<body>
	<!--头部-->
    <div class="header">
        <a class="logo" href="##"></a>
        <div class="desc">欢迎注册</div>
    </div>
    <!--版心-->
    <form method="post" action="saveuser.do" id="saveform">
    <div class="container">
    	<!--京东注册模块-->
    	<div class="register">
    		<!--用户名-->
    		<div class="register-box">
    			<!--表单项-->
    			<div class="box default">
    				<label for="userName">用&nbsp;户&nbsp;名</label>
    				<input type="text" name="yh_mch" id="userName" placeholder="您的账户名和登录名" />
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
    		<!--设置密码-->
    		<div class="register-box">
    			<!--表单项-->
    			<div class="box default">
    				<label for="pwd">设 置 密 码</label>
    				<input type="password" name="yh_mm" id="pwd" placeholder="建议至少两种字符组合" />
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
    		<!--确认密码-->
    		<div class="register-box">
    			<!--表单项-->
    			<div class="box default">
    				<label for="pwd2">确 认 密 码</label>
    				<input type="password" id="pwd2" placeholder="请再次输入密码" />
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
			<!--设置密码-->
    		<div class="register-box">
    			<!--表单项-->
    			<div class="box default">
    				<label for="email">邮 箱 验 证</label>
    				<input type="text" name="yh_yx" id="email" placeholder="请输入邮箱" />
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
    		<!--手机验证-->
    		<div class="register-box">
    			<!--表单项-->
    			<div class="box default">
    				<label for="mobile">手 机 验 证</label>
    				<input type="text" name="yh_shjh" id="mobile" placeholder="请输入手机号" />
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
    		 <!--注册协议-->
    		<div class="register-box xieyi">
    			<!--表单项-->
    			<div class="box default">
    				<input type="checkbox" id="ck" />
    				<span>我已阅读并同意<a href="##">《信商用户注册协议》</a></span>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
    		<!--注册-->
 
    		<button onClick="onSubmit()" id="btn">注册</button>
    
    	</div>
    </div>
    </form>	
</body>
</html>