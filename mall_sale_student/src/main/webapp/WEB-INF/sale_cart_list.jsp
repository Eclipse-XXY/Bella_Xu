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
<link rel="stylesheet" type="text/css" href="css/css.css">	
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/finishCart.css"/>

<script type="text/javascript">
	$(function(){
// 	function sale_change_cart(checked,tjshl,sku_id){
// 		if(checked){
// 			checked="1";
// 		}else{
// 			checked="0";
// 		}
// 		$.post("change_cart.do",{shfxz:checked,tjshl:tjshl,sku_id:sku_id},function(data){
// 			$("#sale_cart_list_inner").html(data)
// 		});
// 	}
	})
</script>
<title>信商商城</title>
</head>
<style type="text/css">
	td{vertical-align: middle !important;}
	.form-group{padding: 5px 0;}
</style>
<body>
<div class="top">

	</div>
	<div class="top_img">
		<img src="./images/top_img.jpg" alt="">
	</div>
	<div class="search">
		<div class="logo"><img src="./images/logo.jpg" alt=""></div>
		<div class="search_on">
			<div class="se">
				<input type="text" name="search" class="lf">
				<input type="submit" class="clik" value="搜索" style="height: 32px;">
			</div>
			<div class="se">
				<a href="">取暖神奇</a>
				<a href="">1元秒杀</a>
				<a href="">吹风机</a>
				<a href="">玉兰油</a>
			</div>
		</div>
		<jsp:include page="sale_miniCart.jsp"></jsp:include>

	</div>
	<div id="sale_cart_list_inner">
	<jsp:include page="sale_cart_list_inner.jsp"></jsp:include>
	</div>
	<div class="footer">
		<div class="top"></div>
		<div class="bottom"><img src="images/foot.jpg" alt=""></div>
	</div>
</body>
</html>