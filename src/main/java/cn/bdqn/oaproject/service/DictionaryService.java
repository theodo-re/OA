package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Dictionary;

import java.util.List;

public interface DictionaryService {
    /**
     * 根据名称查询值
     */
    List<Dictionary> findByName();
}
