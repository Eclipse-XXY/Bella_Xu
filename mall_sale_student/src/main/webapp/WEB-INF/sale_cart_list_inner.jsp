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
	function sale_change_cart(checked,tjshl,sku_id){
		if(checked){
			checked="1";
		}else{
			checked="0";
		}
		$.post("change_cart.do",{shfxz:checked,tjshl:tjshl,sku_id:sku_id},function(data){
			$("#sale_cart_list_inner").html(data)
		});
	}
	$("#btncommit").click(function(){
		$("#dosubmint").submit();
	});
})
</script>
<title>信商商城</title>
</head>
<body>
	<div class="Cbox">
		<table class="table table-striped table-bordered table-hover">
		   <thead>
		     <tr>
		       <th>是否购买</th>
		       <th>商品图片</th>
		       <th>商品名称</th>
		       <th>库存地址</th>
		       <th>商品价格</th>
		       <th>商品数量</th>
		       <th>操作</th>
		     </tr>
		   </thead>
		   <tbody>
	   <form id="dosubmint" action="goto_order.do" method="post">
	     <c:forEach items="${list_cart}" var="cart">
	     <tr>
	     <td><input onclick="sale_change_cart(this.checked,-1,${cart.sku_id})" type="checkbox"  ${cart.shfxz=="1"?"checked":""}/></td>
	     <td><img src="upload/image/${cart.shp_tp }" width="70px" alt=""></td>
	     <td>${cart.sku_mch}&nbsp;</td>
	     <td> ${cart.kcdz}</td>
	     <td>${cart.sku_jg}&nbsp;</td>
	     <td>
	   <a href="javascript:sale_change_cart(0,${cart.tjshl-1},${cart.sku_id});" >-</a>
	   ${cart.tjshl}
	   <a href="javascript:sale_change_cart(0,${cart.tjshl+1},${cart.sku_id});" >+</a>
	   <br>
	   </td>
	    <td>删除</td>
	  </tr>
	</c:forEach> 
	</form>		 
	</tbody>
  </table>
</div>
	     	      
<div class="Cprice">
		<div class="price">总价：	${sum}0</div>
		<input id="btncommit"class="jiesuan" type="button"  value="结算"/>
</div>
</body>
</html>