<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html lang="zh_CN">
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
			<a href="index/equipment.action">全部厨艺器材</a>
			<code> &gt; </code>
			${equipment.equipname }
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
					<img src="${equipment.image}" alt="${equipment.equipname }" width="360px;" height="360px" />
					<div class="blank5"></div>
					<div class="blank"></div>
				</div>
				<div class="textInfo">
					<h1 class="clearfix">${equipment.equipname }</h1>
					<ul class="ul2 clearfix">
						<li class="clearfix" style="width: 100%">
							<dd>
								<strong>设备编号：</strong>${equipment.eno}
							</dd>
						</li>
						<li class="clearfix" style="width: 100%">
							<dd>
								<strong>生产厂商：</strong>${equipment.productor}
							</dd>
						</li>
						<li class="clearfix" style="width: 100%">
							<dd>
								<strong>作用：</strong>${equipment.useinfo}
							</dd>
						</li>
						<li class="clearfix" style="width: 100%">
							<dd>
								<strong>采购日期：</strong>${equipment.buydate}
							</dd>
						</li>
					</ul>
				</div>
			</div>
			<div class="blank"></div>


			<div class="box">
				<div style="padding: 0 0px;">
					<div id="com_b" class="history clearfix">
						<h2>厨艺器材描述</h2>
					</div>
				</div>
				<div class="box_1">
					<div id="com_h">
						<blockquote>${equipment.contents}</blockquote>
					</div>
				</div>
			</div>
			<div class="blank"></div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
