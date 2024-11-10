<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>欢迎使用网站后台管理系统</title>
<link rel="stylesheet" type="text/css" href="h-ui/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/style.css" />
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui.admin/js/H-ui.admin.js"></script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>课程卡管理 <span class="c-gray en">&gt;</span> 课程卡查询 <a
			class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);"
			title="刷新"> <i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="10">课程卡查询</th>
				</tr>
				<tr class="text-c">
					<th class="center">卡号</th>
					<th class="center">用户</th>
					<th class="center">课程</th>
					<th class="center">费用</th>
					<th class="center">开卡日期</th>
					<th class="center">总次数</th>
					<th class="center">使用次数</th>
					<th class="center">剩余次数</th>
					<th class="center">备注</th>
				</tr>
			</thead>
			<c:forEach items="${cardList}" var="card">
				<tr class="text-c">
					<td class="center">${card.cardno}</td>
					<td class="center">${card.username}</td>
					<td class="center">${card.coursename}</td>
					<td class="center">${card.money}</td>
					<td class="center">${card.addtime}</td>
					<td class="center">${card.num}</td>
					<td class="center">${card.usenum}</td>
					<td class="center">${card.surnum}</td>
					<td class="center">${card.memo}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="cl pd-5 mt-20"></div>
		<div class="text-c">
			<form action="card/queryCardByCond.action" name="myform" method="post">
				查询条件： <span class="select-box" style="width: 200px;"><select name="cond" class="select">
						<option value="cardno">按卡号查询</option>
						<option value="usersid">按用户查询</option>
						<option value="courseid">按课程查询</option>
						<option value="money">按费用查询</option>
						<option value="addtime">按开卡日期查询</option>
						<option value="num">按总次数查询</option>
						<option value="usenum">按使用次数查询</option>
						<option value="surnum">按剩余次数查询</option>
						<option value="memo">按备注查询</option>
				</select></span>&nbsp;&nbsp;关键字<input type="text" name="name" required style="width: 200px" class="input-text" />
				<button type="submit" class="btn btn-success radius">
					<i class="Hui-iconfont">&#xe665;</i> 查询
				</button>
			</form>
		</div>
	</div>
</body>
</html>

