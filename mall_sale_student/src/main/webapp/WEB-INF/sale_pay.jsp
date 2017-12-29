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
<link rel="stylesheet" type="text/css" href="css/checkedstand.css"/>
<link rel="stylesheet" type="text/css" href="css/css.css">	
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function b(){}
</script>
<title>信商商城</title>
</head>
<body>
<div class="top">
		<div class="top_text">
			<a href="">用户登录</a>
			<a href="">用户注册</a>
			<a href="">供应商登录</a>
			<a href="">供应商注册</a>
		</div>
	</div>
	<div class="top_img">
		<img src="./images/top_img.jpg" alt="">
	</div>
<div class="warp">
	<form action="order_pay.do" method="post">
			<div class="money">10000</div>
			<input type="text" class="password" placeholder="请输入京东支付密码"/>
			<div class="pay">
	<input type="image" src="images/pay.gif" onClick="onSubmit" value="支付"/>
			</div>
 </form>
	</div>
</body>
</html>