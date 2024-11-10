<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>
<link href="themes/xecmoban_haier2015/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="themes/xecmoban_haier2015/js/index.js"></script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>


	<div style="clear: both"></div>

	<div id="idTransformView" style="height: 425px; overflow: hidden; position: relative;">
		<ul class="slider" id="idSlider">
			<li><img src="pic/11.png" /></li>
			<li><img src="pic/22.png" /></li>
			<li><img src="pic/33.png" /></li>
			<li><img src="pic/44.png" /></li>
		</ul>
		<ul class="num" id="idNum">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>

	<div class="blank5"></div>
	<div class="block clearfix">
		<div class="goodsBox_1">
			<!-- 循环开始  -->
			<div class="xm-box">
				<div class="title">
					<span class="floor-icon"><i></i><b>111</b> </span>
					<h2>厨师信息</h2>
					<a class="more" href="index/teacher.action">更多</a>
				</div>
				<div id="show_new_area" class="clearfix xm-boxs">
					<!-- 循环开始  -->
					<c:forEach items="${teacherList}" var="teacher">
						<div class="goodsItem goodsItems">
							<a href="index/teacherDetail.action?id=${teacher.teacherid }"><img src="${teacher.image }" alt="${teacher.teachername }"
								class="goodsimg" /> </a> <br />
							<p class="f1">
								<a href="index/teacherDetail.action?id=${teacher.teacherid }" title="${teacher.teachername }">${teacher.teachername }</a>
							</p>
						</div>
					</c:forEach>
					<!-- 循环结束  -->
				</div>
			</div>
			<div class="blank"></div>
			<c:forEach items="${frontList}" var="cate" varStatus="status">
				<div class="xm-box">
					<div class="title">
						<span class="floor-icon"><i></i><b></b> </span>
						<h2>${cate.catename}</h2>
						<a class="more" href="index/cate.action?id=${cate.cateid}">更多</a>
					</div>
					<div id="show_new_area" class="clearfix xm-boxs">
						<!-- 循环开始  -->
						<c:forEach items="${cate.courseList}" var="course">
							<div class="goodsItem goodsItems">
								<a href="index/courseDetail.action?id=${course.courseid }"><img src="${course.image }" alt="${course.coursename }"
									class="goodsimg" /> </a> <br />
								<p class="f1">
									<a href="index/courseDetail.action?id=${course.courseid }" title="${course.coursename }">${course.coursename }</a>
								</p>
							</div>
						</c:forEach>
						<!-- 循环结束  -->
					</div>
				</div>
				<div class="blank"></div>
			</c:forEach>
			<!-- 循环结束  -->
			<div class="blank"></div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
