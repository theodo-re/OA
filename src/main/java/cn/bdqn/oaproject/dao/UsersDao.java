package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Users;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface UsersDao {
    /**
     * 根据登录名查询
     * @return
     */
    Users findCByName(String uName);
    /**
     * 查询用户（模糊查询+分页）
     */
    List<Users> findUsers(@Param("users")Users users, @Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
    /**
     * 查询用户总条数
     */
    int findUsersCount(Users users);
    /**
     * 添加用户
     */
    int addUsers(Users user);
    /**
     * 根据id查找用户
     */
    Users findUsersById(Integer id);
    /**
     * 根据id删除用户
     */
    int delUser(Integer id);
    /**
     * 修改用户
     */
    int updateUsers(Users users);

    /**
     * 查找用户
     */
    List<Users> findUsersList();
    /**
     * 根据部门id查找部门领导
     */
    Integer findDeptLead(Long deptid);
   /**
     * 根据姓名查询id
     */
    int findByrealName(String name);
    /**
     * 根据姓名查询id
     */
    int findIdName(String name);
    //根据用户名获取部门领导
    String findMajerByName(@Param("name") String name);
}
