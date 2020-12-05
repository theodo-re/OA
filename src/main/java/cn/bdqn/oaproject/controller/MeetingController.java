package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Meeting;
import cn.bdqn.oaproject.entity.Reserve;
import cn.bdqn.oaproject.service.MeetingService;
import cn.bdqn.oaproject.service.ReserveService;
import cn.bdqn.oaproject.service.UsersService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.ibatis.annotations.Param;
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
import java.util.List;

@Controller
public class MeetingController {
    @Resource
    MeetingService meetingService;
    @Resource
    ReserveService reserveService;
    @Resource
    UsersService usersService;

    //会议管理
    @RequestMapping(value = "/huiyiguanli",method = RequestMethod.GET)
    public String meeting(Model model){
        List<Meeting> metList=meetingService.findAllMeeting();
        model.addAttribute("metList",metList);
        //进入页面显示出全部的会议室
        return "huiyiguanli";
    }
    //处理管理
    @RequestMapping(value = "/huiyiguanli.html",method = RequestMethod.POST)
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
        return "huiyiguanli.html";
    }
    //点击预定
    @RequestMapping(value = "/huiyiguanliYD.html",method = RequestMethod.POST)
    public String yuDing( @RequestParam(required = false)Integer meetId, Model model,
                         @RequestParam(required = false) String  mName,
                         @RequestParam(required = false) String  reserveby,
                         @RequestParam(required = false) String  rContent, HttpSession session) throws ParseException {
        List<Meeting> metList=meetingService.findAllMeeting();
        model.addAttribute("metList",metList);
        //获取sesison的时间
        String firstTime=(String )session.getAttribute("firstTime");
        System.out.println(firstTime+"这是预定时间---");
        //进行时间格式转换
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date Startdate=new Date();

            Startdate=simpleDateFormat.parse(firstTime);
            //根据姓名获得预订人的ID
            int reservebyID=usersService.findIdName(reserveby);
        //创建对象，传值
        Reserve reserve=new Reserve();
        reserve.setMeetId(meetId);
        reserve.setStartdate(Startdate);
        reserve.setEnddate(Startdate);
        reserve.setrContent(rContent);
        reserve.setRecordby(reservebyID);
        reserve.setReserveby(reservebyID);
        reserve.setRecordtime(Startdate);
        //调用添加方法
        int rel=reserveService.addReserve(reserve);
        if(rel>0){
            //添加成功后给会议室表修改数据
            meetingService.updateById(meetId,reservebyID,new Date());
            System.out.println("添加成功！");
            return "huiyiguanli.html";
        }else {
            System.out.println("添加失败！！");
            return "huiyiguanli";
        }


        //输出一下当前单选框对应数据库的id
        /*System.out.println(reserve.getStartdate()+"---------这是时间");
        System.out.println(reserve.getRecordtime()+"--系统时间");
        System.out.println(meetId+"---------这是id");
        System.out.println(reserveby+"--预订人");
        System.out.println(rContent+"--这是会议室类型");*/

    }
    @RequestMapping("/ydGuanLi.html")
    public String ydGuanli(@RequestParam(required = false)String ydTime,
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
        System.out.println(ydHuiyi+"会议是名称");
        if(ydHuiyi!=null&&!ydHuiyi.equals("")) {
            //根据会议室名称获得对应id
            int meetingID=meetingService.findIdBynameMeeting(ydHuiyi);
            reserve.setMeetId(meetingID);
        }else{
            reserve.setMeetId(0);
        }
        if(!ydLeixing.equals("请选择类型")) {
            reserve.setrContent(ydLeixing);
        }
        List<Reserve> reserveList=reserveService.findAllreserve(reserve);


        /*for(Reserve r:reserveList){
            System.out.println(r.getId());
            System.out.println(r.getMeeting()==null);
            System.out.println(r.getMeeting().getMName()+"这是会议室名称");
            System.out.println(r.getUsers().getRealName()+"这是预订人姓名");
            System.out.println(r.getrContent()+"这是会议室用途");
            System.out.println(r.getStartdate().toString()+"这是预定时间");
        }*/
        model.addAttribute("reserveList",reserveList);
        List<Meeting> metList=meetingService.findAllMeeting();
        model.addAttribute("metList",metList);
        return "huiyiguanli.html";
    }
    @RequestMapping("/ydQuXiao.html")
    public String ydQuxiao(@RequestParam(required = false)Integer reserveId,Model model){
        Reserve reserve=reserveService.findAllById(reserveId);

        int metId= (int) reserve.getMeetId();
       int rel=meetingService.updateLesureById(metId);
        System.out.println(rel+"返回的id");

       if(rel>0){
           System.out.println("取消预定成功：）");
           int delRel=reserveService.delReserveById(reserveId);
           if(delRel>0){
               System.out.println("删除成功：）");
           }
           else {
               System.out.println("删除失败！：（");
           }
       }else{
           System.out.println("取消预定失败！：（");
       }
        List<Meeting> metList=meetingService.findAllMeeting();
        model.addAttribute("metList",metList);
        return "huiyiguanli.html";
    }
    //会议室添加
    @RequestMapping(value = "/addHuiyi.html",method = RequestMethod.POST)
    public String addhuiyi(@RequestParam(required = false)String meetingName,
                           @RequestParam(required = false)String meetingMdescribe,
                           @RequestParam(required = false)Integer upMetid,Model model){

        if((meetingName!=null && meetingName.equals("")) || (meetingMdescribe!=null && meetingMdescribe.equals(""))) {
            return "";
        }else if(upMetid==null){
            //判断数据都不为空才添加
            Meeting meeting = new Meeting();
            meeting.setMName(meetingName);
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


        }
        System.out.println(upMetid+"id");
        System.out.println(meetingName);
        System.out.println(meetingMdescribe);
        if(upMetid!=0 ){
            //id不等于0时，才能进行修改
            Meeting meeting=new Meeting();
            meeting.setId(upMetid);
            meeting.setMName(meetingName);
            meeting.setMdescribe(meetingMdescribe);
            int num=meetingService.updateMetById(meeting);
            if (num > 0) {
                System.out.println("修改成功：）");
            } else {
                System.out.println("修改失败！：（");
            }
        }
        //显示会议室管理列表
        List<Meeting> metList = meetingService.findAllMeeting();
        model.addAttribute("metList", metList);
        return "huiyiguanli.html";
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
