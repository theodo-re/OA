package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LogController {
    Logger logger = LoggerFactory.getLogger(LogController.class);
    @Resource
    private UsersService user;

    /**
     * 转登录页面
     */
    @RequestMapping(value = "/login.html",method = RequestMethod.GET)

    public String login(){
        logger.info("转登录页面==============================");
        return "login";
    }
    /**
     * 登录
     */
    @RequestMapping(value = "/login.html",method = RequestMethod.POST)
    public String login(String uName, String password, Model m, HttpSession session){
        logger.info("登录页面==============================");
        Object[] obj = user.findCByName(uName,password);
        if((int)obj[0]==-1){
            m.addAttribute("error","用户名不正确");
            return "login";
        }else if ((int)obj[0]==0){
            m.addAttribute("error1","密码不正确");
            return "login";
        }else{
           /* System.out.println((Users)obj[1].);*/
            session.setAttribute("session",(Users)obj[1]);
            return "redirect:index1";
        }
    }
    @RequestMapping("/index1")
    public String main(){
        return "index";
    }
    @RequestMapping("/shouye")
    public String main1(){
        return "shouye";
    }
    /**
     * 调到系统管理
     */
    @RequestMapping("/xitongguanli")
    public String xitongguanli(){
        return "xitongguanli";
    }
}
