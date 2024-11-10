<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String role = (String) session.getAttribute("role");
	if ("管理员".equals(role)) {
%>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">

		<dl id="menu-admin">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>管理员信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="admin/createAdmin.action" data-title="新增管理员" href="javascript:void(0)">新增管理员信息</a></li>
					<li><a data-href="admin/getAllAdmin.action" data-title="管理员列表" href="javascript:void(0)">管理员信息列表</a></li>
					<li><a data-href="admin/queryAdminByCond.action" data-title="管理员查询" href="javascript:void(0)">管理员信息查询</a></li>
					<li><a data-href="admin/prePwd.action" data-title="修改密码" href="javascript:void(0)">修改密码</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>厨艺厨师信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="teacher/createTeacher.action" data-title="新增厨艺厨师" href="javascript:void(0)">新增厨艺厨师信息</a></li>
					<li><a data-href="teacher/getAllTeacher.action" data-title="厨艺厨师列表" href="javascript:void(0)">厨艺厨师信息列表</a></li>
					<li><a data-href="teacher/queryTeacherByCond.action" data-title="厨艺厨师查询" href="javascript:void(0)">厨艺厨师信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu-member">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>用户信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="users/getAllUsers.action" data-title="用户列表" href="javascript:void(0)">用户信息列表</a></li>
					<li><a data-href="users/queryUsersByCond.action" data-title="用户查询" href="javascript:void(0)">用户信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>新闻公告信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="article/createArticle.action" data-title="新增新闻公告" href="javascript:void(0)">新增新闻公告信息</a></li>
					<li><a data-href="article/getAllArticle.action" data-title="新闻公告列表" href="javascript:void(0)">新闻公告信息列表</a></li>
					<li><a data-href="article/queryArticleByCond.action" data-title="新闻公告查询" href="javascript:void(0)">新闻公告信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>课程类型信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="cate/createCate.action" data-title="新增课程类型" href="javascript:void(0)">新增课程类型信息</a></li>
					<li><a data-href="cate/getAllCate.action" data-title="课程类型列表" href="javascript:void(0)">课程类型信息列表</a></li>
					<li><a data-href="cate/queryCateByCond.action" data-title="课程类型查询" href="javascript:void(0)">课程类型信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>厨艺课程信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="course/createCourse.action" data-title="新增厨艺课程" href="javascript:void(0)">新增厨艺课程信息</a></li>
					<li><a data-href="course/getAllCourse.action" data-title="厨艺课程列表" href="javascript:void(0)">厨艺课程信息列表</a></li>
					<li><a data-href="course/queryCourseByCond.action" data-title="厨艺课程查询" href="javascript:void(0)">厨艺课程信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>课程卡信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="card/createCard.action" data-title="新增课程卡" href="javascript:void(0)">新增课程卡信息</a></li>
					<li><a data-href="card/getAllCard.action" data-title="课程卡列表" href="javascript:void(0)">课程卡信息列表</a></li>
					<li><a data-href="card/queryCardByCond.action" data-title="课程卡查询" href="javascript:void(0)">课程卡信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>上课登记信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="checkin/getAllCheckin.action" data-title="上课登记列表" href="javascript:void(0)">上课登记信息列表</a></li>
					<li><a data-href="checkin/queryCheckinByCond.action" data-title="上课登记查询" href="javascript:void(0)">上课登记信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>私教预约信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="orders/getAllOrders.action" data-title="私教预约列表" href="javascript:void(0)">私教预约信息列表</a></li>
					<li><a data-href="orders/queryOrdersByCond.action" data-title="私教预约查询" href="javascript:void(0)">私教预约信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>预约评价信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="topic/getAllTopic.action" data-title="预约评价列表" href="javascript:void(0)">预约评价信息列表</a></li>
					<li><a data-href="topic/queryTopicByCond.action" data-title="预约评价查询" href="javascript:void(0)">预约评价信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>厨艺设备信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="equipment/createEquipment.action" data-title="新增厨艺设备" href="javascript:void(0)">新增厨艺设备信息</a></li>
					<li><a data-href="equipment/getAllEquipment.action" data-title="厨艺设备列表" href="javascript:void(0)">厨艺设备信息列表</a></li>
					<li><a data-href="equipment/queryEquipmentByCond.action" data-title="厨艺设备查询" href="javascript:void(0)">厨艺设备信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>设备维护信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="repair/createRepair.action" data-title="新增设备维护" href="javascript:void(0)">新增设备维护信息</a></li>
					<li><a data-href="repair/getAllRepair.action" data-title="设备维护列表" href="javascript:void(0)">设备维护信息列表</a></li>
					<li><a data-href="repair/queryRepairByCond.action" data-title="设备维护查询" href="javascript:void(0)">设备维护信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>设备报废信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="broken/createBroken.action" data-title="新增设备报废" href="javascript:void(0)">新增设备报废信息</a></li>
					<li><a data-href="broken/getAllBroken.action" data-title="设备报废列表" href="javascript:void(0)">设备报废信息列表</a></li>
					<li><a data-href="broken/queryBrokenByCond.action" data-title="设备报废查询" href="javascript:void(0)">设备报废信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>意见反馈信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="complains/getAllComplains.action" data-title="意见反馈列表" href="javascript:void(0)">意见反馈信息列表</a></li>
					<li><a data-href="complains/queryComplainsByCond.action" data-title="意见反馈查询" href="javascript:void(0)">意见反馈信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>留言交流信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="bbs/getAllBbs.action" data-title="留言交流列表" href="javascript:void(0)">留言交流信息列表</a></li>
					<li><a data-href="bbs/queryBbsByCond.action" data-title="留言交流查询" href="javascript:void(0)">留言交流信息查询</a></li>
					<li><a data-href="rebbs/getAllRebbs.action" data-title="留言回复列表" href="javascript:void(0)">留言回复信息列表</a></li>
					<li><a data-href="rebbs/queryRebbsByCond.action" data-title="留言回复查询" href="javascript:void(0)">留言回复信息查询</a></li>
				</ul>
			</dd>
		</dl>

	</div>
</aside>
<%
	} else {
%>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>厨师信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="teacher/userinfo.action" data-title="个人信息" href="javascript:void(0)">个人信息</a></li>
					<li><a data-href="teacher/prePwd.action" data-title="修改密码" href="javascript:void(0)">修改密码</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>课程信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="course/getTeacherCourse.action" data-title="课程列表" href="javascript:void(0)">我的课程信息列表</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>课程报名信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="card/getTeacherCard.action" data-title="课程报名列表" href="javascript:void(0)">我的课程报名信息列表</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>上课登记信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="checkin/createCheckin.action" data-title="新增上课登记" href="javascript:void(0)">新增上课登记信息</a></li>
					<li><a data-href="checkin/getTeacherCheckin.action" data-title="上课登记列表" href="javascript:void(0)">我的上课登记信息列表</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>私教预约信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="orders/getTeacherOrders.action" data-title="私教预约列表" href="javascript:void(0)">私教预约信息列表</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>预约评价信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="topic/getTeacherTopic.action" data-title="预约评价列表" href="javascript:void(0)">预约评价信息列表</a></li>
				</ul>
			</dd>
		</dl>

	</div>
</aside>

<%
	}
%>

