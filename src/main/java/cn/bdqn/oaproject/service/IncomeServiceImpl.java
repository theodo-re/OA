package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.IncomeDao;
import cn.bdqn.oaproject.dao.LogDao;
import cn.bdqn.oaproject.dao.TaskDao;
import cn.bdqn.oaproject.entity.Income;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Task;
import cn.bdqn.oaproject.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IncomeServiceImpl implements IncomeService{

    @Resource
    IncomeDao incomeDao;

    @Resource
    TaskDao taskDao;

    @Resource
    LogDao logDao;

    @Override
    public boolean add(Income income, Task task, Log log) {
        boolean rel = false;
        if (incomeDao.add(income)>0 && taskDao.add(task)>0 && logDao.add(log)>0){
            rel = true;
        }
        return rel;
    }

    @Override
    public Users findCByName(String uName) {
        return incomeDao.findCByName(uName);
    }
}
