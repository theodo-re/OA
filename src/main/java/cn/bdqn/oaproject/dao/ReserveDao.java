package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Reserve;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

public interface ReserveDao {
    int addReserve(Reserve reserve);
    //会议室预定管理列表显示
    List<Reserve> findAllreserve( Reserve reserve);
    //测试方法
    Reserve findAll();
    //根据id查找
    Reserve findAllById(@Param("id") Integer id);
    //找到后根据id删除
    int delReserveById(@Param("id") Integer id);
}
