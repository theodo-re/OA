package cn.bdqn.oaproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/zhu")
public class ZhuCeController {
    Logger logger = LoggerFactory.getLogger(ZhuCeController.class);

    /**
     * 转注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        logger.info("转注册页面==============================");
        return "register";
    }
    /**
     * 异步密码是否相同
     */
    @RequestMapping("/cepwd")
    @ResponseBody
    public String cepwd(String password,String pwd){
        if(!password.equals(pwd)){
            return "密码不相同！";
        }
        return "密码相同！";
    }
    /**
     * 异步注册
     */
    @RequestMapping("/zhuce")
    @ResponseBody
    public String zhuce(String userName,String email,String password){
        return "注册失败！";
    }
}
