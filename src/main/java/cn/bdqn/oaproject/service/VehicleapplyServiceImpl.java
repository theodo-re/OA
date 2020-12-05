package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.VehicleapplyDao;
import cn.bdqn.oaproject.entity.Vehicleapply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VehicleapplyServiceImpl implements VehicleapplyService{
    @Resource
    VehicleapplyDao vehicleapplyDao;

    @Override
    public int addVehapply(Vehicleapply vehicleapply) {
        int rel=vehicleapplyDao.addVehapply(vehicleapply);
        return rel;
    }
}
