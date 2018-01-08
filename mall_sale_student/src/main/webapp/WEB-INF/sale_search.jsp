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
<style type="text/css">
.list_a{text-decoration:none;color:#000000; font-family: '微软雅黑';font-size: 16px;}
</style>
<script type="text/javascript">
// shxm_mch这个参数的传递是两个参数合并在一起传递过来的
function search_attr_up(shxm_id,shxzh_id,shxm_mch){
	$("#search_attr_"+shxm_id).hide();
	$("#search_attr_show").append("<span id='search_attr_span_id"+shxm_id+"' class='gt'>&gt</span><div class='filter_div' id='search_attr_show_id"+shxm_id+"'><a href='javascript:search_attr_down("+shxm_id+");'>"+shxm_mch+"</a><input type='hidden' value='{\"shxm_id\":"+shxm_id+",\"shxzh_id\":"+shxzh_id+"}' name='search_attr_id_arry'><div>");
	search_get_sku_by_attr();
}
function search_attr_down(shxm_id){
	$("#search_attr_"+shxm_id).show();
	$("#search_attr_show_id"+shxm_id).remove();
	$("#search_attr_span_id"+shxm_id).remove();
	search_get_sku_by_attr();
}
function  search_get_sku_by_attr(){
	var list_av=$("#search_attr_show input[name='search_attr_id_arry']");
	var list_av_string="";
	$(list_av).each(function(i,json){
	var json_obj=$.parseJSON(json.value);
	list_av_string+="list_av["+i+"].shxm_id="+json_obj.shxm_id+"&list_av["+i+"].shxzh_id="+json_obj.shxzh_id+"&";
	});
	var class_2_id=${class_2_id};	
	var order=$("#search_order_show").val();
	list_av_string+="class_2_id="+class_2_id+"&order="+order;
	$.ajax({
		url:"get_sku_by_attr.do",
		data:list_av_string,
		success:function(data){
			$("#search_inner").html(data);
		}
	
});
};
function search_change_order(new_order){
	var old_order=$("#search_order_show").val();
	if(new_order==old_order){
		new_order+=" desc ";
	}
	$("#search_order_show").val(new_order);
	search_get_sku_by_attr();
};
</script>
<title>检索</title>
	<link rel="stylesheet" type="text/css" href="css/css.css">
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
<!-- 			<div id="search_attr_show"></div> -->
	<input type="text" class="lf" name="search" id="search_order_show" value=" order by jg"/>
	<input type="submit" class="clik" onclick="search_change_order(' order by jg ')" value="搜索">
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
	<!--筛选阶段-->
	<div  class="filter">
		<h2>手机、数码 </h2>
		<br>
		<span class="gt">&gt</span>
		<div class="filter_div">
			华为
		</div>
		<span class="gt">&gt</span>
		<div class="filter_div">
			荣耀系列
		</div>
		<span class="gt">&gt</span>
		<div class="filter_div">
			魔兽游戏机
		</div>
		<div id="search_attr_show" ></div>
		<div class="filter_clear">
			清空筛选
		</div>
				
	</div>
	<div class="Sscreen">
		<div class="title">
			${class_2_name}属性列表&nbsp;商品筛选 共1205个商品
		</div>
		<c:forEach items="${list_attr }" var="attr">
		<div class="list">
			<div id="search_attr_${attr.id}">
			<span>${attr.shxm_mch}:</span>
				<c:forEach items="${attr.list_value }" var="value">
				<a href="javascript:search_attr_up(${attr.id },${value.id },'${value.shxzh }${value.shxzh_mch}');">${value.shxzh}${value.shxzh_mch}</a>
				</c:forEach>
			</div>
			</div>
			</c:forEach>
		
			<div class="list">
			<span>品牌：</span>
			<a href="">乐视TV(Letv)</a>
			<a href="">华为荣耀</a>
			<a href="">小米之家</a>
			<a href="">苹果手机</a>
			<a href="">诺基亚</a>
			<a href="">OPPO-R9</a>
			<a href="">vivo手机</a>
			<a href="">金立手机</a>
			<a href="">摩托莫拉</a>
		</div>
		<div class="list">
			<span>价格：</span>
			<a href="">0-1399</a>
			<a href="">1399-2399</a>
			<a href="">2399-34399</a>
			<a href="">3399-4399</a>
			<a href="">4399-5399</a>
			<a href="">5399-6399</a>
			<a href="">6399-7399</a>
			<a href="">7399-8399</a>
			<a href="">8399-9399</a>
		</div>
		<div class="list">
			<a  class="list_a" style="color: #000000;" href="javascript:search_change_order(' order by jg ');"><span class="list_span" id="list_beas">价格</span></a>
			<a style="color: #000000;" class="list_a" href="javascript:search_change_order(' order by sku_xl ');"><span class="list_span" >销量</span></a>
			<a  style="color: #000000;"class="list_a" href="javascript:search_change_order(' order by plsh ');"><span class="list_span" >评论数</span></a>
			<a  style="color: #000000;"class="list_a" href="javascript:search_change_order(' order by sku_chjshj ');"><span class="list_span">上架时间</span></a>
		</div>
	</div>
	<div class="Sbox">
		<div id="search_inner">
		<jsp:include page="sale_search_inner.jsp"></jsp:include>
		</div>
	</div>
	<div class="footer">
		<div class="top"></div>
		<div class="bottom"><img src="images/foot.jpg" alt=""></div>
	</div>
</body>
</html>