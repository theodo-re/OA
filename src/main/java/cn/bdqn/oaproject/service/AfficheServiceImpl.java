package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.AffcheDao;
import cn.bdqn.oaproject.entity.Affiche;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AfficheServiceImpl implements AfficheService{
    @Resource
    private AffcheDao adao;

    @Override
    public List<Affiche> findAll() {
        return adao.findAll();
    }

    @Override
    public Affiche findbyId(Integer id) {
        return adao.findbyId(id);
    }
}
