$(function() {

$("#coursename").blur(
		function() {
			$("#coursename_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#coursename").after("<span id='coursename_msg' style='color: red'>课程名称不能为空</span>");
			}
	});

$("#image").blur(
		function() {
			$("#image_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#image").after("<span id='image_msg' style='color: red'>封面不能为空</span>");
			}
	});

$("#cateid").blur(
		function() {
			$("#cateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cateid").after("<span id='cateid_msg' style='color: red'>课程类型不能为空</span>");
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

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>课时费用不能为空</span>");
			}
	});

$("#worktime").blur(
		function() {
			$("#worktime_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#worktime").after("<span id='worktime_msg' style='color: red'>上课时间不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>课程详情不能为空</span>");
			}
	});







$('#sub').click(function(){
var coursename = $("#coursename").val();
var image = $("#image").val();
var cateid = $("#cateid").val();
var teacherid = $("#teacherid").val();
var price = $("#price").val();
var worktime = $("#worktime").val();
var contents = $("#contents").val();
$("#coursename_msg").empty();
$("#image_msg").empty();
$("#cateid_msg").empty();
$("#teacherid_msg").empty();
$("#price_msg").empty();
$("#worktime_msg").empty();
$("#contents_msg").empty();
if (coursename == "" || coursename == null) {
	$("#coursename").after("<span id='coursename_msg' style='color: red'>课程名称不能为空</span>");
	return false;
}
if (image == "" || image == null) {
	$("#image").after("<span id='image_msg' style='color: red'>封面不能为空</span>");
	return false;
}
if (cateid == "" || cateid == null) {
	$("#cateid").after("<span id='cateid_msg' style='color: red'>课程类型不能为空</span>");
	return false;
}
if (teacherid == "" || teacherid == null) {
	$("#teacherid").after("<span id='teacherid_msg' style='color: red'>厨师不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>课时费用不能为空</span>");
	return false;
}
if (worktime == "" || worktime == null) {
	$("#worktime").after("<span id='worktime_msg' style='color: red'>上课时间不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>课程详情不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#coursename_msg").empty();
$("#image_msg").empty();
$("#cateid_msg").empty();
$("#teacherid_msg").empty();
$("#price_msg").empty();
$("#worktime_msg").empty();
$("#contents_msg").empty();
});

});
