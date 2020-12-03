package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.LogDao;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.util.LogUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class LogServiceImpl implements LogService{
    @Resource
    LogDao logdao;

    @Override
    public List<Log> findLog(LogUtil logUtil) {

        return logdao.findLog(logUtil);
    }

    @Override
    public int findLogCount(LogUtil logUtil) {
        return logdao.findLogCount(logUtil);
    }

    @Override
    public int addLog(Log log) {

        return logdao.addLog(log);
    }
}
