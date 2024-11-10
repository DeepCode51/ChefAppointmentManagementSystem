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

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href=".">首页</a>
			<code> &gt; </code>
			用户中心
			<code> &gt; </code>
			我的课程
		</div>
	</div>
	<div class="blank"></div>

	<div class="blank"></div>
	<div class="block clearfix">

		<div class="AreaL">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox">
						<jsp:include page="usermenu.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>


		<div class="AreaR">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox boxCenterList clearfix" style="_height: 1%;">
						<h5>
							<span>我的课程</span>
						</h5>
						<div class="blank"></div>
						<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
							<tr align="center" bgcolor="#ffffff">
								<td align="center">课程号</td>
								<td align="center">用户</td>
								<td align="center">课程</td>
								<td align="center">费用</td>
								<td align="center">开卡日期</td>
								<td align="center">总次数</td>
								<td align="center">使用次数</td>
								<td align="center">剩余次数</td>
								<td align="center">备注</td>
							</tr>
							<c:forEach items="${cardList}" var="card">
								<tr align="center" bgcolor="#FFFFFF">
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
						<div class="blank5"></div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="blank"></div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
