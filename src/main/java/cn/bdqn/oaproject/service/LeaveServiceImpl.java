package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.LeaveDao;
import cn.bdqn.oaproject.dao.LogDao;
import cn.bdqn.oaproject.dao.TaskDao;
import cn.bdqn.oaproject.entity.Leave;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Task;
import cn.bdqn.oaproject.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LeaveServiceImpl implements LeaveService{

    @Resource
    LeaveDao leaveDao;

    @Resource
    TaskDao taskDao;

    @Resource
    LogDao logDao;

    @Override
    public boolean add(Leave leave, Task task, Log log) {
        boolean rel = false;
        if (leaveDao.add(leave)>0 && taskDao.add(task)>0 && logDao.add(log)>0){
            rel = true;
        }
        return rel;
    }

    @Override
    public Users findCByName(String uName) {
        return leaveDao.findCByName(uName);
    }
}
