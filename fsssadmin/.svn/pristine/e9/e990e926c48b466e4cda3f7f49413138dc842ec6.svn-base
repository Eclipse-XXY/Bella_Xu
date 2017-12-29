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
<div id="new_dio">
		<div class="ftitle">编辑新闻资讯</div>
		<form enctype="multipart/form-data" id="fm_news" method="post" >
			
			<div class="fitem">
			<input name="id" type="hidden">
			<input id="method" name="method" type="hidden">
			<label>部署城市:</label>
			<select id="citiesCode" style="width:155px" required="true" class="easyui-combobox"  name="citiesCode" data-options="url:'${basepath}cities/all.do',valueField:'code', textField:'name', panelHeight: 'auto',editable: false"   >
			</select>
			<br>
			<label>标题:</label>
			<input id="title" class="easyui-validatebox" name="title" required="true">
			<br>
			<label>分类:</label> 
			<select name="type" class="easyui-combobox" style="width:155px"   data-options="panelHeight: 'auto',editable: false" required="true"> 
				<option value="1">社保动态</option><!--社保动态  -->
				<option value="2">通知公告</option><!--媒体关注  -->
				<option value="3">办事指南</option><!--视频新闻  -->
				<option value="4">在线访谈</option><!--通知公告 -->
			</select>
			<br>
			<label>视频:</label> <input  name="url" type="text" id="url" readonly="readonly"/><input type="button" id="uploadButton" value="上传视频" /><br>
			<label>内容:</label><textarea name="content" style="height: 50px;width: 100%"></textarea><br>
			</div>
		</form>
		</div>
		
<script type="text/javascript">
if("update" == "${action}"){
	var row = $('#dg_news').datagrid('getSelected');
	if (row) {
		$('#fm_news').form('clear');
		$('#fm_news').form('load', row);
	} 
}
	//为富文本赋值
KindEditor.create("textarea[name='content']", {
	allowFileManager : false,
	afterBlur: function(){this.sync();}
});
var uploadbutton = KindEditor.uploadbutton({
	button : KindEditor('#uploadButton')[0],
	fieldName : 'imgFile',
	url : '${basepath}plugins/kindeditor/upload_json.jsp?dir=media',
	afterUpload : function(data) {
		console.log(data);
		if (data.error === 0) {
			var url = KindEditor.formatUrl(data.url, 'absolute');
			KindEditor('#url').val(url);
		} else {
			alert(data.message);
		}
	},
	afterError : function(str) {
		alert('自定义错误信息: ' + str);
	}
});
uploadbutton.fileBox.change(function(e) {
	uploadbutton.submit();
}); 
//保存
function savenews() {
	var url="";
	if("update" == "${action}"){
		url = "${basepath}news/update.do";
	}
	if("save" == "${action}"){
		url = "${basepath}news/save.do";
	}
	$('#fm_news').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.status=="1") {
				$('#dlg_news').dialog('close'); // close the dialog
				$('#dg_news').datagrid('reload'); // reload the user data
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
		</body>
</html>