$(function () {
    $("button[name='bian1']").click(function () {
        $.ajax({
            type:"post",
            url:"findbiancha",
            data:"id="+$(this).val(),
            dataType:"json",
            success:function (data) {
                $("#bian").html("")
                var str = "<th>"+data.mTitle+"</th>\n" +
                    "<th>"+data.mContent+"</th>\n" +
                    "<th>"+data.user.realName+"</th>\n" +
                    " <th>"+data.createdtime+"</th>\n";
                $("#bian").append(str);
            }
        });
    });
    $("button[name='bian2']").click(function () {
        $.ajax({
            type:"post",
            url:"updatebian",
            data:"id="+$(this).val(),
            dataType:"json",
            success:function (data) {
                $("#mTitle").val(data.mTitle)
                $("#mContent").val(data.mContent)
                $("#xiuid").val(data.id)
            }
        });
    });
    $(document).on("click","#btnxiu",function () {
        var a = $("#from1").serialize();
        $.post("biantijiao",a,function (data) {
            alert(data)
        },"text")
    })
    $("#addbtn").click(function () {
        var a = $("#addfrom1").serialize();
        $.post("addmemo",a,function (data) {
            alert(data);
            window.location.reload();
        },"text")
    });
    $(document).on("click","#bian3",function () {
        var a = $(this).val();
        $.post("delmemo","id="+a,function (data) {
            alert(data);
            window.location.reload();
        },"text")
    });
});