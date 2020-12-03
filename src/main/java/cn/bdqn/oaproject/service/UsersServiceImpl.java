package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.LogDao;
import cn.bdqn.oaproject.dao.UsersDao;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Users;
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
            if(password.equals(user.getPassWord())){
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
        if(num==null){
            user.setMajer(0);
        }
        if(num>0 && num!=null){
            user.setMajer(num);
        }

        int rel1=userdao.addUsers(user);

        Log log=new Log();
        Long id=((Users)session.getAttribute("session")).getId();
        log.setUserId(id);
        Long roleId=((Users)session.getAttribute("session")).getRoleId();
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
        Long userId=((Users)session.getAttribute("session")).getId();
        log.setUserId(userId);
        Long roleId=((Users)session.getAttribute("session")).getRoleId();
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
        Long id=((Users)session.getAttribute("session")).getId();
        log.setUserId(id);
        Long roleId=((Users)session.getAttribute("session")).getRoleId();
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
        Integer rel=userdao.findDeptLead(deptid);
        return rel;
    }
}
