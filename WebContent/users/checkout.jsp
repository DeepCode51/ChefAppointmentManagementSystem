<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="<%=basePath%>">首页</a>
			<code> &gt; </code>
			预约私教
		</div>
	</div>
	<div class="blank"></div>
	<div class="block table">
		<form action="index/addorder.action" method="post" name="theForm" id="theForm" onsubmit="return checkConsignee(this)">
			<div class="flowBox">
				<h6>
					<span>预约私教</span>
				</h6>
				<table width="99%" align="center" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
					<tr>
						<td align="right" bgcolor="#ffffff">预约单号:</td>
						<td bgcolor="#ffffff" colspan="2">${ordercode }<input name="ordercode" type="hidden" id="ordercode" value="${ordercode }" /></td>
					</tr>
					<tr>
						<td align="right" bgcolor="#ffffff">预约厨师:</td>
						<td bgcolor="#ffffff" colspan="2">${teacher.teachername }<input name="teacherid" type="hidden" id="teacherid"
							value="${teacher.teacherid }" /></td>
					</tr>
					<tr>
						<td width="18%" align="right" bgcolor="#ffffff">预约日期:</td>
						<td bgcolor="#ffffff" colspan="2"><input name="orderdate" type="text" class="inputBg" id="orderdate" onclick="WdatePicker()"
							readonly="readonly" /> (必填)</td>
					</tr>
					<tr>
						<td align="right" bgcolor="#ffffff">时间段:</td>
						<td bgcolor="#ffffff" colspan="2">
						<input type="radio" name="sectionx" id="sectionx" value="10:30~12:30"  />10:30~12:30&nbsp; 
						<input type="radio" name="sectionx" id="sectionx" value="14:30~16:30" />14:30~16:30 &nbsp;
						<input type="radio" name="sectionx" id="sectionx" value="16:30~18:30" />16:30~18:30 &nbsp;
						<input type="radio" name="sectionx" id="sectionx" value="18:30~20:30" checked/>18:30~20:30 &nbsp;
						</td>
					</tr>
					<tr>
						<td align="right" bgcolor="#ffffff">备注:</td>
						<td bgcolor="#ffffff" colspan="2"><input name="memo" type="text" class="inputBg" id="memo" /></td>
					</tr>
					<tr>
						<td colspan="4" align="center" bgcolor="#ffffff"><input type="submit" class="bnt_blue_2" value="确定" /></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
