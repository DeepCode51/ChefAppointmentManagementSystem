<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>厨艺课程管理 <span class="c-gray en">&gt;</span> 厨艺课程列表 <a
			class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);"
			title="刷新"> <i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="13">厨艺课程列表</th>
				</tr>
				<tr class="text-c">
					<th>课程名称</th>
					<th>课程类型</th>
					<th>厨师</th>
					<th>课时费用</th>
					<th>是否推荐</th>
					<th>是否特价</th>
					<th>上架日期</th>
					<th>点击数</th>
					<th>报名人数</th>
					<th>上课时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${courseList}" var="course">
				<tr class="text-c">
					<td>${course.coursename}</td>
					<td>${course.catename}</td>
					<td>${course.teachername}</td>
					<td>${course.price}</td>
					<td>${course.recommend}</td>
					<td>${course.special}</td>
					<td>${course.addtime}</td>
					<td>${course.hits}</td>
					<td>${course.num}</td>
					<td>${course.worktime}</td>
					<td><a href="course/getCourseById.action?id=${course.courseid}"><i class="Hui-iconfont">&#xe6df;</i></a>&nbsp;&nbsp;<a
						href="course/deleteCourse.action?id=${course.courseid}" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i
							class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="r">${html } </span>
		</div>
	</div>
</body>
</html>

