package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.ReserveDao;
import cn.bdqn.oaproject.entity.Reserve;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService{
    @Resource
    ReserveDao reserveDao;
    @Override
    public int addReserve(Reserve reserve) {
        int rel=reserveDao.addReserve(reserve);
        return rel;
    }

    @Override
    public List<Reserve> findAllreserve(Reserve reserve) {
        List<Reserve> list=reserveDao.findAllreserve(reserve);
        return list;
    }

    @Override
    public Reserve findAll() {
        Reserve re=reserveDao.findAll();

        return re;
    }

    @Override
    public Reserve findAllById(Integer id) {
        Reserve re=reserveDao.findAllById(id);
        return re;
    }

    @Override
        //找到后根据id删除
    public int delReserveById(Integer id) {
        int rel=reserveDao.delReserveById(id);
        return rel;
    }
}
