package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.DeptDao;
import cn.bdqn.oaproject.dao.LogDao;
import cn.bdqn.oaproject.dao.UsersDao;
import cn.bdqn.oaproject.entity.Dept;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.util.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{
    @Resource
    private UsersDao userdao;
    @Resource
    private LogDao logdao;

    @Override
    public Object[] findCByName(String uName,String password) {
        Object[] obj = new Object[2];
        int rel = -1;
        Users user = userdao.findCByName(uName);
        if(user!=null){
            if(password.equals(user.getuPassWord())){
                rel=1;
            }else{
                rel=0;
            }
        }
        obj[0]=rel;
        obj[1]=user;
        return obj;
    }

    @Override
    public List<Users> findUsers(Users users, Integer pageIndex, Integer pageSize) {
        return userdao.findUsers(users,pageIndex,pageSize);
    }

    @Override
    public int findUsersCount(Users users) {
        return userdao.findUsersCount(users);
    }

    @Override
    public int addUsers(Users user, HttpSession session) {
        user.setCreatedtime(new Date());
        Long deptId=user.getDeptId();

        Integer num=-1;
        num=userdao.findDeptLead(deptId);
        if(num!=null && num>0){
            user.setMajer(new Long(num));
        }

        int rel1=userdao.addUsers(user);

        Log log=new Log();
        Users users = (Users)session.getAttribute(Constants.USER_SESSION);
        Long id=users.getId();
        log.setUserId(id);
        Long roleId=users.getRoleId();
        log.setRoleId(roleId);
        log.setIncident("添加了用户");
        log.setOpedate(new Date());
        int rel2=logdao.addLog(log);
        int rel=-1;
        List<Integer> nums=new ArrayList<>();
        nums.add(rel1);
        nums.add(rel2);
        for(int i:nums){
            if(i>0){
                rel=1;
            }
        }
        return rel;
    }

    @Override
    public Users findUsersById(Integer id) {
        return userdao.findUsersById(id);
    }

    @Override
    public int delUser(Integer id,HttpSession session) {
        int rel1=userdao.delUser(id);
        Log log=new Log();
        Users users = (Users)session.getAttribute(Constants.USER_SESSION);
        Long userId=users.getId();
        log.setUserId(userId);
        Long roleId=users.getRoleId();
        log.setRoleId(roleId);
        log.setIncident("删除了用户");
        log.setOpedate(new Date());
        int rel2=logdao.addLog(log);
        int rel=-1;
        List<Integer> nums=new ArrayList<>();
        nums.add(rel1);
        nums.add(rel2);
        for(int i:nums){
            if(i>0){
                rel=1;
            }
        }

        return rel;
    }

    @Override
    public int updateUsers(Users users, HttpSession session) {

        int rel1=userdao.updateUsers(users);

        Log log=new Log();
        Users user = (Users)session.getAttribute(Constants.USER_SESSION);
        Long id=user.getId();
        log.setUserId(id);
        Long roleId=user.getRoleId();
        log.setRoleId(roleId);
        log.setIncident("修改了用户");
        log.setOpedate(new Date());
        int rel2=logdao.addLog(log);
        int rel=-1;
        List<Integer> nums=new ArrayList<>();
        nums.add(rel1);
        nums.add(rel2);
        for(int i:nums){
            if(i>0){
                rel=1;
            }
        }
        return rel;
    }

    @Override
    public List<Users> findUsersList() {
        return userdao.findUsersList();
    }

    @Override
    public Integer findDeptLead(Long deptid) {
        Integer rel = userdao.findDeptLead(deptid);
        return rel;
    }
    @Override
    public int findByrealName(String name) {
        return userdao.findByrealName(name);

    }

    @Override
    public int findIdName(String name) {
        return userdao.findIdName(name);
    }

    @Override
    public String findMajerByName(String name) {
        return userdao.findMajerByName(name);
    }

    @Override
    public Users findPhone(String phone) {
        return userdao.findPhone(phone);
    }

    @Override
    public int updatePwd(String password, Integer id) {
        return userdao.updatePwd(password,id);
    }
    @Override
    public int findUsersOrganId(Integer id) {
        return userdao.findUsersOrganId(id);
    }

    @Override
    public List<Users> findDeptLeadd(Long deptid) {
        return userdao.findDeptLeadd(deptid);
    }

    @Override
    public List<Users> findUserByOrganId(Integer organId) {
        return userdao.findUserByOrganId(organId);
    }
}
