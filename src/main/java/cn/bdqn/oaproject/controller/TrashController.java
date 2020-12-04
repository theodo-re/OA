package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.entity.Word;
import cn.bdqn.oaproject.service.WordService;
import cn.bdqn.oaproject.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: oaproject
 * @description:
 * @author: 作者
 * @create: 2020-12-03 09:01
 */
@Controller
public class TrashController {
    @Resource
    private WordService wordService;



    @GetMapping("/Trash")
    public String trash(){
        System.out.println("进入了  显示试图");
        return "wendanghuishou";
    }

    @GetMapping("/trash1")
    @ResponseBody
    public List<Word> trash2(HttpSession session){
        System.out.println("进入了控制器");
        Users user=(Users)session.getAttribute(Constants.USER_SESSION);
        List<Word> wordList = new ArrayList<>();
        if (user!=null){
            wordList=wordService.findTrashWordByUserId((int) user.getId());
        }else {
            System.out.println("空对象！");
        }
        return wordList;
    }

    @DeleteMapping("/trash")
    @ResponseBody
    public String delTrash(Integer id){

        Integer result=wordService.delFileByFileId(id);
        if (result>0){
            return "删除成功！";
        }else{
            return "删除失败！";
        }
    }

    @PutMapping("/trash")
    @ResponseBody
    public String updateTrash(Integer id){

        Integer result=wordService.updateFileByFileId(id);
        if (result>0){
            return "还原成功！";
        }else{
            return "还原失败！";
        }
    }


}
