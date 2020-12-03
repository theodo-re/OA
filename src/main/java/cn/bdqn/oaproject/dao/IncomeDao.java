package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Income;
import cn.bdqn.oaproject.entity.Users;

public interface IncomeDao {
    int add(Income income);
    //根据用户名查所在部门及上司
    Users findCByName(String uName);
}
