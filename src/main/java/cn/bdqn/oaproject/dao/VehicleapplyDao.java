package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Vehicleapply;

import java.util.List;

public interface VehicleapplyDao {
    //用车申请添加
    int addVehapply(Vehicleapply vehicleapply);
    //根据时间查询可用车辆
    List<Vehicleapply> findBehByidTime(Vehicleapply vehicleapply);
}
