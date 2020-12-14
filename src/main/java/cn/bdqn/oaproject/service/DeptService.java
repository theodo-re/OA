package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Dept;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface DeptService {
    /**
     * 查询所在部门
     */
    List<Dept> findDept();
    /**
     * 查询部门
     */
    List<Dept> findDeptByCreatedId(Long id);
    /**
     * 修改部门
     */
    int updateDept(Dept dept, HttpSession session);
    /**
     * 删除部门
     */
    int delDept(Integer id,HttpSession session);

    Dept findAllByName(String realName);
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
    int addDept(Dept dept,HttpSession session);
    /**
     * 没有部门负责人查询部门
     */
    List<Dept> findDeptByCreatedIdd(Long id);
}
