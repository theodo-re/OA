package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Authority;

public interface AuthorityDao {
    /**
     * 根据角色id查询权限管理
     */
    Authority findbyJSId(Integer id);
}
