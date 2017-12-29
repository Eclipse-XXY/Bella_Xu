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
<script type="text/javascript">
	function b(){}
</script>
<title>检索管理</title>
</head>
<body>
	<c:forEach items="${list_sku }" var="sku">
		<div class="list">
	  <a href="get_sku_by_id.do?sku_id=${sku.id }&spu_id=${sku.shp_id}" target="_blank">
			<div class="img"><img src="upload/image/${sku.spu.shp_tp}" width="220px" height="220"/></div>
			<div class="price">¥${sku.jg}</div>
			<div class="title">商品名称：${sku.sku_mch}</div>
			<div class="title">库存地址：${sku.kcdz}</div>
	</a>
</div>
	</c:forEach>
</body>
</html>