package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Vehicle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VehicleService {
    //分页
    int findPage();
    //
    List<Vehicle> findAllVehicle(int pageIndex, int pageSize);
    //添加车辆
    int addVehicle(Vehicle Vehicle);
    //
    int delVehicleById(Integer id);
    //
    Vehicle findById(Integer id);
    int updateVehicle(Vehicle vehicle);
    //异步判断是否存在
    Vehicle findByAjax(Vehicle vehicle);
    Vehicle findVnumberByVmodel(String Vmodel);
    //
    List<Vehicle> findAllVmodel();
    //
    List<Vehicle> findAllVnumber();
    //
    int findIdByVmodel(String vmodel);

}
