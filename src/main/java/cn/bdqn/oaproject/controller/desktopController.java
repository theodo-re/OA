package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.*;
import cn.bdqn.oaproject.service.*;
import cn.bdqn.oaproject.util.Constants;
import cn.bdqn.oaproject.util.PageSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/zhuo")
public class desktopController {
    Logger logger = LoggerFactory.getLogger(desktopController.class);
    @Resource
    private TaskService tser;
    @Resource
    private DictionaryService dser;
    @Resource
    private UsersService usersService;
    @Resource
    private AfficheService aser;
    @Resource
    private MemoService memoService;
    @Resource
    private AuthorityService authorityService;

    /**
     * 我的桌面
     * @param m
     * @return
     */
    @RequestMapping("/shouye.html")
    public String main1(Model m,HttpSession session){
        logger.info("我的桌面==============================");
        Users users= ((Users)session.getAttribute(Constants.USER_SESSION));
        List<Task> list = null;
        if(users.getProId()==5){
            list = tser.findAll(null);
        }else{
            list = tser.findAll((int) users.getId());
        }
        List<Affiche> affList = aser.findaffAll();
        List<Memo> memoList = memoService.findAll();
        Authority authority = authorityService.findbyJSId((int) users.getProId());
        m.addAttribute("list",list);
        m.addAttribute("affList",affList);
        m.addAttribute("memoList",memoList);
        m.addAttribute("authority",authority);
        return "shouye";
    }
    /**
     * 查看
     */
    @RequestMapping("/find")
    @ResponseBody
    public Task find(String a){
        logger.info("查看==============================");
        Task task = tser.findById(Integer.parseInt(a));
        return task;
    }

    /**
     * 审核
     * @param a
     * @return
     */
    @RequestMapping("/finddic")
    @ResponseBody
    public Map<String,Object> findDictionary(String a){
        logger.info("审核==============================");
        Map<String,Object> map = new HashMap<String,Object>();
        Task task = tser.findById(Integer.parseInt(a));
        List<Dictionary> list = dser.findByName();
        map.put("task",task);
        map.put("list",list);
        return map;
    }

    /**
     * 审核提交
     */
    @RequestMapping(value = "/shenhe",method = RequestMethod.POST)
    public String shenhe(String zhuangName,String statusId,String auditId,
                         String valueName,Integer shenid,String yijian){
        logger.info("提交==============================");
        int userId = usersService.findByrealName(auditId);
        Task task = new Task();
        task.setId(shenid);
        task.setStatusId(2);
        if(Integer.parseInt(valueName)==1){
            task.setAuditId(userId);
        }else{
            task.setAuditId(0);
        }
        Check check = new Check();
        check.setAuditId(userId);
        check.setResultId(Integer.parseInt(valueName));
        check.setCopinion(yijian);
        check.setCdate(new Date());
        int rel = tser.updateById(task,check);
        if(rel>0){
            System.out.println("审核成功！");
        }else {
            System.out.println("审核失败！");
        }
        return "zhuo/shouye.html";
    }

    /**
     * 公告查看
     * @param id
     * @return
     */
    @RequestMapping("/findgong")
    @ResponseBody
    public Affiche findgong(Integer id){
        logger.info("公告查看==============================");
        Affiche affiche = aser.findbyId(id);
        return affiche;
    }

    /**
     * 便签查看
     */
    @ResponseBody
    @RequestMapping("/findbiancha")
    public Memo findbiancha(Integer id){
        logger.info("便签查看==============================");
        Memo memo = memoService.findById(id);
        return memo;
    }
    /**
     * 转修改页面
     */
    @ResponseBody
    @RequestMapping("/updatebian")
    public Memo updatebian(Integer id){
        logger.info("转便签修改==============================");
        Memo memo1 = memoService.findById(id);
        return memo1;
    }
    /**
     * 提交修改
     *
     */
    @ResponseBody
    @RequestMapping("/biantijiao")
    public String biantijiao(String mTitle, String mContent, Integer xiuid, HttpSession session){
        logger.info("提交便签==============================");
        Memo memo = new Memo();
        memo.setId(xiuid);
        memo.setmTitle(mTitle);
        memo.setmContent(mContent);
        memo.setModifyby(((Users)session.getAttribute(Constants.USER_SESSION)).getId());
        memo.setModifytime(new Date());
        int rel = memoService.updatememo(memo);
        if(rel>0){
            return "修改成功！";
        }else {
            return "修改失败！";
        }

    }
    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping("/addmemo")
    public String addmemo(String addmTitle, String addmContent,HttpSession session){
        logger.info("添加便签==============================");
        Memo memo = new Memo();
        memo.setmTitle(addmTitle);
        memo.setmContent(addmContent);
        memo.setCreatedby(((Users)session.getAttribute(Constants.USER_SESSION)).getId());
        memo.setCreatedtime(new Date());
        int rel = memoService.addMemo(memo);
        if (rel>0){
            return "添加成功！";
        }else {
            return "添加失败！";
        }
    }
    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/delmemo")
    public String delmemo(Integer id){
        logger.info("删除便签==============================");
        int rel = memoService.delMemo(id);
        if (rel>0){
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }
    /**
     * 分页查询任务
     */
    @ResponseBody
    @RequestMapping("/renwufen")
    public PageSupport<Task> renwufen(@RequestParam(required = false) Integer pageIndex,
                                      @RequestParam(required = false) Integer yeshu,
                                      HttpSession session){
        logger.info("分页查询任务==============================");
        if(pageIndex!=null && pageIndex<=0){
            pageIndex=1;
        }
        if (yeshu!=null && pageIndex>yeshu){
            pageIndex=yeshu;
        }
        PageSupport<Task> list = new PageSupport<Task>();
        list.setCurrentPageNo(pageIndex);
        list.setPageSize(Constants.pageSize);
        Users users= ((Users)session.getAttribute(Constants.USER_SESSION));
        List<Task> tasksList = null;
        if(users.getProId()==5){
            tasksList = tser.findAllfen(pageIndex,Constants.pageSize, null);
            list.setTotalCount(tser.findAll(null).size());
        }else{
            tasksList = tser.findAllfen(pageIndex,Constants.pageSize, (int) users.getId());
            list.setTotalCount(tser.findAll((int) users.getId()).size());
        }
        list.setList(tasksList);
        return list;
    }

}
