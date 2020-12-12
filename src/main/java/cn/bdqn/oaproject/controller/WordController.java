package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Folder;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.entity.Word;
import cn.bdqn.oaproject.param.AddCommonWord;
import cn.bdqn.oaproject.param.Common;
import cn.bdqn.oaproject.service.WordService;
import cn.bdqn.oaproject.util.Constants;
import cn.bdqn.oaproject.util.Fixed;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: oaproject
 * @description:
 * @author: 作者
 * @create: 2020-11-25 15:06
 */
@Controller
public class WordController {

    @Resource
    private WordService wordService;

    @PutMapping("/abs")
    @ResponseBody
    public Map<String ,Object> addCompanyWord(HttpSession session){
        Users user=(Users)session.getAttribute(Constants.USER_SESSION);
        Map<String,Object> map=new HashMap<>();
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("当前时间："+simpleDateFormat);
        if (user!=null){
            map.put("time",simpleDateFormat.format(date));
            map.put("userId",user.getId());
            map.put("userName",user.getRealName());
        }
        return map;
    }

    @GetMapping("/User")
    @ResponseBody
    public List<Users> findUsers(HttpSession session){
        Users user=(Users)session.getAttribute(Constants.USER_SESSION);
        int id=0;
        if (user!=null){
            id=(int) user.getDeptId();
        }
        List<Users> usersList=wordService.findUserByDeptId(id);
        return usersList;
    }

    @DeleteMapping("/Word")
    @ResponseBody
    public int deleteWord(Integer id,HttpSession session) {
        Users user=(Users)session.getAttribute(Constants.USER_SESSION);
        int userId=0;
        int result=0;
        if (user!=null){
            userId=(int)user.getId();
            result = wordService.updateFileStateByFileId(id,userId,0);
        }
        return result;
    }

    @PostMapping("/Word")
    @ResponseBody
    public String addCommonWord(Word word, MultipartFile addfile, HttpSession session) {
        Users user=(Users) session.getAttribute(Constants.USER_SESSION);
        int id=0;
        if (user!=null){
            id=(int)user.getId();
        }
        String fileName = addfile.getOriginalFilename();//获取包含扩展名的文件名
        word.setFileName(fileName.substring(0, fileName.length() - 4));//获取不包含扩展名的文件名
        String lastName = fileName.substring(fileName.lastIndexOf(".") + 1);//获取扩展名
        int filetype = wordService.findFileTypeByLastName(lastName);//通过扩展名获取文件类型
        String apath = null;
        String rpath = null;
        word.setFileType(filetype);
        File file = null;
        int i = -1;
        if (word.getFileKind() == 1) { //判断文件所属
            apath = Fixed.COMPANY_FILE_AP + fileName;//绝对路径
            rpath = Fixed.COMPANY_FILE_RP + fileName;//相对路径
            if (!lastName.equalsIgnoreCase("doc") && !lastName.equalsIgnoreCase("txt")) {//判断文件格式是否符合
                return "公司文档只能是doc或者txt文件!";
            }
        } else if (word.getFileKind() == 2) {
            apath = Fixed.SYSTEM_FILE_AP + fileName;//绝对路径
            rpath = Fixed.SYSTEM_FILE_RP + fileName;//相对路径
            if (!lastName.equalsIgnoreCase("txt")) {
                return "规章制度必须是txt文件！";
            }
        }
        else if(word.getFileKind()==3){
            apath=Fixed.DEPT_FILE_AP+fileName;//绝对路劲
            rpath=Fixed.DEPT_FILE_RP+fileName;//相对路径
            if (!lastName.equalsIgnoreCase("doc") && !lastName.equalsIgnoreCase("txt")) {//判断文件格式是否符合
                return "部门文档只能是doc或者txt文件!";
            }
            word.setDept((int)user.getDeptId());
        }else if(word.getFileKind()==4){
            Folder folder =wordService.findfoldApByUserId(id);
            apath=folder.getFoldAp()+fileName;//绝对路劲
            rpath=folder.getFoldRp()+fileName;//相对路径
            if (!lastName.equalsIgnoreCase("doc") && !lastName.equalsIgnoreCase("txt")) {//判断文件格式是否符合
               return "个人文档只能是doc或者txt文件!";
            }
            word.setDept((int) user.getDeptId());
        }
        word.setFileAp(apath);
        word.setFileRp(rpath);
        file = new File(apath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {//验证要添加的文档是否存在
            try {
                addfile.transferTo(file);
                i = wordService.addCompanyFile(word);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return "该文件已存在";//存在要添加的文件
        }
        if (i > 0) {
            return "添加成功";
        } else {
            return  "添加失败！";
        }

    }

    @PutMapping("/Word")
    @ResponseBody
    public Map<String, Object> sousuo(Common common,HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        map.put("fileName",common.getwName());
        map.put("createdBy",common.getCreateBy());
        Users user=(Users)session.getAttribute(Constants.USER_SESSION);
        Integer ZC=0;
        if (user!=null){
            ZC=wordService.findUserZCById((int)user.getId());
        }
        int pageCount = 1;
        int pageIndex = common.getPageIndex();

        List<Word> words = wordService.findWordList(common);
        Integer count = wordService.findCommonWordCount(common);
        if (count != null) {
            if (count % Fixed.PAGE_SIZE != 0) {
                pageCount = (count / Fixed.PAGE_SIZE) + 1;
            } else {
                pageCount = count / Fixed.PAGE_SIZE;
            }
        }
        map.put("ZC",ZC);
        map.put("list", words);
        map.put("count", count);
        map.put("pageIndex", pageIndex);
        map.put("pageCount", pageCount);
        return map;
    }

    @GetMapping("/wendang")
    public String show() {

        return "wendangliebiao";
    }
}
