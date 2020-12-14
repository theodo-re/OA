package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptDao {
    /**
     * 查询所在部门
     */
    List<Dept> findDept();
    /**
     * 查询部门
     */
    List<Dept> findDeptByCreatedId(Long id);
    /**
     * 没有部门负责人查询部门
     */
    List<Dept> findDeptByCreatedIdd(Long id);
    /**
     * 修改部门
     */
    int updateDept(Dept dept);
    /**
     * 删除部门
     */
    int delDept(Integer id);
    //根据用户名查出所在部门
    Dept findAllByName(@Param("realName") String realName);
    /**
     * 根据id查询部门信息
     */
    Dept findDeptById(Integer id);
    /**
     * 根据部门id看有没有负责人
     */
    int findDeptFuZeUsers(Integer id);
    /**
     * 没有负责人查询部门信息
     */
    Dept findDeptByIDD(Integer id);
    /**
     * 添加部门
     */
    int addDept(Dept dept);
}
