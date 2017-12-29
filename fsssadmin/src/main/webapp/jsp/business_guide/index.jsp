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
	<table id="dg_business_guide" title="列表" class="easyui-datagrid"
		url="${basepath}bg/list.do" toolbar="#toolbar_business_guide"
		pagination="true" rownumbers="true" fitColumns="true"
		singleSelect="true">
		<thead>
			<tr>
				<th field="title" width="50">标题</th>
				<th field="type" width="200" sortable="true">分类</th>
				<th field="createDate" width="50">创建日期</th>
				
			</tr>
		</thead>
	</table>
	<div id="toolbar_business_guide">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="business_guide_add()">添加业务指南</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editbusiness_guide()">修改</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="deletebusiness_guide()">删除</a>
	</div>
	<div id="dlg_business_guide" class="easyui-dialog"
		style="width: 800px; height: 400px; padding: 10px 20px" closed="true" buttons="#dlg-business_guide-buttons">
		<div class="ftitle">编辑业务指南</div>
		<form enctype="multipart/form-data" id="fm_business_guide" method="post" novalidate>
			<div class="fitem">
			<input name="id" type="hidden">
			<label>部署城市:</label>
			<select id="citiesCode" style="width:155px" required="true" class="easyui-combobox"  name="citiesCode" data-options="url:'${basepath}cities/all.do',valueField:'code', textField:'name', panelHeight: 'auto',editable: false"   >
			</select>
			<br>
			<label>图片icon:</label> <input  name="path" class="easyui-validatebox" required="true" id="business_guide_url1" readonly="readonly"/><input id="business_guide_image1" type="button" value="选择图片"><br>
			<label>标题:</label>
			<input id="title" class="easyui-validatebox" name="title" required="true">
			<br>
			<label>分类:</label> 
			<select name="type" class="easyui-combobox" style="width:155px"   data-options="panelHeight: 'auto',editable: false" required="true" > 
				<option value="1">医疗保险</option>
				<option value="2">工伤保险</option>
				<option value="3">生育保险</option>
				<option value="4">失业保险</option>
				<option value="5">养老保险</option>
				<option value="6">居民医疗</option>
			</select>
			<br>
			<label>内容:</label><textarea name="content" style="height: 50px;width: 100%"></textarea><br>
			</div>
		</form>
	</div>
	<div id="dlg-business_guide-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg_business_guide').dialog('close')">关闭</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="savebusiness_guide()">保存</a> 
	</div>
<script type="text/javascript">
var url;
var editor1	;
//关闭弹出层时移除富文本编辑器，防止打开后显示上次编辑过的信息。

//	添加
function business_guide_add() {
	KindEditor.remove('textarea[name=content]');
	$('#dlg_business_guide').dialog('open').dialog('setTitle', '新建业务指南');
	$('#fm_business_guide').form('clear');
	
	//清空内容
	$("textarea[name='content']").html('');
	editor1	 = KindEditor.create('textarea[name="content"]', {
		afterBlur: function(){this.sync();},
		uploadJson : '${basepath}plugins/kindeditor/upload_json.jsp',
		fileManagerJson : '${basepath}plugins/kindeditor/file_manager_json.jsp'
	});
	editor1.html('');
	
	url = '${basepath}bg/save.do';
}
//	修改
function editbusiness_guide() {
	var row = $('#dg_business_guide').datagrid('getSelected');
	if (row) {
		$('#dlg_business_guide').dialog('open').dialog('setTitle', '修改广告');
		$('#fm_business_guide').form('clear');
		$('#fm_business_guide').form('load', row);
		//为富文本赋值
		KindEditor.create("textarea[name='content']", {
			allowFileManager : false,
			afterBlur: function(){this.sync();}
		});
		url = '${basepath}bg/update.do';
	} else {
		$.messager.alert('警告', '请选择要编辑的列!', 'error');
	}

}
//	保存
function savebusiness_guide() {
	$('#fm_business_guide').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.status=="1") {
				$('#dlg_business_guide').dialog('close'); // close the dialog
				$('#dg_business_guide').datagrid('reload'); // reload the user data
			} else {
				$.messager.show({
					title : 'Error',
					msg : result
				});
			}
		}
	});
	//alert(2);
}
//删除
function deletebusiness_guide() {
	var row = $('#dg_business_guide').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定要删除此业务指南?', function(r) {
			if (r) {
				$.post('${basepath}bg/delete.do', {
					'id' : row.id
				}, function(result) {
					if (result.status=="1") {
						$('#dg_business_guide').datagrid('reload'); // reload the user data
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
$('#business_guide_image1').click(function() {
	editor.loadPlugin('image', function() {
		editor.plugin.imageDialog({
			showRemote : false,
			imageUrl : KindEditor('#business_guide_url1').val(),
			clickFn : function(url, title, width, height, border, align) {
				KindEditor('#business_guide_url1').val(url);
				$("#fm_business_guide").form('validate');
				editor.hideDialog();
			}
		});
	});
});
</script>
<style type="text/css">
#fm_business_guide {
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