package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.LogDao;
import cn.bdqn.oaproject.dao.OrganizationDao;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Organization;
import cn.bdqn.oaproject.entity.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService{
    @Resource
    OrganizationDao organizationDao;
    @Resource
    LogDao logdao;
    @Override
    public List<Organization> findOrganization() {
        return organizationDao.findOrganization();
    }

    @Override
    public int addOrganization(Organization organization, HttpSession session) {
        Long createdByid=((Users)session.getAttribute("session")).getId();
        organization.setCreatedby(createdByid);
        organization.setCreatedtime(new Date());
        int rel1=organizationDao.addOrganization(organization);

        Log log=new Log();
        Long id=((Users)session.getAttribute("session")).getId();
        log.setUserId(id);
        Long roleId=((Users)session.getAttribute("session")).getRoleId();
        log.setRoleId(roleId);
        log.setIncident("添加了机构");
        log.setOpedate(new Date());
        int rel2=logdao.addLog(log);
        int rel=-1;
        List<Integer> nums=new ArrayList<>();
        nums.add(rel1);
        nums.add(rel2);
        for(int i:nums){
            if(i>0){
                rel=1;
            }
        }
        return rel;
    }
}
