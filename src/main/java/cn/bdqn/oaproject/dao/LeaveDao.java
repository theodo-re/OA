package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Leave;
import cn.bdqn.oaproject.entity.Users;

public interface LeaveDao {
    //级联添加
    int add(Leave leave);
    //根据用户名查所在部门及上司
    Users findCByName(String uName);
}
