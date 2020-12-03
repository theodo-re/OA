package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.MemoDao;
import cn.bdqn.oaproject.entity.Memo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemoServiceImpl implements MemoService{
    @Resource
    private MemoDao memoDao;

    @Override
    public List<Memo> findAll() {
        return memoDao.findAll();
    }

    @Override
    public Memo findById(Integer id) {
        return memoDao.findById(id);
    }

    @Override
    public int updatememo(Memo memo) {
        return memoDao.updatememo(memo);
    }

    @Override
    public int addMemo(Memo memo) {
        return memoDao.addMemo(memo);
    }

    @Override
    public int delMemo(Integer id) {
        return memoDao.delMemo(id);
    }
}
