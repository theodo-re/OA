package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.DictionaryDao;
import cn.bdqn.oaproject.entity.Dictionary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService{
    @Resource
    private DictionaryDao dao;
    @Override
    public List<Dictionary> findByName() {
        return dao.findByName();
    }
}
