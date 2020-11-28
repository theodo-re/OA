package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Dictionary;

import java.util.List;

public interface DictionaryDao {
    /**
     * 根据名称查询值
     */
    List<Dictionary> findByName();
}
