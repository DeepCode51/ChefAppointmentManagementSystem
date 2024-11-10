$(function() {

$("#cardno").blur(
		function() {
			$("#cardno_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cardno").after("<span id='cardno_msg' style='color: red'>卡号不能为空</span>");
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

$("#courseid").blur(
		function() {
			$("#courseid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#courseid").after("<span id='courseid_msg' style='color: red'>课程不能为空</span>");
			}
	});

$("#money").blur(
		function() {
			$("#money_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#money").after("<span id='money_msg' style='color: red'>费用不能为空</span>");
			}
	});

$("#num").blur(
		function() {
			$("#num_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#num").after("<span id='num_msg' style='color: red'>总次数不能为空</span>");
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
var cardno = $("#cardno").val();
var usersid = $("#usersid").val();
var courseid = $("#courseid").val();
var money = $("#money").val();
var num = $("#num").val();
var memo = $("#memo").val();
$("#cardno_msg").empty();
$("#usersid_msg").empty();
$("#courseid_msg").empty();
$("#money_msg").empty();
$("#num_msg").empty();
$("#memo_msg").empty();
if (cardno == "" || cardno == null) {
	$("#cardno").after("<span id='cardno_msg' style='color: red'>卡号不能为空</span>");
	return false;
}
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
	return false;
}
if (courseid == "" || courseid == null) {
	$("#courseid").after("<span id='courseid_msg' style='color: red'>课程不能为空</span>");
	return false;
}
if (money == "" || money == null) {
	$("#money").after("<span id='money_msg' style='color: red'>费用不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>总次数不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#cardno_msg").empty();
$("#usersid_msg").empty();
$("#courseid_msg").empty();
$("#money_msg").empty();
$("#num_msg").empty();
$("#memo_msg").empty();
});

});
