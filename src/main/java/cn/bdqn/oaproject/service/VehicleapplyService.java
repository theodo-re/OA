package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Vehicleapply;

import java.util.List;

public interface VehicleapplyService {
    int addVehapply(Vehicleapply vehicleapply);
    List<Vehicleapply> findBehByidTime(Vehicleapply vehicleapply);
}
