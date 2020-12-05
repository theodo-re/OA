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
}
