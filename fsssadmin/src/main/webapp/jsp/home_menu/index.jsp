<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="/jsp/commen/init.jsp"></jsp:include>
</head>
<body>
	<table id="dg_home_menu" title="列表" class="easyui-datagrid"
		url="${basepath}hm/list.do" toolbar="#toolbar_home_menu"
		pagination="true" rownumbers="true" fitColumns="true"
		singleSelect="true">
		<thead>
			<tr>
				<th field="title" width="50">图片标题</th>
				<th field="path" width="200" sortable="true">路径</th>
				<th field="isshow" width="50">是否显示</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar_home_menu">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="home_menu_add()">添加首页功能</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="edithome_menu()">修改</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="deletehome_menu()">删除</a>
	</div>
	<div id="dlg_home_menu" class="easyui-dialog"
		style="width: 800px; height: 400px; padding: 10px 20px" closed="true" 	buttons="#dlg-buttons">
		<div class="ftitle">首页功能编辑</div>
		<form enctype="multipart/form-data" id="fm_home_menu" method="post" novalidate>
			<div class="fitem">
			<input name="id" type="hidden">
			<label>部署城市:</label>
			<input id="citiesCode" class="easyui-validatebox" name="citiesCode" data-options="valueField:'code',textField:'name',panelHeight: 'auto',editable: false" required="true">
			
			<br>
			<label>图片标题:</label> <input  name="title" class="easyui-validatebox" required="true"/><br>
			<label>图片:</label> <input  name="path" id="home_menu_url1" readonly="readonly" class="easyui-validatebox" required="true"/><input id="home_menu_image1" type="button" value="选择图片"><br>
			<label>图片顺序:</label> <input  name="seq" maxlength="3" class="easyui-numberbox easyui-validatebox" required="true"/><br>
			<label>是否显示:</label> 
					<select name="isshow"   class="easyui-combobox" style="width:155px"   data-options="panelHeight: 'auto',editable: false" required="true"> 
						<option value="1">显示</option>
						<option value="0">不显示</option>
					</select>
					<br>
			<label>WebViewURL:</label> <input  name="webviewUrl" class="easyui-validatebox" required="true"/><br>
			<label>描述:</label> <textarea  name="description" rows="2" cols="50"  /></textarea><br>
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg_home_menu').dialog('close')">关闭</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="savehome_menu()">保存</a> 
	</div>
<script type="text/javascript">
$('#citiesCode').combobox({
    url:'${basepath}cities/all.do',
    valueField:'code',
    textField:'name'
});
var url;
//	添加广告
function home_menu_add() {
	$('#dlg_home_menu').dialog('open').dialog('setTitle', '新建首页功能');
	$('#fm_home_menu').form('clear');
	url = '${basepath}hm/save.do';
}
//	修改广告
function edithome_menu() {
	var row = $('#dg_home_menu').datagrid('getSelected');
	if (row) {
		$('#dlg_home_menu').dialog('open').dialog('setTitle', '修改首页功能');
		$('#fm_home_menu').form('clear');
		$('#fm_home_menu').form('load', row);
		url = '${basepath}hm/update.do';
	} else {
		$.messager.alert('警告', '请选择要编辑的列!', 'error');
	}

}
//	保存广告
function savehome_menu() {
	$('#fm_home_menu').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.status=="1") {
				$('#dlg_home_menu').dialog('close'); // close the dialog
				$('#dg_home_menu').datagrid('reload'); // reload the user data
			} else {
				$.messager.show({
					title : 'Error',
					msg : result
				});
			}
		}
	});
}
//删除广告
function deletehome_menu() {
	var row = $('#dg_home_menu').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定要删除此首页功能?', function(r) {
			if (r) {
				$.post('${basepath}hm/delete.do', {
					'id' : row.id
				}, function(result) {
					if (result.status=="1") {
						$('#dg_home_menu').datagrid('reload'); // reload the user data
					} else {
						$.messager.show({ // show error message
							title : 'Error',
							msg : result.errorMsg
						});
					}
				}, 'json');
			}
		});
	}
}


	var editor = KindEditor.editor({
		allowFileManager : true
	});
	$('#home_menu_image1').click(function() {
		editor.loadPlugin('image', function() {
			editor.plugin.imageDialog({
				showRemote : false,
				imageUrl : KindEditor('#home_menu_url1').val(),
				clickFn : function(url, title, width, height, border, align) {
					KindEditor('#home_menu_url1').val(url);
					$("#fm_home_menu").form('validate');
					editor.hideDialog();
				}
			});
		});
	});
</script>
<style type="text/css">
#fm_home_menu {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}
</style>
</body>
</html>