package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Memo;

import java.util.List;

public interface MemoDao {
    /**
     * 查询所有便签
     */
    List<Memo> findAll();
    /**
     * 根据id查询便签
     */
    Memo findById(Integer id);
    /**
     * 根据id修改便签
     */
    int updatememo(Memo memo);
    /**
     * 添加便签
     */
    int addMemo(Memo memo);
    /**
     * 根据id删除标签
     */
    int delMemo(Integer id);
}
