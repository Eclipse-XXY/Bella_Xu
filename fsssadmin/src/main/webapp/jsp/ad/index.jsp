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
	<table id="dg_advert" title="列表" class="easyui-datagrid"
		url="${basepath}ad/list.do" toolbar="#toolbar_advert"
		pagination="true" rownumbers="true" fitColumns="true"
		singleSelect="true">
		<thead>
			<tr>
				<th field="title" width="50">图片标题</th>
				<th field="path" width="200" sortable="true">路径</th>
				<th field="isshow" width="50">是否显示</th>
				<th field="groups" width="50">分组</th>
				
			</tr>
		</thead>
	</table>
	<div id="toolbar_advert">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="advert_add()">添加广告</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editAdvert()">修改</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="deleteAdvert()">删除</a>
	</div>
	<div id="dlg_advert" class="easyui-dialog"
		style="width: 800px; height: 400px; padding: 10px 20px" closed="true" 	buttons="#dlg-buttons">
		<div class="ftitle">广告编辑</div>
		<form enctype="multipart/form-data" id="fm_advert" method="post" novalidate>
			<div class="fitem">
			<input name="id" type="hidden">
			<label>部署城市:</label>
			<select id="citiesCode" style="width:155px" required="true" class="easyui-combobox"  name="citiesCode" data-options="url:'${basepath}cities/all.do',valueField:'code', textField:'name', panelHeight: 'auto',editable: false"   >
			</select>
			<br>
			<label>图片标题:</label> <input  name="title" class="easyui-validatebox" required="true"/><br>
			<label>图片:</label> <input  name="path" id="advert_url1" readonly="readonly" class="easyui-validatebox" required="true" /><input id="advert_image1" type="button" value="选择图片"><br>
			<label>图片顺序:</label> <input  name="seq" maxlength="3" class="easyui-numberbox easyui-validatebox" required="true"/><br>
			<label>是否显示:</label> 
					<select name="isshow"   class="easyui-combobox" style="width:155px"   data-options="panelHeight: 'auto',editable: false" required="true"> 
						<option value="1">显示</option>
						<option value="0">不显示</option>
					</select>
					<br>
			<label>描述:</label> <textarea  name="description" rows="2" cols="50"  /></textarea><br>
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg_advert').dialog('close')">关闭</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveAdvert()">保存</a> 
	</div>
<script type="text/javascript">
var url;
//	添加广告
function advert_add() {
	$('#dlg_advert').dialog('open').dialog('setTitle', '新建广告');
	$('#fm_advert').form('clear');
	url = '${basepath}ad/save.do';
}
//	修改广告
function editAdvert() {
	var row = $('#dg_advert').datagrid('getSelected');
	if (row) {
		$('#dlg_advert').dialog('open').dialog('setTitle', '修改广告');
		$('#fm_advert').form('clear');
		$('#fm_advert').form('load', row);
		url = '${basepath}ad/update.do';
	} else {
		$.messager.alert('警告', '请选择要编辑的列!', 'error');
	}

}
//	保存广告
function saveAdvert() {
	$('#fm_advert').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.status=="1") {
				$('#dlg_advert').dialog('close'); // close the dialog
				$('#dg_advert').datagrid('reload'); // reload the user data
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
function deleteAdvert() {
	var row = $('#dg_advert').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定要删除此广告?', function(r) {
			if (r) {
				$.post('${basepath}ad/delete.do', {
					'id' : row.id
				}, function(result) {
					if (result.status=="1") {
						$('#dg_advert').datagrid('reload'); // reload the user data
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
	$('#advert_image1').click(function() {
		editor.loadPlugin('image', function() {
			editor.plugin.imageDialog({
				showRemote : false,
				imageUrl : KindEditor('#advert_url1').val(),
				clickFn : function(url, title, width, height, border, align) {
					KindEditor('#advert_url1').val(url);
					$("#fm_advert").form("validate");
					editor.hideDialog();
				}
			});
		});
	});
</script>
<style type="text/css">
#fm_advert {
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