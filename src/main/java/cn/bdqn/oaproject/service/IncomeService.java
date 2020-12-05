package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.*;

public interface IncomeService {
    boolean add(Income income, Task task, Log log);
    //根据用户名查上司
    Users findCByName(String uName);
}
