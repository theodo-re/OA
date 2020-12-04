$(function () {
trash();
})


/*刷新回收站*/
function trash() {
    $("#trashtitle").siblings().remove()
    $.ajax({
        url:'trash1',
        type:'get',
        dataType:'json',
        success:function (data) {
            str="";
            $.each(data,function (x,y) {
                str+="<tr><td><i class='fa fa-chrome'>"+y.fileName+"</i></td><td>"+y.fileType+"</td>\n" +
                    "<td>"+y.createdTime+"</td><td class='text-right'>" +
                    "<button type='button' class='btn btn-success btn-uppercase' onclick='huan("+y.id+")'>还原</button>\n" +
                    "<button type='button' class='btn btn-danger btn-uppercase' onclick='del2("+y.id+")'>删除</button></td></tr>"
            })
            $("#trashtitle").after(str)


        }
    })

}
function del2(id) {
    $.ajax({
        url:'trash',
        type:'delete',
        data:{id:id},
        dataType:'text',
        success:function (data) {
            alert(data)
            trash()
        }
    })
}

function huan(id) {
    $.ajax({
        url:'trash',
        type:'put',
        data:{id:id},
        data:{id:id},
        dataType:'text',
        success:function (data) {
            alert(data)
            trash()
        }
    })
}