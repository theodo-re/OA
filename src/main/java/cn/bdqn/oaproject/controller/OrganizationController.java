package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Organization;
import cn.bdqn.oaproject.service.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/liusujun")
public class OrganizationController {
    @Resource
    private OrganizationService organizationService;
    @RequestMapping("addOrganization")
    @ResponseBody
    public int addOrganization(Organization Organization, HttpSession session){
        int rel=organizationService.addOrganization(Organization,session);
        return rel;
    }
}
