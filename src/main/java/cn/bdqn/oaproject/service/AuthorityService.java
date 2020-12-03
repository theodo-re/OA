package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Authority;

public interface AuthorityService {
    /**
     * 根据角色id查询权限管理
     */
    Authority findbyJSId(Integer id);
}
