package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Organization;
import cn.bdqn.oaproject.service.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/liusujun")
public class OrganizationController {
    @Resource
    private OrganizationService organizationService;
    @RequestMapping("addOrganization")
    public String addOrganization(Organization Organization, HttpSession session){
        int rel=organizationService.addOrganization(Organization,session);
        if(rel>0){
            System.out.println("添加成功！");
            return "redirect:/xitongguanli";
        }
        return "redirect:/xitongguanli";

    }
}
