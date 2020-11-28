package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Check;

public interface CheckDao {
    /**
     * 添加审核结果
     */
    int add(Check check);
}
