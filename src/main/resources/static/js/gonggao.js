$(function () {
    $("button[name='gao']").click(function () {
        $.ajax({
            type:"post",
            url:"findgong",
            data:"id="+$(this).val(),
            dataType:"json",
            success:function (data) {
                $("#gong").html("")
                var str = "<th>"+data.affTitle+"</th>\n" +
                    "<th>"+data.affContent+"</th>\n" +
                    "<th>"+data.pubdate+"</th>\n" +
                    " <th>"+data.createdtime+"</th>\n";
                $("#gong").append(str);
            }
        });
    });
});