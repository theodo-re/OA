package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Dictionary;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DictionaryDao {
    /**
     * 查询角色（分页）
     */
    List<Dictionary> findRoleByJS(@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
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
    int addRole(@Param("valueId") Integer valueId,@Param("valueName") String valueName);
    /**&
     * 根据id查找角色
     */
    Dictionary findRoleById(Integer valueId);
    /**
     * 根据id修改角色
     */
    int updateRoleById(@Param("valueId") Integer valueId,@Param("valueName") String valueName);
    /**
     * 根据id删除角色
     */
    int delRoleById(Integer valueId);
    /**
     *
     */
}