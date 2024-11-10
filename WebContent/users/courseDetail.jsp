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
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href=".">首页</a>
			<code> &gt; </code>
			<a href="index/course.action">全部课程</a>
			<code> &gt; </code>
			${course.coursename }
		</div>
	</div>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="AreaL">
			<div id="category_tree">
				<div class="tit">所有课程分类</div>
				<dl class="clearfix" style="overflow: hidden;">
					<c:forEach items="${cateList}" var="cate">
						<div class="box1 cate" id="cate">
							<h1 style="border-top: none">
								<a href="index/cate.action?id=${cate.cateid }" class="  f_l">${cate.catename }</a>
							</h1>
						</div>
						<div style="clear: both"></div>
					</c:forEach>
				</dl>
			</div>
			<div class="blank"></div>
			<div class="box" id='history_div'>
				<div class="box_1">
					<h3>
						<span>热门课程</span>
					</h3>
					<div class="boxCenterList clearfix" id='history_list'>
						<c:forEach items="${hotList}" var="course">
							<ul class="clearfix">
								<li class="goodsimg"><a href="index/courseDetail.action?id=${course.courseid }" target="_blank"><img src="${course.image }"
										alt="${course.coursename }" class="B_blue" /> </a></li>
								<li><a href="index/courseDetail.action?id=${course.courseid }" target="_blank" title="${course.coursename }">${course.coursename }</a></li>
							</ul>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>

		<div class="AreaR">
			<div id="goodsInfo" class="clearfix">
				<div class="imgInfo">
					<img src="${course.image}" alt="${course.coursename }" width="360px;" height="360px" />
					<div class="blank5"></div>
					<div class="blank"></div>
				</div>
				<div class="textInfo">
					<h1 class="clearfix">${course.coursename }</h1>
					<ul class="ul2 clearfix">
						<li class="clearfix" style="width: 100%">
							<dd>
								<strong>价格：</strong><font class="shop" id="ECS_SHOPPRICE">￥${course.price }元</font>
							</dd>
						</li>
						<li class="clearfix">
							<dd>
								<strong>课程类型：</strong><a href="index/cate.action?id=${course.cateid }"><font color="red">${course.catename }</font></a>
							</dd>
						</li>
						<li class="clearfix">
							<dd>
								<strong>厨师：</strong><a href="index/teacherDetail.action?id=${course.teacherid }"><font color="red">${course.teachername }</font></a>
							</dd>
						</li>
						<li class="clearfix">
							<dd>
								<strong>日程：</strong>${course.worktime}
							</dd>
						</li>
						<li class="clearfix">
							<dd>
								<strong>上架日期：</strong>${course.addtime}
							</dd>
						</li>
						<li class="clearfix">
							<dd>
								<strong>点击数：</strong>${course.hits}
							</dd>
						</li>
						<li class="clearfix">
							<dd>
								<strong>报名人数：</strong>${course.num}
							</dd>
						</li>
					</ul>
				</div>
			</div>
			<div class="blank"></div>


			<div class="box">
				<div style="padding: 0 0px;">
					<div id="com_b" class="history clearfix">
						<h2>课程描述</h2>
					</div>
				</div>
				<div class="box_1">
					<div id="com_h">
						<blockquote>${course.contents}</blockquote>
					</div>
				</div>
			</div>
			<div class="blank"></div>
			
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
