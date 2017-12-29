<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basepath", basePath);
%>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css"
	href="${basepath }plugins/easyui/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${basepath }plugins/easyui/bootstrap/icon.css" />
<link rel="stylesheet" href="${basepath }plugins/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="${basepath }plugins/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="${basepath }plugins/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="${basepath }plugins/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="${basepath }plugins/kindeditor/plugins/code/prettify.js"></script>

<script type="text/javascript" src="${basepath }plugins/easyui/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${basepath }plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${basepath }plugins/easyui/easyui_lang_zh_CN.js"></script>
<!--<script type="text/javascript" src="${basepath }js/ajaxfileupload.js"></script>  -->
<!-- <script type="text/javascript" src="js/easyui-kindeditor.js"></script> -->

