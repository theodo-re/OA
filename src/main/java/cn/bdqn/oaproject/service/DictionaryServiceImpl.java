package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.DictionaryDao;

import cn.bdqn.oaproject.dao.LogDao;
import cn.bdqn.oaproject.entity.Dictionary;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.util.Constants;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

import cn.bdqn.oaproject.entity.Dictionary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService{
    @Resource

    private DictionaryDao dictionaryDao;
    @Resource
    LogDao logdao;
    @Override
    public List<Dictionary> findRoleByJS(@Param("pageIndex")Integer pageIndex, @Param("pageSize")Integer pageSize) {
        return dictionaryDao.findRoleByJS(pageIndex,pageSize);
    }

    @Override
    public int findRoleCount() {
        return dictionaryDao.findRoleCount();
    }

    @Override
    public List<Dictionary> findPro() {
        return dictionaryDao.findPro();
    }

    @Override
    public List<Dictionary> findRole() {
        return dictionaryDao.findRole();
    }

    @Override
    public int addRole(Integer valueId, String valueName,HttpSession session) {
        int rel1=dictionaryDao.addRole(valueId,valueName);
        Log log=new Log();
        Long userId=((Users)session.getAttribute(Constants.USER_SESSION)).getId();
        log.setUserId(userId);
        Long roleId=((Users)session.getAttribute(Constants.USER_SESSION)).getRoleId();
        log.setRoleId(roleId);
        log.setIncident("添加了角色");
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
    public Dictionary findRoleById(Integer valueId) {
        return dictionaryDao.findRoleById(valueId);
    }

    @Override
    public int updateRoleById(Integer valueId, String valueName,HttpSession session) {
        int rel1=dictionaryDao.updateRoleById(valueId,valueName);
        Log log=new Log();
        Long userId=((Users)session.getAttribute(Constants.USER_SESSION)).getId();
        log.setUserId(userId);
        Long roleId=((Users)session.getAttribute(Constants.USER_SESSION)).getRoleId();
        log.setRoleId(roleId);
        log.setIncident("修改了角色");
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
    public int delRoleById(Integer valueId, HttpSession session) {
        int rel1 = dictionaryDao.delRoleById(valueId);
        Log log = new Log();
        Long userId = ((Users) session.getAttribute(Constants.USER_SESSION)).getId();
        log.setUserId(userId);
        Long roleId = ((Users) session.getAttribute(Constants.USER_SESSION)).getRoleId();
        log.setRoleId(roleId);
        log.setIncident("删除了角色");
        log.setOpedate(new Date());
        int rel2 = logdao.addLog(log);
        int rel = -1;
        List<Integer> nums = new ArrayList<>();
        nums.add(rel1);
        nums.add(rel2);
        for (int i : nums) {
            if (i > 0) {
                rel = 1;
            }
        }

        return rel;
    }
    @Override
    public List<Dictionary> findByName() {
        return dictionaryDao.findByName();
    }
}
