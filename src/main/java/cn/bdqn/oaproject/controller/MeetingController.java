package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Meeting;
import cn.bdqn.oaproject.entity.Reserve;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.service.MeetingService;
import cn.bdqn.oaproject.service.ReserveService;
import cn.bdqn.oaproject.service.UsersService;
import cn.bdqn.oaproject.util.Constants;
import cn.bdqn.oaproject.util.PageSupport;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.ibatis.annotations.Param;
import org.json.HTTP;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MeetingController {
    @Resource
    MeetingService meetingService;
    @Resource
    ReserveService reserveService;
    @Resource
    UsersService usersService;

    //会议管理
    @RequestMapping(value = "/huiyiguanli.html",method = RequestMethod.GET)
    public String meeting(Model model,HttpSession session){
        List<Meeting> metList=meetingService.findAllMeeting();
        model.addAttribute("metList",metList);
        //进入页面显示出全部的会议室
        //分页数据
        int pageSize=3;
        int pageCount=meetingService.findAllPage();//总数据
        PageSupport pageSupport=new PageSupport();
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(pageCount);
        model.addAttribute("pageSupport",pageSupport);
        List<Meeting> meetingList=meetingService.findAllMet(0,pageSize);
        model.addAttribute("meetList",meetingList);
        Users user = (Users) session.getAttribute(Constants.USER_SESSION);
        model.addAttribute("user",user.getRoleId());


        return "huiyiguanli";
    }
    //分页
    @RequestMapping(value = "fenyeMet.html",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> fenYe(Integer index){
        Map<String,Object> map=new HashMap<>();
        int pageSize=3;
        map.put("index",index);//计算之前传index的值
        index=(index-1)*pageSize;
        List<Meeting> meetingList=meetingService.findAllMet(index,pageSize);
        System.out.println(index+"这是index");

        map.put("meetingList",meetingList);

        return map;
    }
    //

    //处理管理
    @RequestMapping(value = "/huiyicx.html")
    public String meetingShow(@RequestParam(required = false) String  firstTime,
                              @RequestParam(required = false)Integer meetId, Model model,
                              @RequestParam(required = false) String  mName,
                              @RequestParam(required = false) String  reserveby,
                              @RequestParam(required = false) String  rContent,HttpSession session) {
        List<Meeting> meetingList=meetingService.findMeetingByTime(firstTime);
        //session预定时间
        session.setAttribute("firstTime",firstTime);
        //返回meeting表的数据
        model.addAttribute("meetingList",meetingList);
        //回显查询的时间
        model.addAttribute("firstTime",firstTime);
        List<Meeting> metList=meetingService.findAllMeeting();
        model.addAttribute("metList",metList);
        //
        int pageCount=meetingService.findAllPage();//总数据
        PageSupport pageSupport=new PageSupport();
        pageSupport.setPageSize(3);
        pageSupport.setTotalCount(pageCount);
        model.addAttribute("pageSupport",pageSupport);
        List<Meeting> meetingLists=meetingService.findAllMet(0,3);
        model.addAttribute("meetList",meetingLists);
        //
        return "huiyiguanli";
    }
    //点击预定
    @RequestMapping(value = "/huiyiguanliYD.html",method = RequestMethod.POST)
    @ResponseBody
    public String yuDing(@RequestParam(required = false)Integer metid,
                         @RequestParam(required = false)String firstTime,
                         @RequestParam(required = false)String yudRen,
                         @RequestParam(required = false)String huiYiLeix) throws ParseException {
        //进行时间格式转换
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        date=simpleDateFormat.parse(firstTime);
        //
        //根据姓名获得预订人的ID
        int reservebyID=usersService.findIdName(yudRen);
        //创建对象，传值
        Reserve reserve=new Reserve();
        reserve.setMeetId(metid);
        reserve.setStartdate(date);
        reserve.setEnddate(date);
        reserve.setrContent(huiYiLeix);
        reserve.setRecordby(reservebyID);
        reserve.setReserveby(reservebyID);
        reserve.setRecordtime(new Date());
        //调用会议室添加方法
        int rel=reserveService.addReserve(reserve);
        if(rel>0){
            //添加成功后给会议室表修改数据
            meetingService.updateById(metid,reservebyID,new Date());
            return "会议室预定成功！";
        }else {
            return "会议室预定失败！！";
        }
    }
    @RequestMapping(value = "/ydGuanLi.html",method =RequestMethod.POST)
    @ResponseBody
    public List<Reserve> ydGuanli(@RequestParam(required = false)String ydTime,
                                  @RequestParam(required = false)String ydpeople,
                                  @RequestParam(required = false)String ydHuiyi,
                                  @RequestParam(required = false)String ydLeixing,Model model) throws ParseException {
        //进行时间格式转换
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        date=simpleDateFormat.parse(ydTime);
        //根据预订人获取users编号
        int reserveby=usersService.findIdName(ydpeople);
        //创建对象
        Reserve reserve=new Reserve();
        reserve.setStartdate(date);
        reserve.setReserveby(reserveby);
        if(ydHuiyi!=null&&!ydHuiyi.equals("")) {
            //根据会议室名称获得对应id
            int meetingID=meetingService.findIdBynameMeeting(ydHuiyi);
            reserve.setMeetId(meetingID);
        }
        if(!ydLeixing.equals("请选择类型")) {
            reserve.setrContent(ydLeixing);
        }
        List<Reserve> reserveList=reserveService.findAllreserve(reserve);
        return reserveList;
    }

    //判断是否为空
    @RequestMapping(value = "yudingChaXun.html",method = RequestMethod.POST)
    @ResponseBody
    public List<Reserve> hycx(HttpSession session){
        List<Reserve> reserveList= (List<Reserve>) session.getAttribute("reserveList");
        return  reserveList;

    }
    @RequestMapping(value = "/ydQuXiao.html")
    @ResponseBody
    public String ydQuxiao(@RequestParam(required = false)Integer reserveId,Model model){
        Reserve reserve=reserveService.findAllById(reserveId);
        int metId= (int) reserve.getMeetId();
        int rel=meetingService.updateLesureById(metId);
        if(rel>0){
            int delRel=reserveService.delReserveById(reserveId);
           return "取消预定成功：）";
        }else{
            return "取消预定失败！：（";
        }
        /*List<Meeting> metList=meetingService.findAllMeeting();
        model.addAttribute("metList",metList);*/
        /*return "redirect:/huiyiguanli.html";*/
    }
    //会议室添加
    @RequestMapping(value = "/addHuiyi.html",method = RequestMethod.POST)
    @ResponseBody
    public String addhuiyi(@RequestParam(required = false)String huiname,
                           @RequestParam(required = false)String huims,HttpSession session){
        System.out.println(huiname+"会议室名称");
        System.out.println(huims+"会议室描述");

        Meeting meeting = new Meeting();
        meeting.setmName(huiname);
        meeting.setMdescribe(huims);
        meeting.setLeisure(1);
        //获取登录人信息
        Users user = (Users) session.getAttribute(Constants.USER_SESSION);
        meeting.setCreatedby(user.getId());
        meeting.setCreatedtime(new Date());
        meeting.setModifyby(user.getId());
        meeting.setModifytime(new Date());
        int rel = meetingService.addMeeting(meeting);
        if (rel > 0) {
            return "添加成功：）";
        } else {
            return "添加失败！：（";
        }
    }
    /*@RequestMapping(value = "/addHuiyi.html",method = RequestMethod.POST)
    public String addhuiyi(@RequestParam(required = false)String meetingName,
                           @RequestParam(required = false)String meetingMdescribe,
                           @RequestParam(required = false)Integer upMetid,Model model){
        if((meetingName!=null && meetingName.equals("")) || (meetingMdescribe!=null && meetingMdescribe.equals(""))) {
            return "";
        }else if(upMetid==null){
            //判断数据都不为空才添加
            Meeting meeting = new Meeting();
            meeting.setmName(meetingName);
            meeting.setMdescribe(meetingMdescribe);
            meeting.setLeisure(1);
            meeting.setCreatedby(1);
            meeting.setCreatedtime(new Date());
            meeting.setModifyby(2);
            meeting.setModifytime(new Date());

            int rel = meetingService.addMeeting(meeting);
            if (rel > 0) {
                System.out.println("添加成功：）");
            } else {
                System.out.println("添加失败！：（");
            }
        }*/
        /*//显示会议室管理列表
        List<Meeting> metList = meetingService.findAllMeeting();
        model.addAttribute("metList", metList);
        //
        int pageCount=meetingService.findAllPage();//总数据
        PageSupport pageSupport=new PageSupport();
        pageSupport.setPageSize(2);
        pageSupport.setTotalCount(pageCount);
        model.addAttribute("pageSupport",pageSupport);
        List<Meeting> meetingLists=meetingService.findAllMet(0,2);
        model.addAttribute("meetList",meetingLists);
        //
        return "huiyiguanli";
    }*/
    //修改
    @RequestMapping(value = "changeMet.html",method = RequestMethod.POST)
    public String changeMet(Meeting meeting,HttpSession session,Model model){
        //获取登录人信息
        Users user = (Users) session.getAttribute(Constants.USER_SESSION);
        meeting.setModifyby(user.getId());
        meeting.setModifytime(new Date());
        int num=meetingService.updateMetById(meeting);
        if (num > 0) {
            System.out.println("修改成功：）");
        } else {
            System.out.println("修改失败！：（");
        }
        /*int pageCount=meetingService.findAllPage();//总数据
        PageSupport pageSupport=new PageSupport();
        pageSupport.setPageSize(3);
        pageSupport.setTotalCount(pageCount);
        model.addAttribute("pageSupport",pageSupport);
        //
        List<Meeting> meetingLists=meetingService.findAllMet(0,3);
        model.addAttribute("meetList",meetingLists);*/
        return "redirect:/huiyiguanli.html";
    }
    //异步处理修改
    @RequestMapping(value = "/xiugaiHy.html",method = RequestMethod.POST)
    @ResponseBody
    public Meeting xiug(Integer id){
        Meeting meeting=meetingService.findMetById(id);
        System.out.println(meeting.getCreatedtime().toString());
        return meeting;
    }
    @RequestMapping(value ="deltHuiYi.html",method = RequestMethod.POST)
    @ResponseBody
    public String  delt(Integer metid){
        int rel=meetingService.delMetByid(metid);
        if (rel > 0) {
            System.out.println("删除成功：）");
            return "删除成功：）";
        } else {
            System.out.println("删除失败！：（");
            return "删除成功：）";
        }
    }
}
