package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Evection;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Task;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.service.EvectionService;
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
@RequestMapping("/evection")
public class EvectionController {
    Logger logger = LoggerFactory.getLogger(EvectionController.class);

    Evection evection = new Evection();
    Task task = new Task();
    Log log = new Log();

    @Resource
    EvectionService evectionService;

    @RequestMapping(value = "/evection.html")
    @ResponseBody
    public String evection(String chuchaistartdate, String chuchaienddate, String chuchaidestination, Integer chuchaitraffic,
                           String chuchaiincident,String chuchaietask,Double chuchaimoney,HttpSession session) throws ParseException {
        //处理出差数据
        //申请人姓名
        evection.setUserId(((Users)session.getAttribute(Constants.USER_SESSION)).getId());
        //申请人部门
        evection.setDeptId(((Users)session.getAttribute(Constants.USER_SESSION)).getDeptId());
        //开始时间
        if (chuchaistartdate!=null && !chuchaistartdate.equals("")){
            evection.setStartdate(new SimpleDateFormat("yyyy-MM-dd").parse(chuchaistartdate));
        }
        //结束时间
        if (chuchaienddate!=null && !chuchaienddate.equals("")){
            evection.setEnddate(new SimpleDateFormat("yyyy-MM-dd").parse(chuchaienddate));
        }
        //出差地点
        if (chuchaidestination!=null && !chuchaidestination.equals("")){
            evection.setDestination(chuchaidestination);
        }
        //交通工具
       if (chuchaitraffic!=null && !chuchaitraffic.equals("")){
            evection.setTraffic(chuchaitraffic);
        }
        //出差事由
        if (chuchaiincident!=null && !chuchaiincident.equals("")){
            evection.setIncident(chuchaiincident);
        }
        //工作任务
        if (chuchaietask!=null && !chuchaietask.equals("")){
            evection.setEtask(chuchaietask);
        }
        //借款金额
        if (chuchaimoney!=null && !chuchaimoney.equals("")){
            evection.setMoney(chuchaimoney);
        }

        evection.setCheckId(((Users)session.getAttribute(Constants.USER_SESSION)).getMajer());//审核人
        evection.setCreatedby(((Users)session.getAttribute(Constants.USER_SESSION)).getId());//创建人
        evection.setCreatedtime(new Date());//创建时间
        task.settName(((Users)session.getAttribute(Constants.USER_SESSION)).getRealName()+"出差申请");//状态表任务名称
        task.setStatusId(((Users)session.getAttribute(Constants.USER_SESSION)).getId());//状态表状态
        task.setAuditId(((Users)session.getAttribute(Constants.USER_SESSION)).getMajer());//状态表审核人
        task.setCreatedby(((Users)session.getAttribute(Constants.USER_SESSION)).getId());//状态表创建人
        task.setCreatedtime(new Date());//状态表创建时间
        log.setUserId(((Users)session.getAttribute(Constants.USER_SESSION)).getId());//日志表用户名
        log.setRoleId(((Users)session.getAttribute(Constants.USER_SESSION)).getRoleId());//日志表角色
        log.setIncident(((Users)session.getAttribute(Constants.USER_SESSION)).getRealName()+"出差申请");//日志表事件
        log.setOpedate(new Date());//日志表操作时间
        boolean rel = evectionService.add(evection,task,log);
        if (rel==true){
            return "提交成功！";
        }else {
            return "提交失败！";
        }
    }
}
