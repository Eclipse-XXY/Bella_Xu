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
			$("#class-1-select").append("<option value="+json.id+">"+json.flmch1+"</option>");
			
		});
		
	});

});
$(function(){

})
	function get_class2_by_class1(class_1_id){
		$.getJSON("js/json/class_2_"+class_1_id+".js",function(data){
// 			jquery对象的属性都是加上括号的 应该把上次选择的产品的数据从选择框当中移出去 
				$("#class-2-select").empty();
			$(data).each(function(i,json){
				$("#class-2-select").append("<option value="+json.id+">"+json.flmch2+"</option>");
	
			});
		
			get_tm_by_class1();
		});
	};
	function get_tm_by_class1(){
		//一个函数当中获取其他标签的元素的id有多种方式方式1 传参的形式  2方式二如下通过标签选择器的形式 3 后代选择器的形式
		//var class_1_id = $("#spu_class_1_select").val();
		var class_1_id=$("#class-1-select option:selected").val();
		$.getJSON("js/json/tm_class_1_"+class_1_id+".js",function(data){
// 			jquery对象的属性都是加上括号的 应该把上次选择的产品的数据从选择框当中移出去 
			$("#class-tm-select").empty();
			$(data).each(function(i,json){
				$("#class-tm-select").append("<option value="+json.id+">"+json.ppmch+"</option>");
			});
		});
	};
	function spu_click_image(index){
		$("#spu_file_"+index).click();
	}
	function spu_change_image(index){
		var file=$("#spu_file_"+index)[0].files[0];
// 	把一个dom对象转化成一个URL
		var url=window.URL.createObjectURL(file);
		$("#spu_img_"+index).attr("src",url);
		if(index>=2&&(index+1)==$("#spu_images input").length){
			spu_append_image(index+1);
		}
	}
	function spu_append_image(index){
		var img='<img id="spu_img_'+index+'" onclick="spu_click_image('+index+')" style="cursor:pointer;" src="image/upload_hover.png" width="70px"/>';
	    var file='<input id="spu_file_'+index+'" onChange="spu_change_image('+index+')" type="file" style="display:none;" name="files"/> ';
	    $("#spu_images").append(img+file);
	}
</script>
<title>后台管理</title>
</head>
<body>
spu信息管理界面<br>
${ success }<br>
<!-- 表单的提交一定需要加name属性值 -->
<form action="save_spu.do"method="post" enctype="multipart/form-data">
<!-- data-options="fit:true"表示适应数据的高度或者直接写死一个高度要是不设置默认的高度是0 -->
<div class="easyui-layout" data-options="fit:true" style="height:700px">
<div data-options="region:'north',split:true" style="height:50px">
<select name="flbh1" id="class-1-select" onchange="get_class2_by_class1(this.value)"></select>
<select name="flbh2" id="class-2-select" ></select>
<select name="pp_id" id="class-tm-select"></select>
</div>
<div data-options="region:'west',split:true" style="width:150px">
spu名称：<input type="text" name="shp_mch"/> 
spu描述：<textarea rows="10" cols="16" name="shp_msh">
</textarea>
</div>
<div data-options="region:'center'">
spu图片：
<br>
<div id="spu_images">
<img id="spu_img_0" onclick="spu_click_image(0)" style="cursor:pointer;" src="image/upload_hover.png" width="70px"/>
<img id="spu_img_1" onclick="spu_click_image(1)" style="cursor:pointer;" src="image/upload_hover.png" width="70px"/>
<img id="spu_img_2" onclick="spu_click_image(2)" style="cursor:pointer;" src="image/upload_hover.png" width="70px"/>
<input id="spu_file_0" onChange="spu_change_image(0)" type="file" style="display:none;" name="files"/> 
<input id="spu_file_1" onChange="spu_change_image(1)" type="file" style="display:none;" name="files"/> 
<input id="spu_file_2" onChange="spu_change_image(2)" type="file"  style="display:none;" name="files"/>
</div>
<input  type="submit" value="提交">
</div>
</div>
</form>
</body>
</html>