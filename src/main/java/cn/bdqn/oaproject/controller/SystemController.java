package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.param.Common;
import cn.bdqn.oaproject.service.WordService;
import cn.bdqn.oaproject.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: oaproject
 * @description:
 * @author: 作者
 * @create: 2020-11-28 17:41
 */
@Controller
public class SystemController {

    @Resource
    private WordService wordService;


    @PostMapping("/System/read")
    @ResponseBody
    public Map<String ,Object> findFileText(Integer id){

        System.out.println("进入了读取规章制度控制器");
        Map<String ,Object> map=wordService.findFileAPByFileId(id);
        return map;
    }


    @PutMapping("/System")
    @ResponseBody
    public Map<String,Object> findSystemList(Common common, HttpSession session){
        Users user=(Users)session.getAttribute(Constants.USER_SESSION);
        Integer ZC=wordService.findUserZCById((int) user.getId());
        Map<String ,Object> map=new HashMap<>();
        map=wordService.findSystemList(common);
        map.put("ZC",ZC);
        return map;
    }


}
