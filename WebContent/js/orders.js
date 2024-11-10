$(function() {

$("#ordercode").blur(
		function() {
			$("#ordercode_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#ordercode").after("<span id='ordercode_msg' style='color: red'>预约单号不能为空</span>");
			}
	});

$("#usersid").blur(
		function() {
			$("#usersid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
			}
	});

$("#teacherid").blur(
		function() {
			$("#teacherid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#teacherid").after("<span id='teacherid_msg' style='color: red'>厨师不能为空</span>");
			}
	});

$("#orderdate").blur(
		function() {
			$("#orderdate_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#orderdate").after("<span id='orderdate_msg' style='color: red'>预约日期不能为空</span>");
			}
	});

$("#sectionx").blur(
		function() {
			$("#sectionx_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#sectionx").after("<span id='sectionx_msg' style='color: red'>时间段不能为空</span>");
			}
	});

$("#memo").blur(
		function() {
			$("#memo_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
			}
	});







$('#sub').click(function(){
var ordercode = $("#ordercode").val();
var usersid = $("#usersid").val();
var teacherid = $("#teacherid").val();
var orderdate = $("#orderdate").val();
var sectionx = $("#sectionx").val();
var memo = $("#memo").val();
$("#ordercode_msg").empty();
$("#usersid_msg").empty();
$("#teacherid_msg").empty();
$("#orderdate_msg").empty();
$("#sectionx_msg").empty();
$("#memo_msg").empty();
if (ordercode == "" || ordercode == null) {
	$("#ordercode").after("<span id='ordercode_msg' style='color: red'>预约单号不能为空</span>");
	return false;
}
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
	return false;
}
if (teacherid == "" || teacherid == null) {
	$("#teacherid").after("<span id='teacherid_msg' style='color: red'>厨师不能为空</span>");
	return false;
}
if (orderdate == "" || orderdate == null) {
	$("#orderdate").after("<span id='orderdate_msg' style='color: red'>预约日期不能为空</span>");
	return false;
}
if (sectionx == "" || sectionx == null) {
	$("#sectionx").after("<span id='sectionx_msg' style='color: red'>时间段不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#ordercode_msg").empty();
$("#usersid_msg").empty();
$("#teacherid_msg").empty();
$("#orderdate_msg").empty();
$("#sectionx_msg").empty();
$("#memo_msg").empty();
});

});
