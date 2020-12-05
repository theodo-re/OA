package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Affiche;
import cn.bdqn.oaproject.entity.Log;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.service.AfficheService;
import cn.bdqn.oaproject.util.Constants;
import cn.bdqn.oaproject.util.PageSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RequestMapping("/gong")
@Controller
public class afficheController {
    Logger logger = LoggerFactory.getLogger(afficheController.class);
    @Resource
    private AfficheService afficheService;

    /**
     * 跳转页面
     */
    @RequestMapping("/gonggao")
    public String gonggao(Model model,String title,String date,@RequestParam(defaultValue = "1") Integer renfen){
        logger.info("跳转页面=====================");
        PageSupport page = new PageSupport();
        int cuont = afficheService.findAll(title,date);
        int index = (renfen-1)*page.getPageSize();
        List<Affiche> afficheList = afficheService.findfenAll(title,date,index,page.getPageSize());
        page.setTotalCount(cuont);
        page.setCurrentPageNo(renfen);
        model.addAttribute("afficheList",afficheList);
        model.addAttribute("title",title);
        model.addAttribute("date",date);
        model.addAttribute("page",page);
        return "tonggaoguanli";
    }
    /**
     * 添加通告
     * ,String affTitle,Integer affstatus,String startdate,
     *                             String enddate,String pubdate,String affContent
     */
    @RequestMapping("/addaffiche")
    @ResponseBody
    public String addaffiche(HttpSession session,Affiche affiche){
        logger.info("添加通告=====================");
        Users users = (Users) session.getAttribute(Constants.USER_SESSION);
        affiche.setCreatedby(users.getId());
        affiche.setCreatedtime(new Date());
        Log log = new Log();
        log.setUserId(users.getId());
        log.setRoleId(users.getRoleId());
        log.setIncident("张三添加了通告");
        log.setOpedate(new Date());
        int rel = afficheService.insertAff(affiche,log);
        if (rel>0){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }
    /**
     * 删除通告
     */
    @RequestMapping("/delaffiche")
    @ResponseBody
    public String delaffiche(Integer id){
        logger.info("删除通告=====================");
        int rel = afficheService.deleteAff(id);
        if (rel>0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    /**
     * 修改回显
     */
    @RequestMapping("/updateaffiche")
    @ResponseBody
    public Affiche updateaffiche(Integer id){
        logger.info("修改通告=====================");
        Affiche affiche = afficheService.findbyId(id);
        return affiche;
    }

    /**
     * 修改通告
     */
    @RequestMapping("/updateaff")
    @ResponseBody
    public String updateaff(HttpSession session,Affiche affiche){
        logger.info("修改通告=====================");
        Users users = (Users) session.getAttribute(Constants.USER_SESSION);
        affiche.setModifyby(users.getId());
        affiche.setModifytime(new Date());
        int rel = afficheService.updateAff(affiche);
        if (rel>0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

}
