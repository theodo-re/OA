package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Evection;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Task;
import cn.bdqn.oaproject.entity.Users;

public interface EvectionService {
    boolean add(Evection evection, Task task, Log log);
    //根据用户名查所在部门及上司
    Users findCByName(String uName);
}
