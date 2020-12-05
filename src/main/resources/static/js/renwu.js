$(function () {
    $(document).on("click","button[name='cha']",function () {
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
    $(document).on("click","button[name='shen']",function () {
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
    $(document).on("click","button[name='renfen']",function () {
        var index = $(this).val();
        var count=$("#yeshu").val();
        if(index<=0){
            alert("页数不能为0");
            index=0;
        }
        if(index>count){
            alert("页数最大为"+count);
            index=count;
        }
        $.post("renwufen","pageIndex="+index,function (data) {
            var str="";
            $("#ren").siblings().remove();
            $.each(data.list,function () {
                if(this.statusId==1){
                    str+="<tr></tr><td>"+this.tName+"</td>"+
                        "<td>"+this.dic.valueName+"</td>"+
                        " <td><button type=\'button\' class=\'btn btn-primary m-r-5\' data-toggle=\'modal\'\n" +
                        " data-target=\'#exampleModalshen\' name=\'shen\' th:value=\'"+this.id+"\'>\n" +
                        "审核\n</button>&nbsp;" +
                        "<button type=\'button\' class=\'btn btn-primary m-r-5\' data-toggle=\'modal\'\n" +
                        " data-target=\'#exampleModal\' name=\'cha\' value=\'"+this.id+"\'>\n" +
                        "  查看\n</button></td></tr>";
                }else{
                    str+="<tr><td>"+this.tName+"</td>"+
                        "<td>"+this.dic.valueName+"</td>"+
                        " <td><button type=\'button\' class=\'btn btn-primary m-r-5\' data-toggle=\'modal\'\n" +
                        " data-target=\'#exampleModal\' name=\'cha\' value=\'"+this.id+"\'>\n" +
                        "  查看\n</button></td></tr>";
                }
            });
            str+="<tr>\n<td>\n" +
                "<input type='hidden' id='yeshu' name='yeshu' value='"+data.totalPageCount+"'/>"+
                "<ul class=\'pagination justify-content-end\'>\n" +
                "   <li class=\'page-item disabled\'>\n" +
                "      <button type=\'button\' class=\'btn btn-primary m-r-5\' data-toggle=\'modal\'\n" +
                "          name=\'renfen\' value='"+(data.currentPageNo-1)+"'>\n上一页\n</button> "+
                "   </li>\n" +
                "   <li class=\'page-item\'>\n" +
                "       <button type=\'button\' class=\'btn btn-primary m-r-5\' data-toggle=\'modal\'\n" +
                "           name='renfen' value='"+(data.currentPageNo+1)+"' >\n下一页\n</button> "+
                "   </li>\n" +
                " </ul>\n</td>\n</tr>";
            $("#ren").after(str);
        });
    });
});