package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.VehicleapplyDao;
import cn.bdqn.oaproject.entity.Vehicleapply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VehicleapplyServiceImpl implements VehicleapplyService{
    @Resource
    VehicleapplyDao vehicleapplyDao;

    @Override
    public int addVehapply(Vehicleapply vehicleapply) {
        int rel=vehicleapplyDao.addVehapply(vehicleapply);
        return rel;
    }

    @Override
    public List<Vehicleapply> findBehByidTime(Vehicleapply vehicleapply) {
        return vehicleapplyDao.findBehByidTime(vehicleapply);
    }
}
