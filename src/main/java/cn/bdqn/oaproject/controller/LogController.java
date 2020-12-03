package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.service.UsersService;
import cn.bdqn.oaproject.util.Constants;
import cn.bdqn.oaproject.util.validationCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/deng")
public class LogController {
    Logger logger = LoggerFactory.getLogger(LogController.class);
    @Resource
    private UsersService user;
    String yan="";

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
    public String login(String uName, String password, Model m,HttpSession session,String jizhu,String random){
        logger.info("登录页面==============================");
        Object[] obj = user.findCByName(uName,password);
        if((int)obj[0]==-1){
            m.addAttribute("error","用户名不正确");
            return "login";
        }else if ((int)obj[0]==0){
            m.addAttribute("error1","密码不正确");
            return "login";
        }else{
            if(random!=null && !"".equals(random)){
                if(yan.equalsIgnoreCase(random)){
                    session.setAttribute(Constants.USER_SESSION,(Users)obj[1]);
                    session.setAttribute(Constants.JI,jizhu);
                    return "redirect:index1";
                }else{
                    m.addAttribute("error2","验证码错误！");
                    return "login";
                }
            }else{
                m.addAttribute("error2","验证码不能为空！");
                return "login";
            }

        }
    }
    @RequestMapping("/index1")
    public String main(HttpSession session , Model m){
        logger.info("登录首页==============================");
        Users user = (Users) session.getAttribute(Constants.USER_SESSION);
        m.addAttribute("user",user.getRoleId());
        return "index";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session,Model m){
        logger.info("注销==============================");
        session.removeAttribute(Constants.USER_SESSION);

        if(session.getAttribute(Constants.JI)==null){
            return "login";
        }
        Integer rel = Integer.parseInt(session.getAttribute(Constants.JI).toString()) ;
        m.addAttribute("ji",rel);
        return "login";
    }
    /**
     * 图片验证码测试类
     */
    @RequestMapping("/createImg")
    public void createImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            validationCodeUtil randomValidateCode = new validationCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片
        } catch(Exception e){
            e.printStackTrace();
        }
        //从session中取出随机验证码
        yan=(String) request.getSession().getAttribute("RANDOMREDISKEY");
        System.out.println(request.getSession().getAttribute("RANDOMREDISKEY"));
        //ImageIO.write(image, "JPEG", response.getOutputStream());
    }
}
