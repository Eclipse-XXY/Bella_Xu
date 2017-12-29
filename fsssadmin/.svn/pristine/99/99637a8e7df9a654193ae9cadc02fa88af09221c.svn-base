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
	<table id="dg_deloyment_cities" title="列表" class="easyui-datagrid"
		url="${basepath}cities/list.do" toolbar="#toolbar_deloyment_cities"
		pagination="true" rownumbers="true" fitColumns="true"
		singleSelect="true" data-options="pageSize:50">
		<thead>
			<tr>
				<th field="citiesName" width="50">城市</th>
				<th field="citiesCode" width="100">城市代码</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar_deloyment_cities">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newMain_cities()">添加</a>
		<!-- 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editMain_cities()">修改</a>
		-->
	</div>
	<div id="dlg_deloyment_cities" class="easyui-dialog"
		style="width: 800px; height: 400px; padding: 10px 20px" closed="true" buttons="#dlg-deloyment_cities-buttons" >
		<div class="ftitle">部署城市编辑</div>
		<form enctype="multipart/form-data" id="fm_deloyment_cities" method="post" novalidate>
			<div class="fitem">
			<input name="id" type="hidden"/>
			<label>城市:</label><input  name="citiesName" class="easyui-validatebox" required="true"/><br>
			<label>城市代码:</label><input  name="citiesCode" class="easyui-validatebox" required="true"/><br>
		</form>
	</div>
	<div id="dlg-deloyment_cities-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg_deloyment_cities').dialog('close')">关闭</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="savedrug_store()">保存</a> 
	</div>
	<script type="text/javascript">
		var url;
// 		打开添加dialog
		function newMain_cities() {
			$('#dlg_deloyment_cities').dialog('open').dialog('setTitle', '添加城市');
			$('#fm_deloyment_cities').form('clear');
// 			清空内容
			url = '${basepath}cities/save.do';
		}
// 		修改资讯
		function editMain_cities() {
			var row = $('#dg_deloyment_cities').datagrid('getSelected');
			if (row) {
				$('#dlg_deloyment_cities').dialog('open').dialog('setTitle', '修改APP');
				KindEditor.create("textarea[name='content']", {
					allowFileManager : true,
					afterBlur: function(){this.sync();}
				});
				
				
				$('#fm_deloyment_cities').form('load', row);
				url = '${basepath}cities/update.do';
			} else {
				$.messager.alert('警告', '请选择要编辑的列!', 'error');
			}
		}
// 		新增资讯，保存
		function savedrug_store() {
			$('#fm_deloyment_cities').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					var result = eval('(' + result + ')');
					if (result.status == "1") {
						alert("保存成功！");
						$('#fm_deloyment_cities').form('clear');
						$('#dlg_deloyment_cities').dialog('close'); // close the dialog
						$('#dg_deloyment_cities').datagrid('reload'); // reload the user data
					} else {
						$.messager.show({
						title : 'Error',
						msg : result
					});
					}
				}
			});
		}
		
	</script>
<style type="text/css">
#fm {
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