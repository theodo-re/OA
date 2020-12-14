//加载用户列表
function userList(pageIndex){
    $("[a='userTr']").remove();
    $("[aa='li']").html("");
    $.post("../liusujun/Users",{'uName':$("#uName").val(),'realName':$("#rName").val(),
        'pageIndex':pageIndex}, function (data){
        $("#uName").val(data.uName)
        $("#realName").val(data.rName)
        var stu='';
        var stu2='';
        var pageIndexView=data.pageIndex;
        $("#pageIndex").val(pageIndexView);
        $("#totalPageCount").val(data.pages.totalPageCount);
        for(var num=1;num<=data.pages.totalPageCount;num++){
            stu2+="<li class='page-item' aa='li'><a class='page-link'  href='#' onclick='userList("+num+")' >"+num+"</a>"
        }
        $("#pageLi").after(stu2);
        $.each(data.userList,function(x,user){
            stu+="<tr a='userTr'>\n" +
                "<td>"+(x+1)+"</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+user.userName+"</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+user.realName+"</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+user.dictionary1.valueName+"</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+user.organization.organName+"</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+user.dictionary2.valueName+"</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\"  class=\"btn btn-success btn-floating\" data-toggle=\"modal\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-target=\"#exampleModal3\" value='"+user.id+"' cc='updateuser' >\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"ti-check-box\"></i>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</button>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\" value='"+user.id+"' name='del' class=\"btn btn-danger btn-floating\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"ti-trash\"></i>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</button>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>"
        })
        $("#Userth").after(stu);
    },"json")
    Organization();
    /* Dept();*/
    Role();
    Pro();
}
function prev() {
    var pageIndex=$("#pageIndex").val()
    var j=parseInt(pageIndex)
    if(j==1){
        alert("已经是第一页了！")
    }else{
        userList(j-1);
    }

}
function next() {
    var pageIndex=$("#pageIndex").val()
    var totalPageCount=$("#totalPageCount").val()
    var j=parseInt(pageIndex)
    var i=parseInt(totalPageCount)
    if(j==i){
        alert("已经是最后一页了！")
    }else{
        userList(j+1);
    }
}
//加载角色列表
function roleList(pageIndex){
    $("[a='roleTr']").html("");
    $("[bb='li']").html("");
    $.post("../liusujun/roleList",{'pageIndex':pageIndex},function(data){
        var stu='';
        var stu2='';
        $("#rolePageIndex").val(data.pageIndex);
        $("#roleTotalPageCount").val(data.pages.totalPageCount);
        for(var num=1;num<=data.pages.totalPageCount;num++){
            stu2+="<li class='page-item' bb='li'><a class='page-link'  href='#' onclick='roleList("+num+")' >"+num+"</a>"
        }
        $("#roleLi").after(stu2)
        $.each(data.DictionaryList,function(x,role){
            stu+=" <tr a='roleTr'>\n" +
                "                                    <td>"+(x+1)+"</td>\n" +
                "                                    <td>"+role.valueId+"</td>\n" +
                "                                    <td>"+role.valueName+"</td>\n" +
                "                                    <td>\n" +
                "                                        <button type=\"button\" class=\"btn btn-success btn-floating\" data-toggle=\"modal\"\n" +
                "                                                data-target=\"#exampleModal4\" value='"+role.valueId+"' cc='updateRole'>\n" +
                "                                            <i class=\"ti-check-box\"></i>\n" +
                "                                        </button>\n" +
                "                                        <button type=\"button\"  value='"+role.valueId+"' class=\"btn btn-danger btn-floating\" cc='delRole'>\n" +
                "                                            <i class=\"ti-trash\"></i>\n" +
                "                                        </button>\n" +
                "                                    </td>\n" +
                "                                </tr>"
        })
        $("#roleth").after(stu);
    },"json")
}
//角色列表上一页
function rolePrev() {
    var pageIndex=$("#rolePageIndex").val()
    var j=parseInt(pageIndex)
    if(j==1){
        alert("已经是第一页了！")
    }else{
        roleList(j-1);
    }

}
function roleNext() {
    var pageIndex=$("#rolePageIndex").val()
    var totalPageCount=$("#roleTotalPageCount").val()
    var j=parseInt(pageIndex)
    var i=parseInt(totalPageCount)
    if(j==i){
        alert("已经是最后一页了！")
    }else{
        roleList(j+1);
    }

}
function logList(pageIndex){
    $("[a='logth']").remove();
    $("[bb='logli']").html("");
    $.post("../liusujun/logList",{'realName':$("#yonghuname").val(),
        'logPageIndex':pageIndex,'startDate':$("#startDate").val(),'endDate':$("#endDate").val()},function(data){
        $("#yonghuname").val(data.logName)
        var stu='';
        var stu2='';
        $("#logPageIndex").val(data.pageIndex);
        $("#logTotalPageCount").val(data.pages.totalPageCount);
        for(var num=1;num<=data.pages.totalPageCount;num++){
            stu2+="<li class='page-item' bb='logli'><a class='page-link'  href='#' onclick='logList("+num+")' >"+num+"</a>"
        }
        $("#logli").after(stu2)

        $.each(data.logList,function(x,y){
            stu+="<tr a='logth'>\n" +
                "<td>"+(x+1)+"</td>\n" +
                "<td>"+y.users.realName+"</td>\n" +
                "<td>"+y.dictionary.valueName+"</td>\n" +
                "<td>"+y.incident+"</td>\n" +
                "<td>"+y.logcomment+"</td>\n" +
                "<td>"+y.opedate+"</td>\n" +
                "</tr>"
        })
        $("#logTable").append(stu)
    },"json")
}
function logPrev() {

    var pageIndex=$("#logPageIndex").val()
    var j=parseInt(pageIndex)
    if(j==1){
        alert("已经是第一页了！")
    }else{
        logList(j-1);
    }

}
function logNext() {
    var pageIndex=$("#logPageIndex").val()
    var totalPageCount=$("#logTotalPageCount").val()
    var j=parseInt(pageIndex)
    var i=parseInt(totalPageCount)
    if(j==i){
        alert("已经是最后一页了！")
    }else{
        logList(j+1);
    }

}
//加载机构列表
function Organization(){
    $("[a='organ']").remove();
    $.post("../liusujun/findOrganization",function(data){
        var stu='';
        $.each(data,function(x,y){
            stu+="<option a='organ' value="+y.id+"  >"+y.organName+"</option>"
        })
        $("[a='organId']").append(stu)
    },"json")
}
//加载部门下拉列表
/*function Dept(){
    $("[a='dept']").remove();
    $.post("../liusujun/findDept",function(data){
        var stu='';
        $.each(data,function(x,y){
            stu+="<option a='dept' value="+y.id+" >"+y.deptName+"</option>"
        })
        $("[a='deptId']").append(stu)
    },"json")
}*/

//加载角色下拉列表
function Role(){
    $("[a='role']").remove();
    $.post("../liusujun/findRole",function(data){
        var stu='';
        $.each(data,function(x,y){
            stu+="<option a='role'  value="+y.valueId+" >"+y.valueName+"</option>"
        })
        $("[a='roleId']").append(stu)
    },"json")
}
//加载职称下拉列表
function Pro(){
    $("[a='pro']").remove();
    $.post("../liusujun/findPro",function(data){
        var stu='';
        $.each(data,function(x,y){
            stu+="<option a='pro' value="+y.valueId+" >"+y.valueName+"</option>"
        })
        $("[a='proId']").append(stu)
    },"json")
}
//加载负责人下拉列表
/*function Users(){
    $("[a='userId']").html("");
    $.post("../liusujun/findUserList",function(data){
        var stu='';
        $.each(data,function(x,y){
            stu+="<option  value='"+y.id+"' >"+y.realName+"</option>"
        })
        $("[a='userId']").append(stu)
    },"json")

}*/
//加载机构(风琴)
function Organ(){
    $("[a='card']").remove();
    $.post("../liusujun/findOrganization",function(data){
        var stu=""
        $.each(data,function(x,y){
            stu+="<div a='card' class=\"card\">\n" +
                "                                    <div class=\"card-header\" value='"+y.id+"' id=\"heading"+(x+1)+"\">\n" +
                "                                        <button class=\"btn btn-link\" cc='organid' type=\"button\" data-toggle=\"collapse\" data-target=\"#collapse"+(x+1)+"\"\n" +
                "                                                aria-expanded=\"true\" value='"+y.id+"' aria-controls=\"collapseOne\">\n" +
                "                                            "+y.organName+"\n" +
                "                                        </button>\n" +
                "                                    </div>\n" +
                "                                    <div id=\"collapse"+(x+1)+"\" class=\"collapse\" aria-labelledby=\"heading"+(x+1)+"\"\n" +
                "                                         data-parent=\"#accordionExample\">\n" +
                "                                        <div class=\"card-body\" cc='deName'>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </div>"
        })
        $("#accordionExample").append(stu)
    },"json")
    /* Users();*/


}
//添加用户
function addUsers(){
    $("#exampleModal1").modal("hide");
    var from=document.querySelector("#addUsers");
    var fromdata=new FormData(from);
    $.ajax({
        url: '../liusujun/addusers',
        dataType: 'json',
        async: true,
        data: fromdata,
        processData: false,// 不加会报错
        contentType: false,//避免对发送到服务器上数据类型重复操作
        type: 'POST',
        success: function (data) {
            if(data>0){
                alert("添加成功！")
                userList();
                logList();
                Organ();
            }else{
                alert("添加失败！")
            }

        },
        error: function () {
            alert("请求出错！")
        }
    })

}
//修改用户
function updateUsers(){
    $("#exampleModal3").modal("hide");
    var from=document.querySelector("#updateUserForm");
    var fromdata=new FormData(from);
    $.ajax({
        url: '../liusujun/updateUsers',
        dataType: 'json',
        async: true,
        data: fromdata,
        processData: false,// 不加会报错
        contentType: false,//避免对发送到服务器上数据类型重复操作
        type: 'POST',
        success: function (data) {
            if(data>0){
                alert("修改成功！")
                userList();
                logList();
                Organ();
            }else{
                alert("添加失败！")
            }

        },
        error: function () {
            alert("请求出错！")
        }
    })

    /*document.getElementById("updateUserForm").submit();*///js原生方式表单提交

}
//添加角色
function addRole(){
    $("#exampleModal2").modal("hide");
    $.ajax({
        url: '../liusujun/addRole',
        dataType: 'json',
        data: {valueId:$("#valueId").val(),valueName:$("#valueName").val()},
        type: 'POST',
        success: function (data) {
            if(data>0){
                alert("添加成功！")
                roleList();
                logList();
                userList();
            }else{
                alert("添加失败！")
            }

        },
        error: function () {
            alert("请求出错！")
        }
    })

}
//修改角色
function updateRole(){
    $("#exampleModal4").modal("hide");
    $.ajax({
        url: '../liusujun/updateRole',
        dataType: 'json',
        data: {'valueId':$("#bainhao").val(),'valueName':$("#roleName").val()},
        type: 'POST',
        success: function (data) {
            alert(data);
            if(data>0){
                alert("修改成功！")
                roleList();
                logList();
                userList();
            }else{
                alert("修改失败！")
            }

        },
        error: function () {
            alert("请求出错！")
        }
    })

}
//添加机构
function addOrgan(){
    $("#exampleModal6").modal("hide");
    $.ajax({
        url: '../liusujun/addOrganization',
        dataType: 'json',
        data: {organName:$("#organName").val(),shortName:$("#shortName").val()},
        type: 'POST',
        success: function (data) {
            if(data>0){
                alert("添加成功！")
                Organ();
                logList();
                userList();
            }else{
                alert("添加失败！")
            }

        },
        error: function () {
            alert("请求出错！")
        }
    })

}
//修改部门
function updateDept(){
    $("#exampleModal5").modal("hide");
    var from=document.querySelector("#updateDeptFrom");
    var fromdata=new FormData(from);
    $.ajax({
        url: '../liusujun/updateDept',
        dataType: 'json',
        async: true,
        data: fromdata,
        processData: false,// 不加会报错
        contentType: false,//避免对发送到服务器上数据类型重复操作
        type: 'POST',
        success: function (data) {
            if(data>0){
                alert("修改成功！")
                userList();
                logList();
                userList();
            }else{
                alert("添加失败！")
            }

        },
        error: function () {
            alert("请求出错！")
        }
    })

}
//添加部门
function addDept(){
    $("#exampleModal7").modal("hide");
    var from=document.querySelector("#addDeptFrom");
    var fromdata=new FormData(from);
    $.ajax({
        url: '../liusujun/adddept',
        dataType: 'json',
        async: true,
        data: fromdata,
        processData: false,// 不加会报错
        contentType: false,//避免对发送到服务器上数据类型重复操作
        type: 'POST',
        success: function (data) {
            if(data>0){
                alert("添加成功！")
                Organ();
                logList();
                userList();
            }else{
                alert("添加失败！")
            }

        },
        error: function () {
            alert("请求出错！")
        }
    })


}


$(function(){
    Organ();
    userList();
    roleList();
    logList();

    //加载机构下的所有职工
    $("#jiguoId").click(function(){
        $("[a='userId']").html("");
        $.post("../liusujun/findUserByOrganId",{'OrganId':$("#jiguoId").val()},function(d){
            var stu='';
            $.each(d,function(x,y){
                stu+="<option  value='"+y.id+"' >"+y.realName+"</option>"
            })
            $("[a='userId']").append(stu)
        },"json")
    })
    //点击修改部门模态框
    $(document).on('click','[bb=\'exampleModal5\']',function(){
        $.post("../liusujun/findDeptBydeptId",{'id':$(this).val()},function(data){
            $("[ab='id']").val(data.id)
            $("[ab='deptname']").val(data.deptName);
            $("[ab='organ']").val(data.organization.organName);
            $("[ab='organid']").val(data.organId)
            $("[ad='hiddenuserId']").val(data.userId)
            $("[ab='userid']").val(data.userId)
            $("[ab='telephone']").val(data.telephone)
            $("[ab='phone']").val(data.phone)
            $("[ab='fax']").val(data.fax)
        },"json")
    })
    //点击机构加载下属部门
    $("[a='organId']").click(function(){
        $("[a='dept']").remove();
        $.post("../liusujun/findDeptById",{'id':$(this).val()},function (data) {
            var stu='';
            $.each(data,function(x,y){
                stu+="<option a='dept' value="+y.id+" >"+y.deptName+"</option>"
            })
            $("[a='deptId']").append(stu)
        },"json")
    })
    //加载机构下的部门
    $(document).on('click','[cc=\'organid\']',function(){

        $("[a='userId']").html("");
        $.post("../liusujun/findUserByOrganId",{'OrganId':$(this).val()},function(d){
            var stu='';
            $.each(d,function(x,y){
                stu+="<option  value='"+y.id+"' >"+y.realName+"</option>"
            })
            $("[a='userId']").append(stu)
        },"json")

        var stu="";
        $("[a='deptTable']").remove();
        $.post("../liusujun/findDeptById",{'id':$(this).val()},function(data){
            stu+=" <table class=\"table table-borderless\" a='deptTable' >\n" +
                "                                <tr id=\"deptTh\">\n" +
                "                                    <th>排序</th>\n" +
                "                                    <th>部门</th>\n" +
                "                                    <th>联系电话</th>\n" +
                "                                    <th>操作</th>\n" +
                "                                </tr>\n"
            $.each(data,function(x,y){
                stu+=" <tr a='roleTr'>\n" +
                    "                                    <td>"+(x+1)+"</td>\n" +
                    "                                    <td>"+y.deptName+"</td>\n" +
                    "                                    <td>"+y.telephone+"</td>\n" +
                    "                                    <td>\n" +
                    "                                        <button type=\"button\" bb='exampleModal5'  value='"+y.id+"' class=\"btn btn-success btn-floating\" data-toggle=\"modal\"\n" +
                    "                                                data-target=\"#exampleModal5\" >\n" +
                    "                                            <i class=\"ti-check-box\"></i>\n" +
                    "                                        </button>\n" +

                    "                                        <button type=\"button\" value='"+y.id+"'   class=\"btn btn-danger btn-floating\" cc='delDept'>\n" +
                    "                                            <i class=\"ti-trash\"></i>\n" +
                    "                                        </button>\n" +
                    "                                    </td>\n" +
                    "                                </tr>"
                /* $("[name='id']").val(y.id)
                 $("[name='deptName']").val(y.deptName);
                 $("[name='organ']").val(y.organization.organName);
                 $("[name='organId']").val(y.organId)
                 $("[name='userId']").val(y.userId)
                 $("[name='telephone']").val(y.telephone)
                 $("[name='phone']").val(y.phone)
                 $("[name='fax']").val(y.fax)*/
            })
            stu+="</table>"
            $("[cc='deName']").append(stu)
        },"json")

    })
    //点击用户表的查询
    $("#userButton").click(function(){
        userList();
    })
    //点击日志表的查询
    $("#logButton").click(function(){
        logList();
    })
    //修改用户
    $(document).on('click','[cc=\'updateuser\']',function(){
        $("[a='dept']").remove();
        $.post("../liusujun/findUserOrganId",{'id':$(this).val()},function(data){
            $.post("../liusujun/findDeptById",{'id':data},function (da) {
                var stu='';
                $.each(da,function(x,y){
                    stu+="<option a='dept'  value="+y.id+" >"+y.deptName+"</option>"
                })
                $("[a='deptId']").append(stu)
            },"json")
        })
        $.post("../liusujun/findUsersByid",{'id':$(this).val()},function(data){
            $("[update='id']").val(data.id);
            $("[update='userName']").val(data.uName);
            $("[update='realName']").val(data.realName);
            $("[update='organId']").val(data.organId);
            $("[update='deptId']").val(data.deptId);
            $("[update='sex']").val(data.sex);
            $("[update='proId']").val(data.proId);
            $("[update='roleId']").val(data.roleId);
            $("[update='status']").val(data.status);
            $("[update='phone']").val(data.phone);
        },"json")
    })
    //删除用户
    $(document).on('click',' [name=\'del\']',function(){
        if(confirm("确定要删除该用户吗？")){
            $.post("../liusujun/delUser",{'id':$(this).val()},function(data){
                if(data>0){
                    alert("删除成功！")
                    userList();
                }else{
                    alert("删除失败！")
                }
            },"json")
        }

    })
    //修改角色
    $(document).on('click','[ cc=\'updateRole\']',function(){
        $.post("../liusujun/findRoleByid",{'valueId':$(this).val()},function(data){
            $("[a='valueId']").val(data.valueId);
            $("[a='valueName']").val(data.valueName);
        },"json")
    })
    //删除角色
    $(document).on('click','[ cc=\'delRole\']',function(){
        if(confirm("确定要删除该角色吗？")){
            $.post("../liusujun/delRoleById",{'valueId':$(this).val()},function(data){
                if(data>0){
                    alert("删除成功！")
                    roleList();
                }else{
                    alert("删除失败！")
                }
            },"json")
        }

    })
    //删除部门
    $(document).on('click','[ cc=\'delDept\']',function(){
        if(confirm("确定要删除该部门吗？")){
            $.post("../liusujun/delDeptByid",{'id':$(this).val()},function (data) {
                if(data>0){
                    alert("删除成功！")
                    Organ();
                }else{
                    alert("删除失败！")
                }
            })
        }
    })
    //前端验证
    //添加用户验证
    //添加用户时验证两次密码输入一致
    $("#passWord").blur(function(){
        $.post("../liusujun/validatePassword ",{'password':$("#passWord").val(),'password1':$("#passWord1").val()},function(data){
            if(data!=1){
                alert("两次输入的密码不同，请重新输入！")
            }
        },"json")
    })
    //用户名不能为空

    $("#passWord1").click(function(){
        if($("#userName").val()==""){
            alert("用户名不能为空！")
        }

    })
    $("#passWord").blur(function(){
        if($("#passWord1").val()==""){
            alert("密码不能为空！")
        }else{
            if($("#passWord").val().length<6){
                alert("密码不能小于6位")
            }
        }
    })






})