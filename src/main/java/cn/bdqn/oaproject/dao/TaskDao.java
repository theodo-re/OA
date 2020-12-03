package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Task;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskDao {
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
    int updateById(Task task);
    /**
     * 分页查询所有任务
     */
    List<Task> findAllfen(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);
    /**
    *添加任务
    */
    int add(Task task);
}
