package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Dictionary;
import cn.bdqn.oaproject.service.DictionaryService;
import cn.bdqn.oaproject.util.Constants;
import cn.bdqn.oaproject.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/liusujun")
public class dictionaryController {
    @Resource
    private DictionaryService DictionaryService;
    /**
     * 查询角色（分页）
     */
    @RequestMapping("/roleList")
    @ResponseBody
    public Map<String,Object> role(@RequestParam(defaultValue = "1",required = false) Integer pageIndex
                    ){
        int pageSize= Constants.pageSize;//获取当前页大小
        int currentPageNo = pageIndex;//设置当前页码
        int totalCount=DictionaryService.findRoleCount();//总条数
        PageSupport pages=new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);

        int totalPageCount = pages.getTotalPageCount();//计算总页数
        int currentPageNo1=(pageIndex-1)*pageSize;
        List<Dictionary> DictionaryList=DictionaryService.findRoleByJS(currentPageNo1,pageSize);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("DictionaryList",DictionaryList);
        map.put("pageIndex",pageIndex);
        map.put("pages",pages);
        return map;
    }
    /**
     * 查询角色
     */
    @RequestMapping("findRole")
    @ResponseBody
    public List<Dictionary> findRole(){
        List<Dictionary> roleList=DictionaryService.findRole();
        return roleList;
    }
    /**
     * 查询职称
     */
    @RequestMapping("findPro")
    @ResponseBody
    public List<Dictionary> findPro(){
        List<Dictionary> proList=DictionaryService.findPro();
        return proList;
    }
    /**
     * 添加角色
     */
    @RequestMapping("addRole")
    public String addRole(@RequestParam(required = false) Integer valueId,
                          @RequestParam(required = false) String valueName, HttpSession session){
        int rel=DictionaryService.addRole(valueId,valueName,session);
        if(rel>0){
            return "redirect:xitongguanli";
        }
        return "xitongguanli";
    }
    /**
     * 根据id查找角色
     */
    @RequestMapping("findRoleByid")
    @ResponseBody
    public Dictionary findRoleByid(@RequestParam(required = false)Integer valueId){
        Dictionary dictionary=DictionaryService.findRoleById(valueId);
        return dictionary;

    }
    /**
     * 修改角色
     */
    @RequestMapping("updateRole")
    public String updateRole(@RequestParam(required = false)Integer valueId,
            @RequestParam(required = false) String valueName, HttpSession session){
        int rel=DictionaryService.updateRoleById(valueId,valueName,session);
        if(rel>0){
            return "redirect:xitongguanli";
        }
        return "xitongguanli";
    }
    /**
     * 根据id删除角色
     */
    @RequestMapping("delRoleById")
    @ResponseBody
    public int delRoleById(@RequestParam(required = false)Integer valueId, HttpSession session){
        int rel=DictionaryService.delRoleById(valueId,session);
        return rel;
    }
}
