package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Affiche;
import cn.bdqn.oaproject.entity.Log;

import java.util.List;
import java.io.IOException;
import java.util.List;
public interface AfficheService {
    /**
     * @param id 参数
     * @return User 返回类型
     * @throws Exception 异常
     * @desc 根据ID查询公告信息
     */
    public int findAll(String title,String date);//查询所有

    public List<Affiche> findfenAll(String title,String date, Integer pageIndex,Integer pageSize);//分页查询所有

    public int insertAff(Affiche affiche, Log log);//添加

    public int updateAff(Affiche affiche);//更改

    public int deleteAff(Integer id);//删除
    /**
     * 查询所有公告
     */
    List<Affiche> findaffAll();
 
    /**
     * 根据id查询公告
     */
    Affiche findbyId(Integer id);
}
