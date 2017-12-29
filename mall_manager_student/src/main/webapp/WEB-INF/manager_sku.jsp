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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function(){
		$.getJSON("js/json/class_1.js",function(data){
			$(data).each(function(i,json){
				$("#sku-class-1-select").append("<option value="+json.id+">"+json.flmch1+"</option>");
			});
		});
	});
		function sku_get_class2_by_class1(class_1_id){
			$.getJSON("js/json/class_2_"+class_1_id+".js",function(data){
					$("#sku-class-2-select").empty();
				$(data).each(function(i,json){
					$("#sku-class-2-select").append("<option value="+json.id+">"+json.flmch2+"</option>");
				});
				sku_get_tm_by_class1();
			});
		};
		function sku_get_tm_by_class1(){
			var class_1_id=$("#sku-class-1-select option:selected").val();
			$.getJSON("js/json/tm_class_1_"+class_1_id+".js",function(data){
				$("#sku-class-tm-select").empty();
				$(data).each(function(i,json){
					$("#sku-class-tm-select").append("<option value="+json.id+">"+json.ppmch+"</option>");
				});
			});
		};
		function sku_get_spu_by_tm(pp_id){
			var class_1_id=$("#sku-class-1-select").val();
			var class_2_id=$("#sku-class-2-select").val();
			$.post("get_spu_by_tm.do",{flbh2:class_2_id,flbh1:class_1_id,pp_id:pp_id},function(data){
				$(data).each(function(i,json){
				$("#sku-spu-select").append("<option value="+json.id+">"+json.shp_mch+"</option>");
				sku_get_sku_attr_list_by_class2(class_2_id);
				});
				});
			
		};
		function sku_get_sku_attr_list_by_class2(class_2_id){
			$.post("get_sku_attr_list_by_class2.do",{class_2_id:class_2_id},function(data){
				$("#sku_attr_list_inner").html(data);
				});
		};
</script>
<title>index</title>
</head>
<body>
	<form action="save_sku.do" method="post">
	<select name="flbh1" id="sku-class-1-select" onchange="sku_get_class2_by_class1(this.value)"></select>
	<select name="flbh2" id="sku-class-2-select" onchange="sku_get_sku_attr_list_by_class2(this.value)"></select>
	<select name="pp_id" id="sku-class-tm-select" onChange="sku_get_spu_by_tm(this.value)"></select>
	<select name="spu_id" id="sku-spu-select"></select>
	<hr>
	<div id="sku_attr_list_inner"></div>
	</form>
</body>
</html>