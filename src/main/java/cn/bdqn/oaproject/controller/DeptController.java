/*
package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.dao.DeptDao;
import cn.bdqn.oaproject.entity.Dept;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.service.DeptService;
import cn.bdqn.oaproject.util.Constants;
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
        Users users = (Users)session.getAttribute(Constants.USER_SESSION);
        Long id=users.getId();
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
*/


package cn.bdqn.oaproject.controller;

        import cn.bdqn.oaproject.dao.DeptDao;
        import cn.bdqn.oaproject.entity.Dept;
        import cn.bdqn.oaproject.entity.Users;
        import cn.bdqn.oaproject.service.DeptService;
        import cn.bdqn.oaproject.util.Constants;
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
    @ResponseBody
    public int updateDept(Dept dept, HttpSession session) throws ParseException {
        dept.setModifytime(new Date());
        Long id=((Users)session.getAttribute(Constants.USER_SESSION)).getId();
        dept.setModifyby(id);
        int rel=deptService.updateDept(dept,session);
        return rel;
    }
    @RequestMapping("delDeptByid")
    @ResponseBody
    public int delDept(Integer id,HttpSession session){
        int rel=deptService.delDept(id,session);
        return rel;
    }
    @RequestMapping("adddept")
    @ResponseBody
    public int addDept(Dept dept,HttpSession session){
        Long id=((Users)session.getAttribute(Constants.USER_SESSION)).getId();
        dept.setCreatedby(id);
        dept.setCreatedtime(new Date());
        int rel=deptService.addDept(dept,session);
        return rel;
    }

}

