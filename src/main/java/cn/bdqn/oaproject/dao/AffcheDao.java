package cn.bdqn.oaproject.dao;
import cn.bdqn.oaproject.entity.Affiche;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public interface AffcheDao {
    public int findAll(@Param("title") String title,@Param("date") String date);//查询所有
    public List<Affiche> findfenAll(@Param("title") String title,@Param("date") String date,
                           @Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);//分页查询所有

    public int insertAff(Affiche affiche);//添加

    public int updateAff(Affiche affiche);//更改

    public int deleteAff(Integer id);//删除
    /**
     * 根据id查询通告
     */
    Affiche findById(Integer id);
}