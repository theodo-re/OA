//加载用户列表
function userList(pageIndex){
    $("[a='userTr']").remove();
    $("[aa='li']").html("");
    $.post("liusujun/Users",{'uName':$("#uName").val(),'realName':$("#rName").val(),
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
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+user.uName+"</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+user.realName+"</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+user.dictionary1.valueName+"</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+user.organization.organName+"</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+user.dictionary2.valueName+"</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\"  class=\"btn btn-success btn-floating\" data-toggle=\"modal\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-target=\"#exampleModal3\" value='"+user.id+"' cc='updateuser' >\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"ti-check-box\"></i>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</button>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"modal fade\" id=\"exampleModal3\" tabindex=\"-1\" role=\"dialog\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"modal-dialog\" role=\"document\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"modal-content\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"modal-header\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h5 class=\"modal-title\">修改用户</h5>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</button>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"modal-body\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<form id=\"updateUserForm\" method='post' action='liusujun/updateUsers'>\n" +
                "<input type='hidden' name='id' update='id' >"+
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"recipient-username\" class=\"col-form-label\">用户名:</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" update='userName' name=\"userName\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"recipient-name\" class=\"col-form-label\">真实姓名:</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" update='realName' name=\"realName\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"recipient-name\" class=\"col-form-label\">所在机构:</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" a='organId' update='organId' name=\"organId\"></select>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"recipient-name\" class=\"col-form-label\">所在部门:</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" a='deptId' update='deptId' name=\"deptId\"></select>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"recipient-sex\" class=\"col-form-label\">性别:</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" update='sex'  name=\"sex\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\">男</option>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"2\">女</option>\n" +
                "</select>"+
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n"+
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"recipient-name\" class=\"col-form-label\">职称:</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" a='proId'  update='proId'  name=\"proId\"></select>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"recipient-name\" class=\"col-form-label\">角色:</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" a='roleId' update='roleId' name=\"roleId\"></select>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"recipient-name\" class=\"col-form-label\">状态:</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" update='status'  name=\"status\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\">正常</option>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"2\">冻结</option>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</form>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"modal-footer\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">关闭\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</button>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\" onclick='tijiao()' class=\"btn btn-primary\">提交</button>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\" value='"+user.id+"' name='del' class=\"btn btn-danger btn-floating\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"ti-trash\"></i>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</button>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>"
        })
        $("#Userth").after(stu);
    },"json")
    Organization();
    Dept();
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
    $.post("liusujun/roleList",{'pageIndex':pageIndex},function(data){
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
                "                                        <div class=\"modal fade\" id=\"exampleModal4\" tabindex=\"-1\" role=\"dialog\"\n" +
                "                                             aria-labelledby=\"exampleModalLabel\"\n" +
                "                                             aria-hidden=\"true\">\n" +
                "                                            <div class=\"modal-dialog\" role=\"document\">\n" +
                "                                                <div class=\"modal-content\">\n" +
                "                                                    <div class=\"modal-header\">\n" +
                "                                                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">修改角色</h5>\n" +
                "                                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\"\n" +
                "                                                                aria-label=\"Close\">\n" +
                "                                                            <span aria-hidden=\"true\">&times;</span>\n" +
                "                                                        </button>\n" +
                "                                                    </div>\n" +
                "                                                    <div class=\"modal-body\">\n" +
                "                                                        <form method='post' action='updateRole'>\n" +
                "                                                            <div class=\"form-group\">\n" +
                "                                                                <label for=\"roleId\" class=\"col-form-label\">编号:</label>\n" +
                "                                                                <input type=\"text\" readonly class=\"form-control\"\n" +
                "                                                                       id=\"roleId\" a='valueId' name='valueId'>\n" +
                "                                                            </div>\n" +
                "                                                            <div class=\"form-group\">\n" +
                "                                                                <label for=\"roleName\" class=\"col-form-label\">名称:</label>\n" +
                "                                                                <input type=\"text\" class=\"form-control\"\n" +
                "                                                                       id=\"roleName\" a='valueName' name='valueName'>\n" +
                "                                                            </div>\n" +
                "                                                            <div class=\"modal-footer\">\n" +
                "                                                               <button type=\"button\" class=\"btn btn-secondary\"\n" +
                "                                                                    data-dismiss=\"modal\">关闭\n" +
                "                                                               </button>\n" +
                "                                                               <button type=\"submit\" id='updateRoleButton' class=\"btn btn-primary\">提交</button>\n" +
                "                                                           </div>\n" +
                "                                                        </form>\n" +
                "                                                    </div>\n" +

                "                                                </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <button type=\"button\"  value='"+role.valueId+"' class=\"btn btn-danger btn-floating\" cc='delRole'>\n" +
                "                                            <i class=\"ti-trash\"></i>\n" +
                "                                        </button>\n" +
                "                                    </td>\n" +
                "                                </tr>"
        })
    $("#roleth").after(stu);
    },"json")
}
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
//加载日志列表
function logList(pageIndex){

    $("[a='logth']").remove();
    $("[bb='logli']").html("");
    $.post("liusujun/logList",{'realName':$("#yonghuname").val(),
        'pageIndex':pageIndex,'startDate':$("#startDate").val(),'endDate':$("#endDate").val()},function(data){
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
//提交按钮在表单外提交
function tijiao(){
    document.getElementById("updateUserForm").submit();//js原生方式表单提交
}
//加载机构列表
function Organization(){
    $("[a='organ']").remove();
    $.post("liusujun/findOrganization",function(data){
        var stu='';
        $.each(data,function(x,y){
            stu+="<option a='organ' value="+y.id+"  >"+y.organName+"</option>"
        })
        $("[a='organId']").append(stu)
    },"json")
}
//加载部门下拉列表
function Dept(){
    $("[a='dept']").remove();
    $.post("liusujun/findDept",function(data){
        var stu='';
        $.each(data,function(x,y){
            stu+="<option a='dept' value="+y.id+" >"+y.deptName+"</option>"
        })
        $("[a='deptId']").append(stu)
    },"json")
}
//加载角色下拉列表
function Role(){
    $("[a='role']").remove();
    $.post("liusujun/findRole",function(data){
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
    $.post("liusujun/findPro",function(data){
        var stu='';
        $.each(data,function(x,y){
            stu+="<option a='pro' value="+y.valueId+" >"+y.valueName+"</option>"
        })
        $("[a='proId']").append(stu)
    },"json")
}
//加载负责人下拉列表
function Users(){
    $("[a='userId']").html("");
    $.post("liusujun/findUserList",function(data){
        var stu='';
        $.each(data,function(x,y){
            stu+="<option  value='"+y.id+"' >"+y.realName+"</option>"
        })
        $("[a='userId']").append(stu)
    },"json")

}
//加载机构(风琴)
function Organ(){
    $.post("liusujun/findOrganization",function(data){
        var stu=""
        $.each(data,function(x,y){
            stu+="<div class=\"card\">\n" +
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
    Users();


}
$(function(){
    Organ();
    userList();
    roleList();
    logList();
    //加载机构下的部门
    $(document).on('click','[cc=\'organid\']',function(){
        var stu="";
        $("[a='deptTable']").remove();
        $.post("liusujun/findDeptById",{'id':$(this).val()},function(data){
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
                    "                                        <button type=\"button\" class=\"btn btn-success btn-floating\" data-toggle=\"modal\"\n" +
                    "                                                data-target=\"#exampleModal5\" >\n" +
                    "                                            <i class=\"ti-check-box\"></i>\n" +
                    "                                        </button>\n" +

                    "                                        <button type=\"button\" value='"+y.id+"'   class=\"btn btn-danger btn-floating\" cc='delDept'>\n" +
                    "                                            <i class=\"ti-trash\"></i>\n" +
                    "                                        </button>\n" +
                    "                                    </td>\n" +
                    "                                </tr>"
                 $("[name='id']").val(y.id)
                 $("[name='deptName']").val(y.deptName);
                 $("[ name='organ']").val(y.organization.organName);
                 $("[name='organId']").val(y.organId)
                 $("[name='userId']").val(y.userId)
                 $("[name='telephone']").val(y.telephone)
                 $("[name='phone']").val(y.phone)
                 $("[name='fax']").val(y.fax)
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
    //添加用户时验证两次密码输入一致
    $("#passWord").blur(function(){
        $.post("liusujun/validatePassword ",{'password':$("#passWord").val(),'password1':$("#passWord1").val()},function(data){
            if(data!=1){
                alert("两次输入的密码不同，请重新输入！")
            }
        },"json")
    })
    //修改用户
    $(document).on('click','[cc=\'updateuser\']',function(){

       $.post("liusujun/findUsersByid",{'id':$(this).val()},function(data){
            $("[update='id']").val(data.id)
            $("[update='userName']").val(data.userName)
            $("[update='passWord1']").val(data.passWord)
            $("[update='passWord']").val(data.passWord)
            $("[update='realName']").val(data.realName)
            $("[update='organId']").val(data.organId);
            $("[update='deptId']").val(data.deptId)
            $("[update='sex']").val(data.sex)
            $("[update='proId']").val(data.proId)
            $("[update='roleId']").val(data.roleId)
            $("[update='status']").val(data.status)
        },"json")
    })
    //删除用户
    $(document).on('click',' [name=\'del\']',function(){
        if(confirm("确定要删除该用户吗？")){
            $.post("liusujun/delUser",{'id':$(this).val()},function(data){
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
        $.post("liusujun/findRoleByid",{'valueId':$(this).val()},function(data){
            $("[a='valueId']").val(data.valueId);
            $("[a='valueName']").val(data.valueName);
        },"json")
    })
    //删除角色
    $(document).on('click','[ cc=\'delRole\']',function(){
        if(confirm("确定要删除该角色吗？")){
            $.post("liusujun/delRoleById",{'valueId':$(this).val()},function(data){
                if(data>0){
                    alert("删除成功！")
                    userList();
                }else{
                    alert("删除失败！")
                }
            },"json")
        }

    })
    //删除部门
    $(document).on('click','[ cc=\'delDept\']',function(){
        if(confirm("确定要删除该部门吗？")){
            $.post("liusujun/delDeptByid",{'id':$(this).val()},function (data) {
                if(data>0){
                    alert("删除成功！")
                    Organ();
                }else{
                    alert("删除失败！")
                }
            })
        }
    })



})