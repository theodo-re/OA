package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Dept;
import cn.bdqn.oaproject.entity.Folder;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.entity.Word;
import cn.bdqn.oaproject.service.DeptService;
import cn.bdqn.oaproject.service.WordService;
import cn.bdqn.oaproject.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: oaproject
 * @description:
 * @author: 作者
 * @create: 2020-12-01 16:55
 */
@Controller
public class PartController {
    @Resource
    WordService wordService;

    @Resource
    DeptService deptService;


    @PostMapping("/dept")
    @ResponseBody
    public Dept findDept(HttpSession session){
        Users user=(Users) session.getAttribute(Constants.USER_SESSION);
        int deptId=0;
        if (user!=null){
            deptId=(int) user.getDeptId();
        }
        Dept dept=deptService.findDeptById(deptId);

        return dept;
    }


    @PostMapping("/Folder")
    @ResponseBody
    public String addFolder(Folder folder,HttpSession session){
        Users user=(Users) session.getAttribute(Constants.USER_SESSION);
        folder.setDept((int) user.getDeptId());
        Integer result=wordService.addFold(folder);
        if (result>0){
            return "添加成功！";
        }else if(result<0){
            return "文件夹已存在！";
        }else {
            return "添加失败！";
        }
    }


    @PostMapping("/Part")
    @ResponseBody
    public Map<String ,Object> findPart(HttpSession session){
        Users user=(Users)session.getAttribute(Constants.USER_SESSION);
        Integer ZC=0;
        if (user!=null){
            ZC=wordService.findUserZCById((int) user.getId());
        }
        Map<String ,Object> map=new HashMap<>();
        if (user!=null){
            List<Folder> folderList=wordService.findFolderByDeptId((int) user.getDeptId());
            List<Word> wordList=wordService.findDeptWordByDeptId((int) user.getDeptId());
            List<Word> wordList2=wordService.findWordListByUserId((int) user.getId());

            map.put("user",user);
            map.put("foldlist",folderList);
            map.put("ZC",ZC);
            map.put("wordlist1",wordList);
            map.put("wordlist2",wordList2);
        }
        return map;
    }
}
