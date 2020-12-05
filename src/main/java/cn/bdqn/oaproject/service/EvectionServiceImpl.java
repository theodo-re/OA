package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.EvectionDao;
import cn.bdqn.oaproject.dao.LogDao;
import cn.bdqn.oaproject.dao.TaskDao;
import cn.bdqn.oaproject.entity.Evection;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Task;
import cn.bdqn.oaproject.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EvectionServiceImpl implements EvectionService{

    @Resource
    EvectionDao evectionDao;

    @Resource
    TaskDao taskDao;

    @Resource
    LogDao logDao;

    @Override
    public boolean add(Evection evection, Task task, Log log) {
        boolean rel = false;
        if (evectionDao.add(evection)>0 && taskDao.add(task)>0 && logDao.add(log)>0){
            rel = true;
        }
        return rel;
    }

    @Override
    public Users findCByName(String uName) {
        return evectionDao.findCByName(uName);
    }
}
