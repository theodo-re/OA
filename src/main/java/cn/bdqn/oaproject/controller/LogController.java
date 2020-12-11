package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.service.UsersService;
import cn.bdqn.oaproject.util.Constants;
import cn.bdqn.oaproject.util.Sms;
import cn.bdqn.oaproject.util.validationCodeUtil;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/deng")
public class LogController {
    Logger logger = LoggerFactory.getLogger(LogController.class);
    @Resource
    private UsersService user;
    String yan="";
    String code="";

    /**
     * 转登录页面
     */
    @RequestMapping(value = "/login.html",method = RequestMethod.GET)
    public String login(HttpServletRequest request,Model model){
        logger.info("转登录页面==============================");
        Cookie[] cookies = request.getCookies();
        String name="";
        String password="";
        String num="";
        if(cookies!=null && cookies.length>0){
            for(int i=0;i<cookies.length;i++){
                if(cookies[i].getName().equals("num")){
                    num=cookies[i].getValue();
                }
            }
            for(int i=0;i<cookies.length;i++){
            if(cookies[i].getName().equals("uName")){
                name=cookies[i].getValue();
            }
            if(num!=null && !"".equals(num)){
                if(cookies[i].getName().equals("password")){
                    password=cookies[i].getValue();
                }
            }
            }
        }
        model.addAttribute("name",name);
        model.addAttribute("password",password);
        model.addAttribute("num",num);
        return "login";
    }
    /**
     * 登录
     */
    @RequestMapping(value = "/login.html",method = RequestMethod.POST)
    public String login(String uName, String password, Model m,HttpSession session,
                        String random,HttpServletResponse response){
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
                    session.setMaxInactiveInterval(60*60*24);
                    Cookie cookie = new Cookie("uName",uName);
                    Cookie cookie1 = new Cookie("password",password);
                    cookie.setMaxAge(60*60*72);
                    cookie1.setMaxAge(60*60*72);
                    response.addCookie(cookie);
                    response.addCookie(cookie1);
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

    /**
     * 记住密码
     */
    @RequestMapping("/remember")
    @ResponseBody
    public String remember(String num,HttpServletResponse response){
        if(Integer.parseInt(num)==1){
            Cookie cookie = new Cookie("num",num);
            cookie.setMaxAge(60*60*72);
            response.addCookie(cookie);
        }else {
            Cookie cookie= new Cookie("num", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "";
    }

    /**
     *手机验证码登录
     */
    @RequestMapping("/yan.html")
    public String yan(String phone,String security,Model m,HttpSession session) {
        logger.info("手机验证码登录==============================");
        Users users = user.findPhone(phone);
        if(security!=null && security!=""){
            if(code.equals(security)){
                session.setAttribute(Constants.USER_SESSION,users);
                return "redirect:index1";
            }else {
                m.addAttribute("error3","验证码不正确！");
                return "login";
            }
        }else {
            m.addAttribute("error3","验证码不能为空！");
            return "login";
        }
    }

    /**
     * 异步手机验证
     */
    @RequestMapping("/phoneyan")
    @ResponseBody
    public String phoneyan(String phone) throws ClientException {
        logger.info("异步手机验证==============================");
        Users users = user.findPhone(phone);
        if(users!=null){
            code = RandomStringUtils.randomNumeric(6);
            SendSmsResponse sendSms =Sms.sendSms(phone,code);//填写你需要测试的手机号码
            System.out.println("短信接口返回的数据----------------");
            System.out.println("Code=" + sendSms.getCode());
            System.out.println("Message=" + sendSms.getMessage());
            System.out.println("RequestId=" + sendSms.getRequestId());
            System.out.println("BizId=" + sendSms.getBizId());
            return "验证码已发送！";
        }else {
            return "手机号码不正确！";
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
        return "redirect:login.html";
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
    /**
     * 调到系统管理
     */
    @RequestMapping("/xitongguanli")
    public String xitongguanli(){
        return "xitongguanli";
    }

    /**
     * 忘记密码
     */
    @RequestMapping("/forget")
    public String forget(){
        logger.info("忘记密码===================");
        return "forgetPwd";
    }

    /**
     * 验证手机号
     */
    @RequestMapping("/forgetpwd")
    @ResponseBody
    public Map<String,String> forgetpwd(String phone){
        logger.info("验证手机号===================");
        Users users = user.findPhone(phone);
        Map<String,String> map = new HashMap<>();
        if(users!=null){
            map.put("num","1");
            map.put("id",users.getId()+"");
        }else {
            map.put("num","0");
        }
        return map;
    }

    /**
     * 修改密码
     */
    @RequestMapping("/updatepwd")
    @ResponseBody
    public String updatepwd(String password,Integer id){
        logger.info("修改密码===================");
        int rel = user.updatePwd(password,id);
        if (rel>0){
            return "修改成功，请返回登录！";
        }
        return "修改失败！";
    }
}
