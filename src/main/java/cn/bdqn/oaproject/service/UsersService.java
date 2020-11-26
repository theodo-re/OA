package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Users;

public interface UsersService {
    /**
     * 根据登录名查询
     * @return
     */
    int findCByName(String uName,String password);
}
