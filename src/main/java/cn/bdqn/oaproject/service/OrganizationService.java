package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Organization;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrganizationService {
    /**
     * 查询所在单位
     */
    List<Organization> findOrganization();
    /**
     * 添加机构
     */
    int addOrganization(Organization organization, HttpSession session);
}
