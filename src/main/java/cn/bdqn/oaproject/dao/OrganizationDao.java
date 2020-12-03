package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Organization;

import java.util.List;

public interface OrganizationDao {
    /**
     * 查询所在单位
     */
    List<Organization> findOrganization();
    /**
     * 添加机构
     */
    int addOrganization(Organization organization);
}
