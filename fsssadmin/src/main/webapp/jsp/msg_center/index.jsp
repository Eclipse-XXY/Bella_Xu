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
	<div>
		时间: <input id="datestart" class="easyui-datebox" style="width:100px">
		--- <input id="dateend" class="easyui-datebox" style="width:100px">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="reload()">查询</a>
	</div>
	<table id="list_msg" title="列表" class="easyui-datagrid"
		url="${basepath}msg/query.do" toolbar="#toolbar_msgcenter"
		pagination="true" rownumbers="true" fitColumns="true"
		singleSelect="true">
		<thead>
			<tr>
				<th field="msgid" width="20">消息编号</th>
				<th field="sendtime" width="20">发送时间</th>
				<th field="title" width="10">标题</th>
				<!-- <th data-options="field:'_operate3',formatter:formatOper3" width="50">优惠金额</th> -->
				<th data-options='field:"platform",formatter:mbpt' width="15">目标平台</th>
				<th data-options='field:"userid",formatter:mbyh' width="15">目标用户</th>
				<th data-options='field:"msgstate",formatter:sfts' width="10">是否推送</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar_msgcenter">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="addMsg()">新增消息</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="queryMsg()">查看</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="deleteMsg()">删除</a>
	</div>
	<div id="dlg_msg" class="easyui-dialog"
		style="width: 800px; height: 400px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<label>标题:</label> <span id="title"></span><br> 
		<label>消息状态:</label> <span id="msgstate"></span><br> 
		<label>消息种类:</label> <span id="msgstyle"></span><br> 
		<label>目标平台:</label> <span id="platform"></span><br> 
		<div id="div2"> <label>目标用户:</label> <span id="userid"></span><br> </div>
		<label>创建时间:</label> <span id="createtime"></span><br> 
		<label>发送时间:</label> <span id="sendtime"></span><br> 
		<label>通知声音:</label> <span id="sound"></span><br>
		<div id="div1"> <label>路径:</label> <span id="path"></span><br> </div>
		<label>内容:</label> <span id="descr"></span><br>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlg_msg').dialog('close')">关闭</a>
	</div>
	<div id="dlg_msg2" class="easyui-dialog"
		style="width: 800px; height: 400px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons2">
		<div class="ftitle">消息编辑</div>
		<form enctype="multipart/form-data" id="fm_msg" method="post">
			<div class="fitem">
				<label>标题:</label> <input name="title" class="easyui-validatebox"/><br> 
				<label>内容:</label> <textarea name="descr" rows="2" cols="50" /></textarea><br> 
				<label>目标平台:</label> 
					<select name="platform" style="width: 155px" data-options="panelHeight: 'auto',editable: false">
						<option value="0" >全部</option>
						<option value="1" >ios</option>
						<option value="2" >android</option>
					</select><br> 
				<label>目标用户:</label> 
					<select id="mbyh2" name="sendtarget" style="width: 155px" data-options="panelHeight: 'auto',editable: false" onchange="showuserid()">
						<option value="0">全部</option>
						<option value="1">指定用户</option>
					</select><br>
					<div id="zdyh" style="display: none;">
						手动输入<input id="sdsr" type="radio" name="srfs"/>
						<span id="sdsrk"  style="display: none;">
							<input name = "userid" type="text" style="width: 155px"/>请输入一个身份证号码<br>
						</span>
						文件上传<input id="wjsc" type="radio" name="srfs" /><br>
					</div>
					<div id="xzwj" style="display: none;">
						<input id="fileToUpload" type="file" name="file"> 
						<span>请每行编辑一个身份证号码，".txt"格式并且左侧无空格</span>
					</div>
				<label>发送时间:</label> 
					<select id="ljfs"  style="width: 155px" data-options="panelHeight: 'auto',editable: false" onchange="st()">
						<option value="0">立即发送</option>
						<option value="1">定时发送</option>
					</select>
					<!-- 时间框 -->
					<span id="sjk"  style="width: 155px; display:none;">
						<input id="sdt" name="sendtime" type="text" class="easyui-datetimebox">
					</span><br> 
				<label>页面跳转:</label> 
					<select id="selectt" style="width: 155px" data-options="panelHeight: 'auto',editable: false" onchange=tz()>
						<option>跳转</option>
						<option>不跳转</option>
					</select><br>
					<div id="tz" style="display: none;">
						链接:<input id="ljj"  type="radio" name="tzz" /> 
						<input id="lj" name="path" type="text" style="width: 155px; display: none;" /><br>
						指定页面:<input id="zdd" type="radio" name="path" /> 
						<select id="zdym" name="path" style="width: 155px; display: none;"
							data-options="panelHeight: 'auto',editable: false">
							<option value="https://www.baidu.com/">指定页面1:百度</option>
							<option value="https://www.taobao.com/">指定页面2:淘宝</option>
						</select>
					</div>
					<div id="bbtz" style="display: none;">
						请选择:<select id="btz" name="path" style="width: 155px"
							data-options="panelHeight: 'auto',editable: false">
							<option value="https://www.taobao.com">普通模板</option>
							<option value="https://www.taobao.com">医院模板</option>
							<option value="https://www.taobao.com">乐惠民模板</option>
						</select>
					</div>
				<label>是否极光推送:</label> 
					<select id="sendfast" name="jpush" style="width: 155px" data-options="panelHeight: 'auto',editable: false" onchange=sendd()>
						<option value="1">否</option>
						<option value="0">是</option>
					</select><br>
					<div id="sendfasttime" style="display: none;">
					离线消息保留时长: 
					<select name="retentiontime" style="width: 155px">
						<option value="86400">默认(1天)</option>
						<option value="0">不保留</option>
						<option value="60">1分钟</option>
						<option value="600">10分钟</option>
						<option value="3600">1小时</option>
						<option value="10800">3小时</option>
						<option value="43200">12小时</option>
						<option value="129600">3天</option>
						<option value="864000">10天</option>
					</select><br> 
					通知声音: 
					<input type="radio" name="sound" value="0" name="tzsy" />无
					<input type="radio" name="sound" value="1" name="tzsy" />默认 <br>
					</div>
			</div>
		</form>
	</div>
	<div id="dlg-buttons2">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlg_msg2').dialog('close')">关闭</a> <a
			href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveMsg()">保存</a>
	</div>
	<script type="text/javascript">
	
	//按日期查询
	function reload() {
		var start =	$("#datestart").datebox('getValue');
		var end = $("#dateend").datebox('getValue');
		if(start == null || start==""){
			alert("开始时间输入为空！");
			return;
		}else if(end == null || end==""){
			alert("结束时间输入为空！");
			return;
		}else if(start>end){
			alert("日期选择错误！");
			return;
		}
		//清空
		$('#list_msg').datagrid('loadData', { total: 0, rows: [] });  
		//加参数并重新加载表格
		$('#list_msg').datagrid('reload', {
			start: start,
			end: end,
		});
	} 
function st(){
	var sel=$("#ljfs option:checked").text();
	if(sel=='定时发送'){
		$("#sjk").show();
	}else if(sel=='立即发送'){
		$("#sjk").hide();
	}
};
function sendd(){
	var sd=$("#sendfast option:checked").text();
	if(sd=='否'){
		$("#sendfasttime").hide();
	}else if(sd=='是'){
		$("#sendfasttime").show();
	}
};
function tz(){
	var tztext=$("#selectt option:checked").text();
	if(tztext=='跳转'){
		$("#tz").show();
		$("#bbtz").hide();
	}else if(tztext=='不跳转'){
		$("#bbtz").show();
		$("#tz").hide();
	}
};
//$("#test option:selected"); 获取下拉列表的值
function showuserid(){
	var zdyh=$("#mbyh2 option:checked").text();
	if(zdyh=='指定用户'){
		$("#zdyh").show();
		$("#xzwj").hide();
	}else{
		$("#zdyh").hide();
		$("#sdsrk").hide();
		$("#xzwj").hide();
	}
};
$(function(){
	$("#sdsr").click(function(){
		$("#sdsrk").show();
		$("#xzwj").hide();
	});
	$("#wjsc").click(function(){
		$("#sdsrk").hide();
		$("#xzwj").show();
	});
	$("#zdd").click(function(){
		$("#lj").hide();
		$("#zdym").show();
	});
	$("#ljj").click(function(){
		$("#zdym").hide();
		$("#lj").show();
	});
});
//添加
function addMsg() {
	$('#dlg_msg2').dialog('open').dialog('setTitle', '消息编辑');
	$('#fm_msg').form('clear');
	url = '${basepath}msg/save.do';
};
//保存消息
function saveMsg() {
	$('#fm_msg').form('submit', {
		url : url,
		onSubmit : function() {
			var v = $(this).form('validate');
			return v;
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.state=="1") {
				$('#dlg_msg2').dialog('close'); // close the dialog
				$('#list_msg').datagrid('reload'); // reload the user data
				alert("推送成功！")
			} else {
				$.messager.show({
					title : 'Error',
					msg : result
				});
			}
		}
	});
};

// 目标平台默认值设置 0：  1：
function mbpt(value, row, index) {
	var platform = row.platform;
	var text = "";
	if(platform==0){
		text = "全部"; 
	}else if(platform==1){
		text = "IOS"; 
	}else{
		text = "Android"; 
	}
	return text;
};
//目标用户默认值设置 0：  1：
function mbyh(value, row, index) {
	var userid = row.userid;
	var text = "";
	if(userid=="" || userid==null){
		text = "所有用户"; 
	}else{
		text = value; 
	}
	return text;
};
//是否推送默认值设置 0：  1：
function sfts(value, row, index) {
	var msgstate = row.msgstate;
	return msgstate == 1?"消息已推送":"消息未推送";
};
//	查询消息
function queryMsg() {
	var row = $('#list_msg').datagrid('getSelected');
	$("#title").text(row.title);
	row.msgstate == 1?$("#msgstate").text("已推送"):$("#msgstate").text("未推送");
	if(row.msgstyle == 0){
		$("#msgstyle").text("i社保通知");
	}else if(row.msgstyle == 1){
		$("#msgstyle").text("医院消息");
	}
	if(row.platform == 0){
		$("#platform").text("全部");
	}else if(row.platform == 1){
		$("#platform").text("ios");
	}else if(row.platform == 2){
		$("#platform").text("android");
	}
	if(row.userid == "" || row.userid == null){
		$("#userid").text("全部");
	}else{
		$("#userid").text(row.userid);
	} 
	if(row.sound == 0){
		$("#sound").text("无");
	}else if(row.sound == 1){
		$("#sound").text("默认");
	}
	$("#createtime").text(row.createtime);
	$("#sendtime").text(row.sendtime);
	
	$("#descr").text(row.descr);
	if(row.path == null || row.path == ""){
		$("#div1").hide();
	}else{
		$("#path").text(row.path);
	}
	$('#dlg_msg').dialog('open').dialog('setTitle', '消息详情');
};
//删除
function deleteMsg() {
	var row = $('#list_msg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定要删除此条消息?', function(r) {
			if (r) {
				$.post('${basepath}msg/delete.do', {
					'msgid' : row.msgid
				}, function(result) {
					if (result.state=="1") {
						$('#list_msg').datagrid('reload'); // reload the user data
					} else {
						$.messager.show({ // show error message
							title : 'Error',
							msg : result.errorMsg
						});
					}
				}, 'json');
			};
		});
	};
};
</script>
<style type="text/css">
#fm_msg {
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