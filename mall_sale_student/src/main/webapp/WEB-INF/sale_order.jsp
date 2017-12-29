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
	function b(){}
</script>
<title>信商商城</title>
</head>
<body>
	<div class="top">
		<div class="top_text">
		<jsp:include page="sale_header.jsp"></jsp:include>
		</div>
	</div>
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
		<form action="save_order.do" method="post">
		<div class="message">
		<c:forEach items="${list_address }" var="address">
		<input type="radio" name="address_id" value="${address.id }"/>
			<div class="msg_title">收货人信息：</div>
			<div class="msg_addr">
				<span class="msg_left">${address.shjr} </span> &nbsp;
				<span class="msg_right">
				 联系方式：${address.lxfsh}&nbsp;收件地址：${address.dz_mch}
				 </span>
		 </div>
		 <div class="msg_line"></div>
		</c:forEach>
		 <span class="addrs">查看更多地址信息</span>
			<div class="msg_title">
				送货清单
			</div>
			<div class="msg_list">
				<c:forEach items="${order.list_flow }" var="flow">
				    <div class="msg_list_left">
					配送方式  <span class="left_title">${flow.psfsh}</span><br>
					目的地：${flow.mqdd}<br/>
				   </div>
					<div class="msg_list_right" >
					  <c:forEach items="${flow.list_info }" var="info">
						<div class="msg_img">
						<img  src="upload/image/${info.shp_tp }" width="150px" height="100px"/>
					    </div>
					    <div class="msg_name">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						${info.sku_mch} 
						</div>
						<div class="msg_price">
						￥${info.sku_jg}
						</div>
						<div class="msg_mon">
							*1
						</div>
						<div class="msg_state">
							有货
						</div>
						</c:forEach>
						</div>
				</c:forEach>
				</div>	
	        </div>
	        		<div class="msg_sub">
					<div class="msg_sub_tit">
					应付金额：
					<b>￥${order.zje }.00</b>
				    </div><br/>
				    <div class="msg_sub_adds">
					寄送至 ： 郑州市 中原区 中原中路 中原工学院    &nbsp;徐雪娅（收）  159****4081
				    </div>
				    <div  style="align:left;">
				        <b>   订单号：${20180116+order.jdh }</b>
				     </div>
				<input  class="msg_btn" type="submit" value="提交订单">
				   	</div>
	        </form>
		<br>
</body>
</html>