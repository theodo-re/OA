package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.DeptDao;
import cn.bdqn.oaproject.dao.LogDao;
import cn.bdqn.oaproject.entity.Dept;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor=Exception.class)
public class DeptServiceImpl implements DeptService{
    @Resource
    private DeptDao deptDao;
    @Resource
    private LogDao logdao;
    @Override
    public List<Dept> findDept() {
        return deptDao.findDept();
    }

    @Override
    public List<Dept> findDeptByCreatedId(Long id) {
        return deptDao.findDeptByCreatedId(id);
    }

    @Override
    public int updateDept(Dept dept, HttpSession session) {
        Long modifyById=((Users)session.getAttribute("session")).getId();
        dept.setModifyby(modifyById);
        dept.setModifytime(new Date());
        int rel1=deptDao.updateDept(dept);
        Log log=new Log();
        Long id=((Users)session.getAttribute("session")).getId();
        log.setUserId(id);
        Long roleId=((Users)session.getAttribute("session")).getRoleId();
        log.setRoleId(roleId);
        log.setIncident("修改了部门");
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
    public int delDept(Integer id,HttpSession session) {


        int rel1=deptDao.delDept(id);
        Log log=new Log();
        Long userId=((Users)session.getAttribute("session")).getId();
        log.setUserId(userId);
        Long roleId=((Users)session.getAttribute("session")).getRoleId();
        log.setRoleId(roleId);
        log.setIncident("删除了部门");
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
    public Dept findAllByName(String realName) {
        return deptDao.findAllByName(realName);
    }


}
