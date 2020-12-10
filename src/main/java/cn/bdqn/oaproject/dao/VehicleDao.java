package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Vehicle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VehicleDao {
    //分页
    int findPage();
    //显示车辆信息列表
    List<Vehicle> findAllVehicle(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
    //添加车辆
    int addVehicle(Vehicle Vehicle);
    //删除
    int delVehicleById(@Param("id") Integer id);
    //根据id查询车辆信息
    Vehicle findById(@Param("id") Integer id);
    //修改
    int updateVehicle(Vehicle vehicle);
    //异步判断是否存在
    Vehicle findByAjax(Vehicle vehicle);
    ////通过车辆名称获得id
    int findIdByVmodel(@Param("vmodel")String vmodel);
    //通过车名查找车辆编码
    Vehicle findVnumberByVmodel(@Param("vmodel") String Vmodel);
    //查找全部车辆名称
    List<Vehicle> findAllVmodel();
    //查找全部车辆编码
    List<Vehicle> findAllVnumber();
}
