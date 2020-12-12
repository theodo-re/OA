package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Dept;
import cn.bdqn.oaproject.entity.Organization;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.service.DeptService;
import cn.bdqn.oaproject.service.OrganizationService;
import cn.bdqn.oaproject.service.UsersService;
import cn.bdqn.oaproject.util.Constants;
import cn.bdqn.oaproject.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/liusujun")
public class userController {
    @Resource
    private UsersService userService;
    @Resource
    private OrganizationService organizationService;
    @Resource
    private DeptService deptService;

    /**
     * 查询用户（模糊查询+分页）
     */
    @RequestMapping("/Users")
    @ResponseBody
    public Map<String,Object> findUsers(@RequestParam(required = false) String uName,
                                        @RequestParam(required = false) String realName,
                                        @RequestParam(defaultValue = "1",required = false) Integer pageIndex
    ){
        int pageSize= Constants.pageSize;//获取当前页大小
        int currentPageNo = pageIndex;//设置当前页码
        Users user=new Users();
        user.setUserName(uName);
        user.setRealName(realName);
        int totalCount=userService.findUsersCount(user);//总条数
        PageSupport pages=new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();//计算总页数
        int currentPageNo1=(pageIndex-1)*pageSize;
        List<Users> userList=userService.findUsers(user,currentPageNo1,pageSize);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pages",pages);
        map.put("userList",userList);
        map.put("pageIndex",pageIndex);
        map.put("uName",uName);
        map.put("rName",realName);
        return map;
    }

    /**
     * 查询所在机构
     * @param
     * @return
     */
    @RequestMapping("/findOrganization")
    @ResponseBody
    public List<Organization> findOrganization(){
        List<Organization> OrganizationList=organizationService.findOrganization();
        return OrganizationList;
    }
    /**
     * 查询所在部门
     */
    @RequestMapping("/findDept")
    @ResponseBody
    public List<Dept> findDept(){
        List<Dept> deptList=deptService.findDept();
        return deptList;
    }
    /**
     * 添加用户是验证密码
     */
    @RequestMapping("/validatePassword")
    @ResponseBody
    public int validatePassword(@RequestParam(required = false) String password,
                                @RequestParam(required = false) String password1){
        int rel=-1;
        if(password.equals(password1)){
            rel=1;
        }
        return rel;
    }
    /**
     * 添加用户
     */
    @RequestMapping("/addusers")
    @ResponseBody
    public int addUsers(Users user,HttpSession session){
        int rel=userService.addUsers(user,session);
        return rel;
    }
    /**
     * 根据id查找用户
     */
    @RequestMapping("/findUsersByid")
    @ResponseBody
    public Users findUsersByid(Integer id){
        Users user=userService.findUsersById(id);
        return user;
    }
    /**
     * 根据id删除用户
     */
    @RequestMapping("/delUser")
    @ResponseBody
    public int delUser(Integer id,HttpSession session){
        int rel=-1;
        rel=userService.delUser(id,session);
        return rel;
    }
    /**
     * 修改用户
     */
    @RequestMapping("/updateUsers")
    @ResponseBody
    public int updateUser(Users users, HttpSession session){
        int rel=userService.updateUsers(users,session);
        return rel;
    }
    //
    @RequestMapping("/findDeptById")
    @ResponseBody
    public List<Dept> findDept(Integer id){
        String num=id.toString();
        Long deptid=Long.parseLong(num);
        List<Dept> deptList=deptService.findDeptByCreatedId(deptid);

        return deptList;
    }

    @RequestMapping("/findUserList")
    @ResponseBody
    public List<Users> findUsersList(){
        List<Users> userList=userService.findUsersList();
        return userList;
    }
    @RequestMapping("/findUserOrganId")
    @ResponseBody
    public int findUserOrganId(Integer id){
        int rel=userService.findUsersOrganId(id);
        return rel;
    }
    @RequestMapping("finddepartmentHead")
    @ResponseBody
    public List<Users> finddepartmentHead(Integer deptId){
        String num=deptId.toString();
        Long deptid=Long.parseLong(num);
        List<Users> userList=userService.findDeptLeadd(deptid);
        return userList;
    }
    @RequestMapping("findUserByOrganId")
    @ResponseBody
    public List<Users> findUserByOrganId(Integer OrganId){
        List<Users> userList=userService.findUserByOrganId(OrganId);
        return userList;
    }

    @RequestMapping("/findDeptBydeptId")
    @ResponseBody
    public Dept findDeptbyId(Integer id){
        Dept dept;
        int rel=deptService.findDeptFuZeUsers(id);
        if(rel>0){
            dept=deptService.findDeptById(id);
        }else{
            dept=deptService.findDeptByIDD(id);
        }

        return dept;
    }

}
