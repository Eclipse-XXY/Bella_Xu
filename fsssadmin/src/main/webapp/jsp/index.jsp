<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>欢迎佛山i社保后台管理系统</title>

<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<jsp:include page="/jsp/commen/init.jsp"></jsp:include>
<script type="text/javascript">
	function tabs(title, url) {
		if ($('#tab').tabs('exists', title)) {
			$('#tab').tabs('select', title);
		} else {
			$('#tab').tabs('add', {
				border : false,
				title : title,
				href : url,
				closable : true
			});
		}
	}
	function exit() {
		$.messager.confirm('Confirm', '确定要退出吗?', function(r) {
			if (r) {
				window.location.href = "ts_user.do?method=exit&t="
						+ Math.random();
			}
		});
	}
//	编辑个人资料
	function edit() {
			$('#dlg1').dialog('open').dialog('setTitle', '修改操作员');
			
			url = 'ts_user.do?method=updateTsUser';
	}
//  修改后保存
	function saveUser_Main() {
		  var pw1 = document.getElementById("userpwd").value;
          var pw2 = document.getElementById("reuserpwd").value;
          var pw3 = document.getElementById("reuserpwd");
          if(pw1 == pw2) {
             	$('#fm1').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
// 					var result = eval('(' + result + ')');
					if (result == "ok") {
						$('#dlg1').dialog('close'); // close the dialog
					} else {
						$.messager.show({
							title : 'Error',
							msg : result.errorMsg
						});
					}
				}
			});
          }
          else {
             $.messager.alert('警告', '两次输入密码不同!', 'error');
             pw3.focus();
          }
	}
</script>
</head>
<body id="body" class="easyui-layout">

	<div class="easyui-layout" style="width: 100%; height: 100%;">
		<div data-options="region:'north'" style="height: 50px">
			<div style="float: left; padding: 5px;">
				<font size="4">管理系统平台</font>
			</div>
			<div style="float: right;">
				<strong style="color: red;">${sessionScope.user.realname}
					欢迎光临!</strong> <a onclick="edit()" class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-edit'">编辑个人资料</a> <a
					onclick="exit()" class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-back'">退出</a>
			</div>

		</div>
<!-- 		<div data-options="region:'south',split:true" style="height: 50px;"></div> -->
		<div data-options="region:'west',split:true" title="导航菜单"
			style="width: 150px;">
			<div class="easyui-accordion"
				data-options="fit : true,border : false" id="divAcc">
				
				<%-- 				<c:if test="${fn:contains(sessionScope.user.access, '1')}"> --%>
				<!-- 
				<div title="订单管理" id="access1">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('订单管理','jsp/order/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">订单管理</a></li>
					</ul>
				</div>
				<div title="用户统计" id="access1">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('用户统计','jsp/order/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">用户统计</a></li>
					</ul>
				</div>
				<%-- 				</c:if> --%>
				<%-- 				<c:if test="${fn:contains(sessionScope.user.access, '2')}"> --%>
				<div title="药店管理" id="access3">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('药店管理','jsp/storedrug/drugshop.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">药店管理</a></li>
					</ul>
				</div>
				<div title="药品管理" id="access3">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('药品管理','jsp/drug.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">药品管理</a></li>
					</ul>
				</div>
				<%-- 				</c:if> --%>
				<%-- 				<c:if test="${fn:contains(sessionScope.user.access, '3')}"> --%>
				<div title="财务管理" id="access5">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('财务管理','jsp/tsuser/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">财务管理</a></li>
					</ul>
				</div>
				<div title="报表统计" id="access5">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('报表统计','jsp/tsuser/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">报表统计</a></li>
					</ul>
				</div>
				<div title="资讯内容管理" id="access5">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('资讯内容管理','jsp/news/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">资讯内容管理</a></li>
					<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('资讯类别管理','jsp/news/newstype.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">资讯类别管理</a></li>
					
					</ul>
				</div>
				<div title="佛山社保资讯" id="access5">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('佛山社保资讯','jsp/fssbnews/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">佛山社保资讯</a></li>
					</ul>
				</div>
				<div title="升级包管理" id="access5">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('升级包管理','jsp/appupdate/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">升级包管理</a></li>
					</ul>
				</div>
				<div title="优惠券管理" id="access5">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('优惠券管理','jsp/coupons/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">优惠券管理</a></li>
					</ul>
				</div>
				<div title="WAP首页管理" id="access5">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('wap首页管理','jsp/wap/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">wap首页管理</a></li>
					</ul>
				</div>
				<%-- 				</c:if> --%>
				<%-- 				<c:if test="${fn:contains(sessionScope.user.access, '4')}"> --%>
				 
				 <div title="操作员及权限" id="access4">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('人员管理','jsp/tsuser/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">人员管理</a></li>
					</ul>
				</div>
				-->
				<div title="消息中心管理" id="access4">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('消息中心管理','jsp/msg_center/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">消息中心管理</a></li>
					</ul>
				</div>
				<div title="部署城市管理" id="access4">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('部署城市管理','jsp/deployment_cities/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">部署城市管理</a></li>
					</ul>
				</div>
				<div title="首页功能管理" id="access4">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('首页功能管理','jsp/home_menu/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">首页功能管理</a></li>
					</ul>
				</div>
				<div title="广告管理" id="access4">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('广告管理','jsp/ad/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">广告管理</a></li>
					</ul>
				</div>
				<div title="业务指南管理" id="access4">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('业务指南管理','jsp/business_guide/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">业务指南管理</a></li>
					</ul>
				</div>
				<div title="新闻资讯" id="access4">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('新闻资讯','jsp/news/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">新闻资讯</a></li>
					</ul>
				</div>
				<div title="用户反馈" id="access4">
					<ul style="margin: 0px; padding: 0px;">
						<li
							style="line-height: 160%; text-decoration: none; list-style-type: none;"
							onmouseover="this.style.backgroundColor='#E0ECFF'"
							onmouseout="this.style.backgroundColor='white'"><a
							onclick="tabs('用户反馈','jsp/opinion/index.jsp')"
							onmouseover="this.style.color='red'"
							onmouseout="this.style.color='black'"
							style="cursor: pointer; display: block; color: black; text-decoration: none; border-bottom: 1px dotted #D8D8D8; padding: 3px; padding-left: 5px;">用户反馈</a></li>
					</ul>
				</div>
				<%-- 				</c:if> --%>
			</div>
		</div>
		<div data-options="region:'center',title:'工作区',iconCls:'icon-ok'">
			<div id="tab" class="easyui-tabs"
				data-options="fit:true,border:false">
				<div title="首页" style="padding: 20px; overflow: hidden;">
					<h1>欢迎使用管理系统平台</h1>
				</div>
			</div>
		</div>
		<div id="dlg1" class="easyui-dialog"
		style="width: 400px; height: 400px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons1">
		<div class="ftitle">编辑个人资料</div>
		<form id="fm1" method="post" novalidate>
			<div class="fitem">
				<label>员工编号:</label> 
					<input name="id" class="easyui-validatebox" required="true" value="${sessionScope.user.id}"><br/> 
				<label>姓 名:</label>
					<input name="realname" class="easyui-validatebox" required="true" value="${sessionScope.user.realname}"><br/>
				<label>手机号:</label> 
					<input name="mobile" class="easyui-validatebox" required="true" value="${sessionScope.user.mobile}"><br/>
				<label>所属分店:</label> 
					<input name="ydid" class="easyui-validatebox" required="true" value="${sessionScope.user.ydid}"><br/>
				<label>请输入密码:</label> 
					<input name="userpwd" id="userpwd" class="easyui-validatebox" required="true" value="${sessionScope.user.userpwd}"><br/>
				<label>再次输入密码:</label> 
					<input name="reuserpwd" id="reuserpwd" class="easyui-validatebox" required="true"  value="${sessionScope.user.userpwd}"><br/>
				
			</div>
		</form>
	</div>
	<div id="dlg-buttons1">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveUser_Main()">Save</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg1').dialog('close')">Cancel</a>
	</div>
</body>
</html>