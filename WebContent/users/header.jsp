<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="themes/xecmoban_haier2015/style.css" rel="stylesheet" type="text/css" />


<div class="ng-toolbar">
	<div class="ng-toolbar-con block">
		<div class="ng-toolbar-left">&nbsp;</div>
		<div class="ng-toolbar-right">
			<div class="ng-bar-node reg-bar-node" id="reg-bar-node" style="display: block;">
				<c:if test="${sessionScope.userid == null }">
					欢迎光临本站！
				<s></s>&nbsp;
				<span> <a style="color: #FF6766;" href="index/preLogin.action">[用户登录]</a> <a style="color: #FF6766;" href="index/preReg.action">[用户注册]</a>
					</span>

				</c:if>
				<c:if test="${sessionScope.userid != null }">
				你好 <b>${sessionScope.username }</b>
					<span> <a style="color: #FF6766;" href="index/usercenter.action">[用户中心]</a> <a style="color: #FF6766;" href="index/exit.action">[退出系统]
					</a>
					</span>
				</c:if>
			</div>
		</div>
	</div>
</div>
<div class="ng-header">
	<div class="ng-header-con block">
		<div class="ng-header-box">
			<a href="index/index.action" class="logo" style="font-size: 32px;
    font-weight: bold;
    color: #005aa9;
    width: 250px;
    padding-top: 18px;"> 厨师预约系统
			</a>
			<div class="ng-search">
				<div class="g-search">
					<form id="searchForm" name="searchForm" method="post" action="index/query.action" style="padding-top: 12px;">
						<div class="search-keyword-box">
							<input name="keywords" type="text" id="keywords" value="" class="search-keyword" />
						</div>
						<input type="submit" value="搜索" class="btn-search" style="cursor: pointer;" />
						<div class="clear"></div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="ng-nav-bar">
	<div class="block">
		<div class="ng-nav-index">
			<ul class="ng-nav">
				<li><a href="index/index.action">首页</a></li>
				<li><a href="index/article.action">新闻公告</a></li>
				<li><a href="index/recommend.action">推荐课程</a></li>
				<li><a href="index/special.action">特价课程</a></li>
				<li><a href="index/course.action">全部课程</a></li>
				<li><a href="index/teacher.action">厨艺厨师</a></li>
				<li><a href="index/equipment.action">厨艺器材</a></li>
				<li><a href="index/bbs.action">留言交流</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="blank"></div>

