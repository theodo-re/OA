package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Evection;
import cn.bdqn.oaproject.entity.Users;

public interface EvectionDao {
    int add(Evection evection);
    //根据用户名查所在部门及上司
    Users findCByName(String uName);
}
