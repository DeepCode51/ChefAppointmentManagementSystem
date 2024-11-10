$(function () {
    $('#courseid').change(
        function () {
            var courseid = $("#courseid").val();
            var loc = $("#basepath").val();
            var url = loc + "ajax/getCard.action?courseid=" + courseid;
            $.ajax({
                type: "get",
                url: url,
                dataType: "json",
                success: function (json) {
                    var cardid = json.cardid.replace("[", "").replace("]", "").split(",");
                    var cardname = json.cardno.replace("[", "").replace("]", "").split(",");
                    var myOptions = '<option value="">---请选择会员卡---</option>';
                    for (var i = 0; i < cardid.length; i++) {
                        myOptions += '<option value="' + cardid[i] + '">' + cardname[i] + '</option>';
                    }
                    $("#cardid").empty();
                    $("#cardid").html(myOptions);
                },
                error: function () {
                    alert("ajax请求发生错误3");
                }
            });
        });
});