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
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
$(function(){
	var url = "${url}";
	var title = "${title}";
	if(url!=""&&title!=""){
		index_add_tabs(url,title);
	}
});
function index_add_tabs(url,title){
	//这个必须要加因为easyUI的使用必须先引入jQuery第二次加载tabs表单的时候将会覆盖以前的jQuery的文件
		//更具标题判断该选项卡是否存在
 	var b = $('#index_tt').tabs('exists',title);

	if(!b){
		$.post(url,function(data){
			$('#index_tt').tabs('add',{
				title:title,
				content:data,
				closable:true
			});
		});
	}else{
		//当前如果已经打开的话就直接跳到这个标签页上面
		$('#index_tt').tabs('select',title);
	}
}
</script>
<title>后台管理系统</title>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">后台管理系统</div>
	<div data-options="region:'west',split:true,title:'West'" style="width:150px;padding:10px;">
	<ul class="easyui-tree">
		<li>
			<span>系统管理</span>
				<ul>
				<li><a style="text-decoration:none;" href="javascript:index_add_tabs('goto_spu.do','spu信息');">spu信息</a></li>
				<li><a style="text-decoration:none;" href="javascript:index_add_tabs('goto_attr.do','分类属性');" >分类属性</a></li>
				<li><a style="text-decoration:none;" href="javascript:index_add_tabs('goto_sku.do','库存信息');">库存信息</a></li>
				<li> 
				<span>接口管理</span>
					<ul>
					<li><a  style="text-decoration:none;" href="goto_spu.do" >厂库管理</a></li>
					<li><a  style="text-decoration:none;"href="goto_attr.do" >物流管理</a></li>
					<li><a  style="text-decoration:none;" href="goto_attr.do" >测试管理</a></li>
					</ul>
				</li>
				</ul>
		</li>
		<li>
			<span>缓存管理</span>
				<ul>
				<li><a  style="text-decoration:none;"href="goto_spu.do" >商品缓存</a></li>
				<li><a  style="text-decoration:none;"href="goto_attr.do" >用户缓存</a></li>
				</ul>
		</li>
		
	</ul>
	</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center',title:'Center',iconCls:'icon-ok'">
<!-- 		搞一个选项卡但是数据是动态来的 easyUI拥有控件、属性、事件、方法4个特性。 -->
		<div id="index_tt" class="easyui-tabs" >
<!-- 			需要先通过标签创建一个选项卡的容器然后在通过js动态的加入tabs选项卡的元素 -->
<!-- 			easyUI的方法都是用单引号括起来的 -->
		</div>
	
	</div>
</body>

</html>