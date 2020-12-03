package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Users;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UsersService {
    /**
     * 根据登录名查询
     * @return
     */
    Object[] findCByName(String uName,String password);
    /**
     * 查询用户（模糊查询+分页）
     */
    List<Users> findUsers(@Param("users") Users users, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
    /**
     * 查询用户总条数
     */
    int findUsersCount(Users users);
    /**
     * 添加用户
     */
    int addUsers(Users user, HttpSession session);
    /**
     * 根据id查找用户
     */
    Users findUsersById(Integer id);
    /**
     * 根据id删除用户
     */
    int delUser(Integer id,HttpSession session);
    /**
     * 修改用户
     */
    int updateUsers(Users users, HttpSession session);
    /**
     * 查找用户
     */
    List<Users> findUsersList();
    /**
     * 根据部门id查找部门领导
     */
    Integer findDeptLead(Long deptid);
}
