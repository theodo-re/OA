package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Users;

public interface UsersDao {
    /**
     * 根据登录名查询
     * @return
     */
    Users findCByName(String uName);
    /**
     * 根据姓名查询id
     */
    int findByrealName(String name);
}
