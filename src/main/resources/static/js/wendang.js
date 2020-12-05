$(function () {
    f(1);

    /*点击搜索按钮*/
    $("#sousuo").click(function () {
        f(1)
    })
    /*点击搜索按钮*/
    $("#sousuo2").click(function () {
        g(1)
    })
    /*添加公司文档*/
    $("#addCompanyFile").click(function () {
        //将当前时间转换成yyyymmdd格式
        var mydate = new Date();
        var str = "" + mydate.getFullYear() + "-";
        var mm = mydate.getMonth() + 1
        if (mydate.getMonth() > 9) {
            str += mm + "-";
        } else {
            str += "0" + mm + "-";
        }
        if (mydate.getDate() > 9) {
            str += mydate.getDate();
        } else {
            str += "0" + mydate.getDate();
        }
        $("#yuio").text("doc/txt")
        $("#dangqianshijian").val(str);
        $("#fileKind").val(1)
        $("#modeltitle").text("添加公司文档")

    })
    /*添加个人文档*/
    $("#tianjiagerenwendang").click(function () {
        //将当前时间转换成yyyymmdd格式
        var mydate = new Date();
        var str = "" + mydate.getFullYear() + "-";
        var mm = mydate.getMonth() + 1
        if (mydate.getMonth() > 9) {
            str += mm + "-";
        } else {
            str += "0" + mm + "-";
        }
        if (mydate.getDate() > 9) {
            str += mydate.getDate();
        } else {
            str += "0" + mydate.getDate();
        }

        $("#dangqianshijian").val(str);
        $("#modeltitle").text("添加个人文档")
        $("#yuio").text("doc/txt")
        $("#fileKind").val(4)
    })
    /*添加规章制度*/
    $("#tianjiaguizhangzhidu").click(function () {
        //将当前时间转换成yyyymmdd格式
        var mydate = new Date();
        var str = "" + mydate.getFullYear() + "-";
        var mm = mydate.getMonth() + 1
        if (mydate.getMonth() > 9) {
            str += mm + "-";
        } else {
            str += "0" + mm + "-";
        }
        if (mydate.getDate() > 9) {
            str += mydate.getDate();
        } else {
            str += "0" + mydate.getDate();
        }
        $("#yuio").text("txt")
        $("#dangqianshijian").val(str);
        $("#fileKind").val(2)
        $("#modeltitle").text("添加规章制度")
    })
    /*添加文件夹*/
    $("#wenjianjia").click(function () {
        var mydate = new Date();
        var str = "" + mydate.getFullYear() + "-";
        var mm = mydate.getMonth() + 1
        if (mydate.getMonth() > 9) {
            str += mm + "-";
        } else {
            str += "0" + mm + "-";
        }
        if (mydate.getDate() > 9) {
            str += mydate.getDate();
        } else {
            str += "0" + mydate.getDate();
        }
        $("#dangqianshijian2").val(str);
        $("#userslist").children().remove()
        $.ajax({
            url: 'User',
            type: 'get',
            dataType: 'json',
            success: function (data) {
                var str = ''
                $.each(data, function (x, y) {
                    str += "<option value='" + y.id + "'>" + y.realName + "</option>"
                })
                $("#userslist").append(str)

            }
        })

    })
})


/*添加文件夹*/
function addfold() {
    $.ajax({
        url: 'Folder',
        type: 'post',
        data: {
            foldName: $("#foldName").val(),
            createdTime: $("#dangqianshijian2").val(),
            foldMsg: $("#foldMsg").val(),
            createdBy: $("#createdBy2").val(),
            foldKind: $("#foldKind").val(),
            user: $("#userslist").val()
        },
        dataType: 'text',
        success: function (data) {
            alert(data)
        }
    })

}

/*查看规章制度*/
function look(id) {
    $.ajax({
        url: 'System/read',
        type: 'post',
        data: {
            id: id
        },
        dataType: 'json',
        success: function (data) {
            $("#systemtitle").text(data["system"].fileName)
            $("#lookmodel").text(data["text"])

        }
    })
}

/*删除公司文档*/
function del1(id) {
    var yon = confirm("确定要删除吗？")
    if (yon == true) {
        $.ajax({
            url: 'Word',
            type: 'delete',
            data: {id: id},
            dataType: 'text',
            success: function (data) {
                if (data == 1) {
                    alert("删除成功！")
                } else {
                    alert("删除失败！")
                }
                f(1)
            }
        })
    }
}

/*删除规章制度*/
function del2(id) {
    var yon = confirm("确定要删除" + id + "吗？")
    if (yon == true) {
        $.ajax({
            url: 'Word',
            type: 'delete',
            data: {id: id},
            dataType: 'text',
            success: function (data) {
                if (data == 1) {
                    alert("删除成功！")
                } else {
                    alert("删除失败！")
                }
                g(1)
            }
        })
    }


}

/*上一页*/
function prev(num) {
    if (num == 1) {
        var page = $("#dangqianye").val();
        if (page == 1) {
            f($("#zongyeshu").val())
        } else {
            f(page - 1)
        }
    } else if (num == 2) {
        var page = $("#dangqianye2").val();
        if (page == 1) {
            g($("#zongyeshu2").val())
        } else {
            g(page - 1)
        }
    }


}

/*下一页*/
function next(num) {
    if (num == 1) {
        var page = $("#dangqianye").val();
        if (page == $("#zongyeshu").val()) {
            f(1)
        } else {
            f(page + 1)
        }
    } else if (num == 2) {
        var page = $("#dangqianye2").val();
        if (page == $("#zongyeshu2").val()) {
            f(1)
        } else {
            f(page + 1)
        }
    }
}

/*刷新规章制度*/
function g(page) {
    $.ajax({
        url: 'System',
        type: 'put',
        data: {
            wName: $("#SystemName").val(),
            createBy: $("#SystemByBy").val(),
            starDate: $("#startDate1").val(),
            endDate: $("#endDate1").val(),
            pageIndex: page
        },
        dataType: 'json',
        success: function (data) {
            $("#tr2").siblings().remove()
            $("[haha='ui']").remove();

            var str = "";
            var str2 = "";
            $.each(data["list"], function (x, y) {
                str += "<tr><td><a onclick='look(" + y.id + ")'  data-toggle='modal' data-target='.bd-example-modal-lg2' style='color: blue!important;cursor: pointer!important;'>" + y.fileName + "</a></td><td>" + y.users.realName + "</td><td>" + y.fileMsg + "</td><td>" + y.createdTime + "</td><td  class='text-right'>" +
                    "<a href='" + y.fileRp + "' download='" + y.fileRp + "' style='color: blue!important;'> 下载</a>&nbsp;&nbsp;&nbsp;" +
                    /*"</button><button type='button' class='btn btn-success btn-floating'><i class='ti-check-box'></i></button>" +*/
                    "<button type='button' class='btn btn-danger btn-floating' onclick='del2(" + y.id + ")'><i class='ti-trash'></i></button></td></tr>";
            })
            for (var i = 1; i <= data["pageCount"]; i++) {
                str2 += "<li class='page-item' haha='ui'><a class='page-link' href='#' onclick='g(" + i + ")'>" + i + "</a></li>";
            }
            if (data["ZC"] < 4) {
                $("#tianjiaguizhangzhidu").remove()
            }
            $("#zongyeshu2").val(data["pageCount"])
            $("#dangqianye2").val(data["pageIndex"]);
            $("#shangyiye2").after(str2);
            $("#SystemTable").append(str);

        }
    })
}

/*刷新公司文档*/
function f(page) {
    $.ajax({
        url: 'Word',
        type: 'put',
        data: {
            wName: $("#wName").val(),
            createBy: $("#createBy").val(),
            starDate: $("#starDate").val(),
            endDate: $("#endDate").val(),
            pageIndex: page
        },
        dataType: 'json',
        success: function (data) {
            $("#tr1").siblings().remove()
            $("[haha='ui']").remove();
            var str = "";
            var str2 = "";
            $.each(data["list"], function (x, y) {
                str += "<tr><td>" + y.fileName + "</td><td>" + y.dictionary.valueName + "</td><td>" + y.users.realName + "</td><td>" + y.fileMsg + "</td><td>" + y.createdTime + "</td><td  class='text-right'>" +
                    "<a href='" + y.fileRp + "' download='" + y.fileRp + "' style='color: blue!important;'> 下载</a>&nbsp;&nbsp;&nbsp;" +
                    /*"</button><button type='button' class='btn btn-success btn-floating'><i class='ti-check-box'></i></button>" +*/
                    "<button type='button' class='btn btn-danger btn-floating' onclick='del1(" + y.id + ")'><i class='ti-trash'></i></button></td></tr>";
            })
            for (var i = 1; i <= data["pageCount"]; i++) {
                str2 += "<li class='page-item' haha='ui'><a class='page-link' href='#' onclick='f(" + i + ")'>" + i + "</a></li>";
            }
            if (data["ZC"] < 4) {
                $("#addCompanyFile").remove()
            }
            $("#zongyeshu").val(data["pageCount"])
            $("#dangqianye").val(data["pageIndex"]);
            $("#shangyiye").after(str2);
            $("#CompanyFileTable").append(str);
        }
    })
}

/*刷新部门文档*/
function y(page) {
    $.ajax({
        url: 'Part',
        type: 'post',
        dataType: 'json',
        success: function (data) {
            $("#deptfold").siblings().remove()
            $("#deptfile").children().remove();
            var str = "";
            var str2 = "";
            $.each(data["wordlist1"], function (x, y) {
                str2 += "<p>" + y.fileName + "</p>"
            })
            $("#deptfile").append(str2)
            $.each(data["foldlist"], function (x, y) {
                str += "<div class='accordion-row'><a href='#' class='accordion-header'><span>" + y.foldName + "</span>" +
                    "<i class='accordion-status-icon close fa fa-plus'></i><i class='accordion-status-icon open fa fa-minus'></i>" +
                    "</a><div class='accordion-body'>"
                if (data["user"] == y.user) {

                    $.each(data["wordlist2"], function (j, k) {

                        str += "<p>" + k.fileName + "</p>"
                    })
                }


                str += "</div></div>"
            })
            if (data["ZC"] < 2) {
                $("#wenjianjia").remove()
            }
            $("#foldtab").append(str)
        }
    })

}

/*添加文档*/
function add() {
    var form = document.querySelector("#tijiaobaocun");
    var formdata = new FormData(form);
    $.ajax({
        url: 'Word',
        dataType: 'text',
        async: true,
        data: formdata,
        processData: false,// 不加会报错
        contentType: false,//避免对发送到服务器上数据类型重复操作
        type: 'POST',
        success: function (data) {
            alert(data)
        },
        error: function () {
            alert("请求出错！")
        }
    })
}