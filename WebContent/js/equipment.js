$(function() {

$("#eno").blur(
		function() {
			$("#eno_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#eno").after("<span id='eno_msg' style='color: red'>设备名称不能为空</span>");
			}
	});

$("#equipname").blur(
		function() {
			$("#equipname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#equipname").after("<span id='equipname_msg' style='color: red'>设备名称不能为空</span>");
			}
	});

$("#productor").blur(
		function() {
			$("#productor_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#productor").after("<span id='productor_msg' style='color: red'>生产厂商不能为空</span>");
			}
	});

$("#image").blur(
		function() {
			$("#image_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#image").after("<span id='image_msg' style='color: red'>图片不能为空</span>");
			}
	});

$("#useinfo").blur(
		function() {
			$("#useinfo_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#useinfo").after("<span id='useinfo_msg' style='color: red'>作用不能为空</span>");
			}
	});

$("#buydate").blur(
		function() {
			$("#buydate_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#buydate").after("<span id='buydate_msg' style='color: red'>采购日期不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>采购金额不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>设备介绍不能为空</span>");
			}
	});







$('#sub').click(function(){
var eno = $("#eno").val();
var equipname = $("#equipname").val();
var productor = $("#productor").val();
var image = $("#image").val();
var useinfo = $("#useinfo").val();
var buydate = $("#buydate").val();
var price = $("#price").val();
var contents = $("#contents").val();
$("#eno_msg").empty();
$("#equipname_msg").empty();
$("#productor_msg").empty();
$("#image_msg").empty();
$("#useinfo_msg").empty();
$("#buydate_msg").empty();
$("#price_msg").empty();
$("#contents_msg").empty();
if (eno == "" || eno == null) {
	$("#eno").after("<span id='eno_msg' style='color: red'>设备名称不能为空</span>");
	return false;
}
if (equipname == "" || equipname == null) {
	$("#equipname").after("<span id='equipname_msg' style='color: red'>设备名称不能为空</span>");
	return false;
}
if (productor == "" || productor == null) {
	$("#productor").after("<span id='productor_msg' style='color: red'>生产厂商不能为空</span>");
	return false;
}
if (image == "" || image == null) {
	$("#image").after("<span id='image_msg' style='color: red'>图片不能为空</span>");
	return false;
}
if (useinfo == "" || useinfo == null) {
	$("#useinfo").after("<span id='useinfo_msg' style='color: red'>作用不能为空</span>");
	return false;
}
if (buydate == "" || buydate == null) {
	$("#buydate").after("<span id='buydate_msg' style='color: red'>采购日期不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>采购金额不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>设备介绍不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#eno_msg").empty();
$("#equipname_msg").empty();
$("#productor_msg").empty();
$("#image_msg").empty();
$("#useinfo_msg").empty();
$("#buydate_msg").empty();
$("#price_msg").empty();
$("#contents_msg").empty();
});

});
