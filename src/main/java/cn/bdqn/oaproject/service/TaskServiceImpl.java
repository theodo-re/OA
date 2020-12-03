package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.CheckDao;
import cn.bdqn.oaproject.dao.TaskDao;
import cn.bdqn.oaproject.entity.Check;
import cn.bdqn.oaproject.entity.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Resource
    private TaskDao tdao;
    @Resource
    private CheckDao cdao;

    @Override
    public List<Task> findAll() {
        return tdao.findAll();
    }

    @Override
    public Task findById(Integer id) {

        return tdao.findById(id);
    }

    @Override
    @Transactional
    public int updateById(Task task, Check check) {
        int rel=-1;
        if (tdao.updateById(task)>0 && cdao.add(check)>0){
            rel=1;
        }
        return rel;
    }

    @Override
    public List<Task> findAllfen(Integer pageIndex, Integer pageSize) {
        pageIndex=(pageIndex-1)*pageSize;
        return tdao.findAllfen(pageIndex,pageSize);
    }
}
