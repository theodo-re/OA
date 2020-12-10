package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.VehicleDao;
import cn.bdqn.oaproject.entity.Vehicle;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Resource
    private VehicleDao vehicleDao;

    @Override
    public int findPage() {
        int rel=vehicleDao.findPage();
        return rel;
    }

    @Override
    public List<Vehicle> findAllVehicle(int pageIndex,int pageSize) {
        List<Vehicle> list=vehicleDao.findAllVehicle( pageIndex, pageSize);
        return list;
    }

    @Override
    public int addVehicle(Vehicle Vehicle) {
        int rel=vehicleDao.addVehicle(Vehicle);
        return rel;
    }

    @Override
    public int delVehicleById(Integer id) {
        int rel=vehicleDao.delVehicleById(id);
        return rel;
    }

    @Override
    public Vehicle findById(Integer id) {
        Vehicle vehicle=vehicleDao.findById(id);
        return vehicle;
    }

    @Override
    public int updateVehicle(Vehicle vehicle) {
        int rel=vehicleDao.updateVehicle(vehicle);
        return rel;
    }

    @Override
    public Vehicle findByAjax(Vehicle vehicle) {
        return vehicleDao.findByAjax(vehicle);
    }

    @Override
    public Vehicle findVnumberByVmodel(String Vmodel) {
        return vehicleDao.findVnumberByVmodel(Vmodel);
    }

    @Override
    public List<Vehicle> findAllVmodel() {
        return vehicleDao.findAllVmodel();
    }

    @Override
    public List<Vehicle> findAllVnumber() {
        return vehicleDao.findAllVnumber();
    }

    @Override
    public int findIdByVmodel(String vmodel) {
        return vehicleDao.findIdByVmodel(vmodel);
    }
}
