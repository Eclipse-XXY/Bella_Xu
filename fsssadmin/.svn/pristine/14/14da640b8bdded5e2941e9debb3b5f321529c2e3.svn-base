<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="/jsp/commen/init.jsp"></jsp:include>
</head>
<body>
	<table id="dg_opinion" title="列表" class="easyui-datagrid"
		url="${basepath}opinion/list.do" toolbar="#toolbar_opinion"
		pagination="true" rownumbers="true" fitColumns="true"
		singleSelect="true" data-options="pageSize:50">
		<thead>
			<tr>
				<th field="yx" width="50">邮箱</th>
				<th field="createDate" width="100">时间</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar_opinion">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newMain_opinion()">查看</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="deleteopinion()">删除</a>
	</div>
	<div id="dlg_opinion" class="easyui-dialog"
		style="width: 800px; height: 400px; padding: 10px 20px" closed="true">
		<div class="ftitle">查看用户反馈</div>
		<form enctype="multipart/form-data" id="fm_opinion" method="post" novalidate>
			<div class="fitem">
			<input name="id" type="hidden"/>
			<label>邮箱:</label><input  name="yx" class="easyui-validatebox" /><br>
			<label>时间:</label><input  name="createDate" class="easyui-validatebox" /><br>
			<label>描述:</label><textarea  name="yj" rows="2" cols="50"  /></textarea><br>
		</form>
	</div>

	<script type="text/javascript">
// 		修改资讯
		function newMain_opinion() {
			var row = $('#dg_opinion').datagrid('getSelected');
			if (row) {
				$('#dlg_opinion').dialog('open').dialog('setTitle', '查看用户反馈');
				$('#fm_opinion').form('load', row);
			} else {
				$.messager.alert('警告', '请选择要查看的列!', 'error');
			}
		}
		$('#dlg_opinion').dialog({
		    onClose:function(){
		    },
		    buttons: [ {
		         text: '关闭',
		         iconCls: 'icon-cancel',
		         handler: function () {
		             $('#dlg_opinion').dialog('close');
		         }
		     }]
		});
		//删除
		function deleteopinion() {
			var row = $('#dg_opinion').datagrid('getSelected');
			if (row) {
				$.messager.confirm('Confirm', '确定要删除此用户反馈?', function(r) {
					if (r) {
						$.post('${basepath}opinion/delete.do', {
							'id' : row.id
						}, function(result) {
							if (result.status=="1") {
								$('#dg_opinion').datagrid('reload'); // reload the user data
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
	</script>
<style type="text/css">
#dg_opinion {
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