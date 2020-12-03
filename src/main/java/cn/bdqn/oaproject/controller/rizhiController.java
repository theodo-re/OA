package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.service.LogService;
import cn.bdqn.oaproject.util.Constants;
import cn.bdqn.oaproject.util.LogUtil;
import cn.bdqn.oaproject.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("liusujun")
public class rizhiController {
    @Resource
    private LogService logService;
    @RequestMapping("logList")
    @ResponseBody
    public Map<String,Object> findLog(
            LogUtil logUtil
    ){
        System.out.println(logUtil.getRealName()+"----------------");
        int pageSize= Constants.pageSize;//获取当前页大小
        int currentPageNo = logUtil.getPageIndex();//设置当前页码
        int totalCount=logService.findLogCount(logUtil);//总条数
        PageSupport pages=new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        logUtil.setPageSize(pages.getPageSize());
        int totalPageCount = pages.getTotalPageCount();//计算总页数
        int currentPageNo1=(logUtil.getPageIndex()-1)*pageSize;
        logUtil.setPageIndex(currentPageNo1);

        List<Log> logList=logService.findLog(logUtil);

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("logList",logList);
        map.put("pages",pages);
        map.put("pageIndex", logUtil.getPageIndex());
        //回显
        String logName=logUtil.getRealName();
        map.put("logName",logName);
        return map;
    }
}