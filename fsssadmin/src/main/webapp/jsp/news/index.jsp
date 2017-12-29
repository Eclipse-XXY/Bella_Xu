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
	<table id="dg_news" title="列表" class="easyui-datagrid"
		url="${basepath}news/list.do" toolbar="#toolbar_news"
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
	<div id="toolbar_news">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="news_add()">添加新闻资讯</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editnews()">修改</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="deletenews()">删除</a>
	</div>
	<div id="dlg_news" class="easyui-dialog"
		style="width: 800px; height: 400px; padding: 10px 20px" closed="true" >
	</div>
<script type="text/javascript">

//添加
function news_add() {
	$('#dlg_news').dialog({
	    title: '新建新闻资讯',
	    closed: false,
	    cache: false,
	    href: '${basepath}news/addhtml.do?action=save',
	    modal: true,
	    buttons: [ {
	         text: '关闭',
	         iconCls: 'icon-cancel',
	         handler: function () {
	             $('#dlg_news').dialog('close');
	         }
	     },{
	         text: '保存',
	         iconCls: 'icon-ok',
	         handler: function () {
	        	 savenews();
	         }
	     }]
	});
}
//修改
function editnews() {
	var row = $('#dg_news').datagrid('getSelected');
	if (row) {
		$('#dlg_news').dialog({
		    title: '修改新闻资讯',
		    closed: false,
		    cache: false,
		    href: '${basepath}news/addhtml.do?action=update',
		    modal: true,
		    buttons: [ {
		         text: '关闭',
		         iconCls: 'icon-cancel',
		         handler: function () {
		             $('#dlg_news').dialog('close');
		         }
		     },{
		         text: '保存',
		         iconCls: 'icon-ok',
		         handler: function () {
		        	 savenews();
		         }
		     }]
		});
	} else {
		$.messager.alert('警告', '请选择要编辑的列!', 'error');
	}

}
function deletenews(){
	var row = $('#dg_news').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定要删除此用户?', function(r) {
			if (r) {
				$.post('${basepath}/news/delete.do', {
					'id' : row.id
				}, function(result) {
					if (result.status=="1") {
						$('#dg_news').datagrid('reload'); // reload the user data
					} else {
						$.messager.show({ // show error message
							title : 'Error',
							msg : result.errorMsg
						});
					}
				}, 'json');
			}
		});
	}else{
		$.messager.alert('警告', '请选择要删除的记录!', 'error');
	}
}
</script>
<style type="text/css">
#fm_news {
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