package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Reserve;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReserveService {
    int addReserve(Reserve reserve);
    List<Reserve> findAllreserve(Reserve reserve);
    Reserve findAll();
    //
    Reserve findAllById( Integer id);
    //找到后根据id删除
    int delReserveById(@Param("id") Integer id);
}
