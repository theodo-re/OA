package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.util.LogUtil;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface LogDao {
    /**
     * 查询日志表（模糊查询+分页）
     */
    List<Log> findLog(LogUtil logUtil);

    /**
     * 查询日志表条数
     */
    int findLogCount(LogUtil logUtil);
    /**
     * 添加日志
     */
    int addLog(Log log);

}
