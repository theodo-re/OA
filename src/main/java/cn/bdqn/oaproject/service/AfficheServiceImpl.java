package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.AffcheDao;
import cn.bdqn.oaproject.dao.LogDao;
import cn.bdqn.oaproject.entity.Affiche;
import cn.bdqn.oaproject.entity.Log;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AfficheServiceImpl implements AfficheService{
     @Resource
     private AffcheDao affcheDao;
     @Resource
     private LogDao logDao;

    @Override
    public List<Affiche> findfenAll(String title, String date, Integer pageIndex, Integer pageSize) {
        return affcheDao.findfenAll(title, date, pageIndex, pageSize);
    }

    @Override
    public int findAll(String title,String date){
        return affcheDao.findAll(title,date);
    }

    @Override
    public int insertAff(Affiche affiche,Log log) {
        int rel=-1;
        if (affcheDao.insertAff(affiche)>0 && logDao.addlog(log)>0){
            rel=1;
        }
        return rel;
    }

    @Override
    public int updateAff(Affiche affiche) {
        return affcheDao.updateAff(affiche);
    }

    @Override
    public int deleteAff(Integer id){
        return affcheDao.deleteAff(id);
    }

    @Override
    public Affiche findById(Integer id) {
        return affcheDao.findById(id);
    }
}
