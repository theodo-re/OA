package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Check;
import cn.bdqn.oaproject.entity.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskService {

    /**
     * 查询所有任务
     */
    List<Task> findAll();
    /**
     * 根据id查询任务
     */
    Task findById(Integer id);
    /**
     * 根据id修改任务
     */
    int updateById(Task task, Check check);
    /**
     * 分页查询所有任务
     */
    List<Task> findAllfen(Integer pageIndex,Integer pageSize);
}
