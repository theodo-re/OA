$(function () {
    $("button[name='cha']").click(function () {
        $.ajax({
            type:"post",
            url:"find",
            data:"a="+$(this).val(),
            dataType:"json",
            success:function (data) {
                $("#th").html("")
                var str = "<th>"+data.tName+"</th>\n" +
                    " <th>"+data.dic.valueName+"</th>\n" +
                    " <th>"+data.auditName+"</th>\n" +
                    " <th>"+data.createName+"</th>\n" +
                    " <th>"+data.createdtime+"</th>";
                $("#th").append(str);
            }
        })
    });
    $("button[name='shen']").click(function () {
        $.ajax({
            type:"post",
            url:"finddic",
            data:"a="+$(this).val(),
            dataType:"json",
            success:function (data) {
                $("#shenid").val(data.task.id);
                $("#zhuangName").val(data.task.tName)
                $("#statusId").val(data.task.dic.valueName)
                $("#auditId").val(data.task.auditName)
                var str="<option>请选择</option>";
                $.each(data.list,function (index,value){
                    str+="<option value="+value.valueId+">"+value.valueName+"</option>";
                })
                $("select[name=valueName]").append(str);
            }
        })
    });
    $("#btn").click(function () {
        $("#from").submit();
    });
});