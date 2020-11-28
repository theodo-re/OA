package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Affiche;

import java.util.List;

public interface AffcheDao {
    /**
     * 查询所有公告
     */
    List<Affiche> findAll();
    /**
     * 根据id查询公告
     */
    Affiche findbyId(Integer id);
}
