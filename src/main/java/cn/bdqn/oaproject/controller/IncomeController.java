package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Income;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Task;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.service.IncomeService;
import cn.bdqn.oaproject.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/income")
public class IncomeController {
    Logger logger = LoggerFactory.getLogger(IncomeController.class);

    Income income = new Income();
    Task task = new Task();
    Log log = new Log();

    @Resource
    IncomeService incomeService;

    @RequestMapping(value = "/income.html")
    @ResponseBody
    public String income(String applydate, String applyment,HttpSession session) throws ParseException {
        //处理出差数据
        //申请人姓名
        income.setUserId(((Users)session.getAttribute(Constants.USER_SESSION)).getId());
        //申请人部门
        income.setDeptId(((Users)session.getAttribute(Constants.USER_SESSION)).getDeptId());
        //申请人职位
        income.setPostId(((Users) session.getAttribute(Constants.USER_SESSION)).getProId());
        //申请时间
        if (applydate!=null && !applydate.equals("")){
            income.setApplydate(new Date());
        }
        //申请事由
        if (applyment!=null && !applyment.equals("")){
            income.setApplyment(applyment);
        }

        income.setCheckId(((Users)session.getAttribute(Constants.USER_SESSION)).getMajer());//审核人
        income.setCreatedby(((Users)session.getAttribute(Constants.USER_SESSION)).getId());//创建人
        income.setCreatedtime(new Date());//创建时间
        task.settName(((Users)session.getAttribute(Constants.USER_SESSION)).getRealName()+"收入证明申请");//状态表任务名称
        task.setStatusId(((Users)session.getAttribute(Constants.USER_SESSION)).getId());//状态表状态
        task.setAuditId(((Users)session.getAttribute(Constants.USER_SESSION)).getMajer());//状态表审核人
        task.setCreatedby(((Users)session.getAttribute(Constants.USER_SESSION)).getId());//状态表创建人
        task.setCreatedtime(new Date());//状态表创建时间
        log.setUserId(((Users)session.getAttribute(Constants.USER_SESSION)).getId());//日志表用户名
        log.setRoleId(((Users)session.getAttribute(Constants.USER_SESSION)).getRoleId());//日志表角色
        log.setIncident(((Users)session.getAttribute(Constants.USER_SESSION)).getRealName()+"收入证明申请");//日志表事件
        log.setOpedate(new Date());//日志表操作时间
        boolean rel = incomeService.add(income,task,log);
        if (rel==true){
            return "提交成功！";
        }else {
            return "提交失败！";
        }
    }
}
