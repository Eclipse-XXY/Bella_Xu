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
<link rel="stylesheet" type="text/css" href="css/css.css"/>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/finishCart.css"/>
<script type="text/javascript">
	function b(){}
</script>
<style type="text/css">
.item_title{
display: block;
font-size: 20px;
color:#9ca135;
margin-left: 300px;
margin-top: 0px;
}
.item_des{
display: block;
font-size: 15px;
margin-left: 300px;
margin-top: 10px;
}
</style>
<title>信商商城</title>
</head>
<body>
	<div class="top_img">
		<img src="./images/top_img.jpg" alt="">
	</div>
<div class="search">
			<div class="logo"><img src="./images/logo.jpg" alt=""></div>
			<div class="search_on">
				<div class="se">
					<input type="text" name="search" class="lf">
					<input type="submit" class="clik" value="搜索">
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
		<div class="cartPro">
			<span class="dec">该商品已加入购物车</span>
			<div class="lec">
				<a href="javascript:;"><img src="upload/image/1513331662112u=773170730,2334764817&fm=21&gp=0.jpg"width="100px"  height="70px"alt=""/></a>
			</div>
<!-- 			<span class="lec_name"> -->
			          
			       <span class="item_title"  > <B>恭喜你添加购物车成功！ </B>   </span> 
<!-- 			</span> -->
			<span class="item_des">
				数量：1件 
			</span>
			<div class="shop_des">
				<a href="javascript:;"><img src="images/shop_des.png"/></a>
			</div>
			<div class="shop_cart">
				<a href="goto_cart_list.do"><img src="images/shop_cart.png"/></a>
			</div>
		</div>

		<div class="footer">
		<div class="top"></div>
		<div class="bottom"><img src="images/foot.jpg" alt=""></div>
	</div>
</body>
</html>