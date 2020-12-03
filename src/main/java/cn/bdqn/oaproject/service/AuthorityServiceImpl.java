package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.AuthorityDao;
import cn.bdqn.oaproject.entity.Authority;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthorityServiceImpl implements AuthorityService{
    @Resource
    private AuthorityDao authorityDao;

    @Override
    public Authority findbyJSId(Integer id) {
        return authorityDao.findbyJSId(id);
    }
}
