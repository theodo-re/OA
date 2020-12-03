package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.dao.DeptDao;
import cn.bdqn.oaproject.entity.Dept;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("liusujun")
public class DeptController {
    @Resource
    private DeptService deptService;
    @RequestMapping("updateDept")
    public String updateDept(Dept dept, HttpSession session) throws ParseException {
        System.out.println(dept.getId()+"**********");
        dept.setModifytime(new Date());
        Long id=((Users)session.getAttribute("session")).getId();
        dept.setModifyby(id);
        int rel=deptService.updateDept(dept,session);
        if(rel>0){
            return "redirect:/xitongguanli";
        }
        return "redirect:/xitongguanli";
    }
    @RequestMapping("delDeptByid")
    @ResponseBody
    public int delDept(Integer id,HttpSession session){
        int rel=deptService.delDept(id,session);
        return rel;
    }

}
