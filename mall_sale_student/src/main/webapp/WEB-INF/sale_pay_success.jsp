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
<link rel="stylesheet" type="text/css" href="css/logistics.css"/>
<link rel="stylesheet" href="css/style.css">

<script type="text/javascript">
	function b(){}
</script>
<title>信商商城</title>
</head>
<body>
	<div class="top_img">
		<center><img src="./images/top_img.jpg" alt=""></center>
	</div>
	<div class="top">
			<div class="top_left">	
			    <button class="btn01">支付已完成</button>			
				<button class="btn02">查看发票详情</button>
			</div>
			<div class="stepInfo">
				<ul>
					<li></li>
					<li></li>
				</ul>
				<div class="stepIco stepIco1 stepStyle" id="create">1
					<div class="stepText" id="createText">创建订单</div>
				</div>
				<div class="stepIco stepIco2 stepStyle" id="check">2
					<div class="stepText" id="checkText">审核订单</div>
				</div>
				<div class="stepIco stepIco3 stepStyle" id="produce">3
					<div class="stepText" id="produceText">生产</div>
				</div>
				<div class="stepIco stepIco4 stepStyle" id="delivery">4
					<div class="stepText" id="deliveryText">配送</div>
				</div>
				<div class="stepIco stepIco5" id="received">5
					<div class="stepText" id="receivedText">签收</div>
				</div>
			</div>
			
		</div>
		
		
		<div class="bottom">
			<div class="bottom_left">				
				<a href="###"><img src="images/lec1.png"/></a>				
			</div>
			
			<div class="track-rcol" >
				<div class="track-list">
					<ul>
						<li class="first">
							<i class="node-icon"></i>
							<span class="time">2018-01-10 10:07:15</span>
							<span class="txt">感谢您在信商网购物，欢迎您再次光临！</span>
						</li>
						<li>
							<i class="node-icon"></i>
							<span class="time">2018-01-12 10:07:15</span>
							<span class="txt">【信商到家】信商配送员【申国龙】已出发，联系电话【18410106883，感谢您的耐心等待，参加评价还能赢取金币呦】</span>
						</li>
						<li>
							<i class="node-icon"></i>
							<span class="time">2018-01-10 10:07:15</span>
							<span class="txt">感谢您在信商购物，欢迎您再次光临！</span>
						</li>
						<li>
							<i class="node-icon"></i>
							<span class="time">2018-01-10 10:07:15</span>
							<span class="txt">感谢您在信商购物，欢迎您再次光临！</span>
						</li>
							<li>
							<i class="node-icon"></i>
							<span class="time">2018-01-10 10:07:15</span>
							<span class="txt">感谢您在信商购物，欢迎您再次光临！</span>
						</li>
						<li>
							<i class="node-icon"></i>
							<span class="time">2018-01-10 10:07:15</span>
							<span class="txt">感谢您在信商购物，欢迎您再次光临！</span>
						</li>
					</ul>
				</div>
			</div>	
			
		</div>
</body>
</html>