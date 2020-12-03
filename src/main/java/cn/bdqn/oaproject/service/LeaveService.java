package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Leave;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Task;
import cn.bdqn.oaproject.entity.Users;

public interface LeaveService {
    //级联添加
    boolean add(Leave leave, Task task, Log log);
    //根据用户名查上司
    Users findCByName(String uName);
}
