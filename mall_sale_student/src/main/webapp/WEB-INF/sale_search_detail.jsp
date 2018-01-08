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
<div class="top_img">
		<img src="./images/top_img.jpg" alt="">
	</div> 
<div class="top">
		<div class="top_text">
		<jsp:include page="sale_header.jsp"></jsp:include>
		</div>
	</div>
	
	<div class="search searchBac">
		<div class="logo"><img src="./images/logol.jpg" alt=""></div>
		<jsp:include page="sale_miniCart.jsp"/>
	</div>
	<div class="menu">
		<div class="nav">
			<div class="navs">
				<div class="left_nav">
					全部商品分类
				</div>
				<ul>
					<li><a href="">服装城</a></li>
					<li><a href="">美妆馆</a></li>
					<li><a href="">超市</a></li>
					<li><a href="">全球购</a></li>
					<li><a href="">闪购</a></li>
					<li><a href="">团购</a></li>
					<li><a href="">拍卖</a></li>
					<li><a href="">金融</a></li>
					<li><a href="">智能</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="Dbox">
		<div class="box">
			<div class="left">
				<div class="timg"><img src="upload/image/${obj_sku.spu.shp_tp }" width="350px"  height="300px" alt=""></div>
				<div class="timg2">
					<div class="lf"><img src="images/lf.jpg" alt=""></div>
					<div class="center">
					<c:forEach items="${obj_sku.list_image }" var="img">
<span><img  src="upload/image/${img.url }" width="50px"  height="50px"alt=""></span>
					</c:forEach>
					</div>
					<div class="rg"><img src="images/rg.jpg" alt=""></div>
				</div>
				<div class="goods"><img src="images/img_6.jpg" alt=""></div>
			</div>
			<div class="cent">
				<div class="title">${obj_sku.sku_mch}（黑色）</div>
				<div class="bg">
					<p>市场价：<strong>￥${obj_sku.jg+198}</strong></p>
					<p>促销价：<strong>￥${obj_sku.jg}</strong></p>
					<div class="clear"><div class="min_t">商品库存：</div>
					<div class="min_mx" onclick=func($(this),'0')>${obj_sku.kc}件</div></div>
				</div>
				<div class="clear">
					<div class="min_t">选择版本：</div>
					<c:forEach items="${obj_sku.list_av_name }" var="av">	
					<div class="min_mx" onclick=func($(this),'0')>${av.shxm_mch }:${av.shxzh_mch}</div>
					</c:forEach>
<%-- <c:forEach items="${list_sku}" var="sku"> --%>
<%-- 		<a href="get_sku_by_id.do?sku_id=${sku.id}&spu_id=${sku.shp_id}"><div class="min_mx">${sku.sku_mch}</div></a><br> --%>
<%-- </c:forEach> --%>
				</div>
				<div class="clear">
					<div class="min_t" onclick=func($(this),'1')>商品买点：</div>
					<div class="min_mx" onclick=func($(this),'0')>${obj_sku.spu.shp_msh }</div>
				</div>
				<div class="clear" style="margin-top:20px;">
					<div class="min_t" style="line-height:36px">数量：</div>
					<div class="num_box">
						<input type="text" name="num" value="1" style="width:40px;height:32px;text-align:center;float:left">
						<div class="rg">
							<img src="images/jia.jpg" id='jia' alt="">
							<img src="images/jian.jpg" id='jian' alt="">
						</div>
					</div>
				</div>
				<div class="clear" style="margin-top:20px;">
					<form action="add_cart.do" method="post">
					<input type="hidden" name="sku_mch" value="${obj_sku.sku_mch}"/>
					<input type="hidden" name="sku_jg" value="${obj_sku.jg}" />
					<input type="hidden" name="tjshl" value="1" />
					<input type="hidden" name="hj" value="${obj_sku.jg}" />
					<input type="hidden" name="shp_id" value="${obj_sku.spu.id}" />
					<input type="hidden" name="sku_id" value="${obj_sku.id}" />
					<input type="hidden" name="shp_tp" value="${obj_sku.spu.shp_tp}" />
					<input type="hidden" name="shfxz" value="1" />
					<input type="hidden" name="kcdz" value="${obj_sku.kcdz}" />
					<input type="image" src="images/mai.jpg" onClick="onSubmit"/>
					<input type="image" src="images/shop.jpg" onClick="onSubmit"/>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="Dbox1">
		<div class="boxbottom">
			<div class="top">
				<span>商品详情</span>
				<span>评价</span>
			</div>
			<div class="btm">
			手机像素很好，柔光双摄照亮你的美
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="top"></div>
		<div class="bottom"><img src="images/foot.jpg" alt=""></div>
	</div>
</body>
</html>