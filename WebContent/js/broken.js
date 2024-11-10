$(function() {

$("#equipmentid").blur(
		function() {
			$("#equipmentid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#equipmentid").after("<span id='equipmentid_msg' style='color: red'>设备不能为空</span>");
			}
	});

$("#reason").blur(
		function() {
			$("#reason_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#reason").after("<span id='reason_msg' style='color: red'>报废原因不能为空</span>");
			}
	});

$("#resultx").blur(
		function() {
			$("#resultx_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#resultx").after("<span id='resultx_msg' style='color: red'>处理结果不能为空</span>");
			}
	});

$("#money").blur(
		function() {
			$("#money_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#money").after("<span id='money_msg' style='color: red'>损失不能为空</span>");
			}
	});

$("#addtime").blur(
		function() {
			$("#addtime_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#addtime").after("<span id='addtime_msg' style='color: red'>日期不能为空</span>");
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
var equipmentid = $("#equipmentid").val();
var reason = $("#reason").val();
var resultx = $("#resultx").val();
var money = $("#money").val();
var addtime = $("#addtime").val();
var memo = $("#memo").val();
$("#equipmentid_msg").empty();
$("#reason_msg").empty();
$("#resultx_msg").empty();
$("#money_msg").empty();
$("#addtime_msg").empty();
$("#memo_msg").empty();
if (equipmentid == "" || equipmentid == null) {
	$("#equipmentid").after("<span id='equipmentid_msg' style='color: red'>设备不能为空</span>");
	return false;
}
if (reason == "" || reason == null) {
	$("#reason").after("<span id='reason_msg' style='color: red'>报废原因不能为空</span>");
	return false;
}
if (resultx == "" || resultx == null) {
	$("#resultx").after("<span id='resultx_msg' style='color: red'>处理结果不能为空</span>");
	return false;
}
if (money == "" || money == null) {
	$("#money").after("<span id='money_msg' style='color: red'>损失不能为空</span>");
	return false;
}
if (addtime == "" || addtime == null) {
	$("#addtime").after("<span id='addtime_msg' style='color: red'>日期不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#equipmentid_msg").empty();
$("#reason_msg").empty();
$("#resultx_msg").empty();
$("#money_msg").empty();
$("#addtime_msg").empty();
$("#memo_msg").empty();
});

});
