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
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>厨艺课程管理 <span class="c-gray en">&gt;</span> 厨艺课程查询 <a
			class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);"
			title="刷新"> <i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="13">厨艺课程查询</th>
				</tr>
				<tr class="text-c">
					<th class="center">课程名称</th>
					<th class="center">课程类型</th>
					<th class="center">厨师</th>
					<th class="center">课时费用</th>
					<th class="center">是否推荐</th>
					<th class="center">是否特价</th>
					<th class="center">上架日期</th>
					<th class="center">点击数</th>
					<th class="center">报名人数</th>
					<th class="center">上课时间</th>
				</tr>
			</thead>
			<c:forEach items="${courseList}" var="course">
				<tr class="text-c">
					<td class="center">${course.coursename}</td>
					<td class="center">${course.catename}</td>
					<td class="center">${course.teachername}</td>
					<td class="center">${course.price}</td>
					<td class="center">${course.recommend}</td>
					<td class="center">${course.special}</td>
					<td class="center">${course.addtime}</td>
					<td class="center">${course.hits}</td>
					<td class="center">${course.num}</td>
					<td class="center">${course.worktime}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="cl pd-5 mt-20"></div>
		<div class="text-c">
			<form action="course/queryCourseByCond.action" name="myform" method="post">
				查询条件： <span class="select-box" style="width: 200px;"><select name="cond" class="select">
						<option value="coursename">按课程名称查询</option>
						<option value="image">按封面查询</option>
						<option value="cateid">按课程类型查询</option>
						<option value="teacherid">按厨师查询</option>
						<option value="price">按课时费用查询</option>
						<option value="recommend">按是否推荐查询</option>
						<option value="special">按是否特价查询</option>
						<option value="addtime">按上架日期查询</option>
						<option value="hits">按点击数查询</option>
						<option value="num">按报名人数查询</option>
						<option value="worktime">按上课时间查询</option>
						<option value="contents">按课程详情查询</option>
				</select></span>&nbsp;&nbsp;关键字<input type="text" name="name" required style="width: 200px" class="input-text" />
				<button type="submit" class="btn btn-success radius">
					<i class="Hui-iconfont">&#xe665;</i> 查询
				</button>
			</form>
		</div>
	</div>
</body>
</html>

