<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用后台管理系统</title>
<link rel="stylesheet" type="text/css" href="h-ui/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/style.css" />
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="js/broken.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
<nav class="breadcrumb">
<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>设备报废管理 <span class="c-gray en">&gt;</span>
新增设备报废 <a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="broken/createBroken.action" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<article class="page-container">
<form class="form form-horizontal" id="form-article-add" action="broken/addBroken.action" name="myform" method="post">
 <div class="row cl"><label class="form-label col-xs-4 col-sm-2">设备</label><div class="formControls col-xs-8 col-sm-9"><span class="select-box"><select name="equipmentid" class="select" id="equipmentid" ><c:forEach items="${equipmentList}" var="equipment"><option value="${equipment.equipmentid}">${equipment.equipname }</option></c:forEach></select></span></div></div>
<div class="row cl"><label class="form-label col-xs-4 col-sm-2">报废原因</label><div class="formControls col-xs-8 col-sm-9"><input type="text" name="reason" class="input-text" id="reason" placeholder="请输入报废原因" /></div></div>
<div class="row cl"><label class="form-label col-xs-4 col-sm-2">处理结果</label><div class="formControls col-xs-8 col-sm-9"><input type="text" name="resultx" class="input-text" id="resultx" placeholder="请输入处理结果" /></div></div>
<div class="row cl"><label class="form-label col-xs-4 col-sm-2">损失</label><div class="formControls col-xs-8 col-sm-9"><input type="text" name="money" class="input-text" id="money" placeholder="请输入损失" /></div></div>
<div class="row cl"><label class="form-label col-xs-4 col-sm-2">日期</label><div class="formControls col-xs-8 col-sm-9"><input type="text" name="addtime" class="input-text" id="addtime" onclick="WdatePicker()" readonly="readonly" placeholder="请输入日期"/></div></div>
<div class="row cl"><label class="form-label col-xs-4 col-sm-2">备注</label><div class="formControls col-xs-8 col-sm-9"><input type="text" name="memo" class="input-text" id="memo" placeholder="请输入备注" /></div></div>

<div class="row cl">
<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
<input type="hidden" id="basepath" value="<%=basePath%>" /><button id="sub" class="btn btn-secondary radius" type="submit">
<i class="Hui-iconfont">&#xe632;</i>提交保存
</button>
<button id="res" class="btn btn-default radius" type="reset">
<i class="Hui-iconfont">&#xe68f;</i>取消重置
</button>
</div>
</div>
</form>
</article>
</body>
</html>

