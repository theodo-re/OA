package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Users;
import org.apache.ibatis.annotations.Param;

public interface UsersDao {
    /**
     * 根据登录名查询
     * @return
     */
    Users findCByName(String uName);
    //根据预订人查出编号
    int findIdByName(@Param("name") String name);
}
