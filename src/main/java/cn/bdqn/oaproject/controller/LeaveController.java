package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Leave;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Task;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.service.IncomeService;
import cn.bdqn.oaproject.service.LeaveService;
import cn.bdqn.oaproject.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class LeaveController {
    Logger logger = LoggerFactory.getLogger(LeaveController.class);

    @Resource
    private LeaveService leaveService;

    @Resource
    IncomeService incomeService;

    Leave leave = new Leave();
    Task task = new Task();
    Log log = new Log();

    @RequestMapping("/renshiguanli.html")
    public String renshi(Model model, HttpSession session){
        //根据用户名从数据库里查询到的信息在页面加载的时候就进行传值
        model.addAttribute("renshi",leaveService.findCByName(((Users)session.getAttribute(Constants.USER_SESSION)).getRealName()));
        return "renshiguanli";
    }

    @RequestMapping(value = "/leave.html")
    @ResponseBody
    public String leave(String qingjiaostartdate, String qingjiaoenddate,Integer qingjiaoleaveday, Integer qingjiaoltype,
                        String qingjiaodestination,HttpSession session) throws ParseException {
        //处理请假数据
        //申请人姓名
        leave.setUserId(((Users)session.getAttribute(Constants.USER_SESSION)).getId());
        //申请人部门
        leave.setDeptId(((Users)session.getAttribute(Constants.USER_SESSION)).getDeptId());
        //开始时间
        if (qingjiaostartdate!=null && !qingjiaostartdate.equals("")){
            leave.setStartdate(new SimpleDateFormat("yyyy-MM-dd").parse(qingjiaostartdate));
        }
        //结束时间
        if (qingjiaoenddate!=null && !qingjiaoenddate.equals("")){
            leave.setEnddate(new SimpleDateFormat("yyyy-MM-dd").parse(qingjiaoenddate));
        }
        //请假天数
        if (qingjiaoleaveday!=null && !qingjiaoleaveday.equals("")){
            leave.setLeaveday(qingjiaoleaveday);
        }
        //请假类型
        if (qingjiaoltype!=null && !qingjiaoltype.equals("")){
            leave.setLtype(qingjiaoltype);
        }
        //请假事由
        if (qingjiaodestination!=null && !qingjiaodestination.equals("")){
            leave.setDestination(qingjiaodestination);
        }

        leave.setCheckId(((Users)session.getAttribute(Constants.USER_SESSION)).getMajer());//审核人
        leave.setCreatedby(((Users)session.getAttribute(Constants.USER_SESSION)).getId());//创建人
        leave.setCreatedtime(new Date());//创建时间
        task.settName(((Users)session.getAttribute(Constants.USER_SESSION)).getRealName()+"请假申请");//状态表任务名称
        task.setStatusId(((Users)session.getAttribute(Constants.USER_SESSION)).getId());//状态表状态
        task.setAuditId(((Users)session.getAttribute(Constants.USER_SESSION)).getMajer());//状态表审核人
        task.setCreatedby(((Users)session.getAttribute(Constants.USER_SESSION)).getId());//状态表创建人
        task.setCreatedtime(new Date());//状态表创建时间
        log.setUserId(((Users)session.getAttribute(Constants.USER_SESSION)).getId());//日志表用户名
        log.setRoleId(((Users)session.getAttribute(Constants.USER_SESSION)).getRoleId());//日志表角色
        log.setIncident(((Users)session.getAttribute(Constants.USER_SESSION)).getRealName()+"请假申请");//日志表事件
        log.setOpedate(new Date());//日志表操作时间
        boolean rel = leaveService.add(leave,task,log);
        if (rel==true){
            return "提交成功！";
        }else {
            return "提交失败！";
        }
    }
}
