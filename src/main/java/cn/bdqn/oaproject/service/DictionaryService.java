package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Dictionary;

import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;

import java.util.List;

public interface DictionaryService {
    /**
     * 查询角色（分页）
     */
    List<Dictionary> findRoleByJS(Integer pageIndex,Integer pageSize);
    /**
     * 查询角色条数
     */
    int findRoleCount();
    /**
     * 查询职称
     */
    List<Dictionary> findPro();
    /**
     * 查询角色
     */
    List<Dictionary> findRole();
    /**
     * 添加角色
     */
    int addRole( Integer valueId, String valueName,HttpSession session);
    /**&
     * 根据id查找角色
     */
    Dictionary findRoleById(Integer valueId);
    /**
     * 根据id修改角色
     */
    int updateRoleById( Integer valueId, String valueName,HttpSession session);
    /**
     * 根据id删除角色
     */
    int delRoleById(Integer valueId, HttpSession session);
     * 根据名称查询值
     */
    List<Dictionary> findByName();
}
