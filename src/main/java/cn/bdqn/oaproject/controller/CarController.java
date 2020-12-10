package cn.bdqn.oaproject.controller;

import cn.bdqn.oaproject.entity.Dept;
import cn.bdqn.oaproject.entity.Users;
import cn.bdqn.oaproject.entity.Vehicle;
import cn.bdqn.oaproject.entity.Vehicleapply;
import cn.bdqn.oaproject.service.DeptService;
import cn.bdqn.oaproject.service.UsersService;
import cn.bdqn.oaproject.service.VehicleService;
import cn.bdqn.oaproject.service.VehicleapplyService;
import cn.bdqn.oaproject.util.Constants;
import cn.bdqn.oaproject.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.spring5.context.SpringContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class CarController {
    @Resource
    VehicleapplyService vehicleapplyService;
    @Resource
    DeptService deptService;
    @Resource
    UsersService usersService;
    @Resource
    VehicleService vehicleService;

    /**
     * 用车申请页面
     * @param
     * @return
     */
    @RequestMapping(value = "yongcheguanli.html",method = RequestMethod.GET)
    public String showIndex(HttpSession session, Model model,@RequestParam(required = false) Integer pageIndex){
        Users user = (Users) session.getAttribute(Constants.USER_SESSION);
        //System.out.println(user.getRealName()+"姓名+++++++++");
        //根据用户名查出所在部门
        Dept dept=deptService.findAllByName(user.getRealName());
        model.addAttribute("dname",dept.getDeptName());
        //根据用户名获取部门领导
        String majer=usersService.findMajerByName(user.getRealName());
        model.addAttribute("majer",majer);
        //显示全部的车辆信息
        //分页
        int pageSize=2;
        List<Vehicle> vehicleList=vehicleService.findAllVehicle(0,pageSize);
        model.addAttribute("vehicleList",vehicleList);
        //设置每页条数
        int pageCount=vehicleService.findPage();//
        PageSupport pageSupport=new PageSupport();
        //pageSupport.setCurrentPageNo(pageIndex);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(pageCount);
        model.addAttribute("pageSupport",pageSupport);


        List<Vehicle> mo=vehicleService.findAllVmodel();
       model.addAttribute("vmodelList",mo);
        return "yongcheguanli";
    }
    //
    @RequestMapping(value = "fenye.html",method=RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> page(Integer index){
        int pageSize=2;
      Map<String ,Object> map=new HashMap<>();
        map.put("index",index);
        index=(index-1)*pageSize;
        List<Vehicle> vehicleList=vehicleService.findAllVehicle(index,pageSize);
        map.put("list",vehicleList);
        return  map;
    };
    //

    //异步处审核人转换为int型
    @RequestMapping(value = "majer.html",method = RequestMethod.POST)
    @ResponseBody
    public int majer(String mejName){
       //根据姓名查询id
        int checkid=usersService.findIdName(mejName);
        return checkid;
    }

    /**
     * 处理用车申请
     * @return
     */
    @RequestMapping(value = "disposeCar.html",method = RequestMethod.POST)
    public String get(Vehicleapply vehicleapply,Model model,@RequestParam(required = false) String cheLiang){
        //通过车辆名称获取车辆编码
        Vehicle vehicle=vehicleService.findVnumberByVmodel(cheLiang);
        vehicleapply.setVnumber(vehicle.getVnumber());
        //通过车辆名称获得id
        vehicleapply.setVehicleId(vehicleService.findIdByVmodel(cheLiang));
        vehicleapply.setVdate(new Date());
        int rel=vehicleapplyService.addVehapply(vehicleapply);
        if(rel>0){
            System.out.println("添加成功：）");
        }else {
            System.out.println("添加成功：(");
        }
        //分页信息
        int pageCount=vehicleService.findPage();//
        int pageSize=2;
        PageSupport pageSupport=new PageSupport();
        //pageSupport.setCurrentPageNo(pageIndex);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(pageCount);
        model.addAttribute("pageSupport",pageSupport);
        List<Vehicle> vehicleList=vehicleService.findAllVehicle(0,pageSize);
        model.addAttribute("vehicleList",vehicleList);
        return "yongcheguanli";
    }
    /**
     * 车辆信息管理
     */
    @RequestMapping("/guanLiCar.html")
    public String cheGuanLi(@RequestParam(required = false) String chePai,
                            @RequestParam(required = false)String cheXing,
                            @RequestParam(required = false)Integer vehId,Model model){

        //添加车辆信息
       int vnumber=(int)((Math.random()*9+1)*10000);//随机生成车辆编号
        //车辆编码不能重复
        //查询全部车辆编码
        List<Vehicle> vehList=vehicleService.findAllVnumber();
        boolean blen=false;
        while (blen=false) {
            blen=true;
            for (int i = 0; i <= vehList.size(); i++) {
                if (Integer.parseInt(vehList.get(i).getVnumber()) == vnumber) {
                    vnumber = (int) ((Math.random() * 9 + 1) * 10000);
                    blen=false;
                    break;
                }
            }
        }
        if((chePai!=null&&!chePai.equals(""))||(cheXing!=null&&!cheXing.equals(""))){
            Vehicle vehicle=new Vehicle();
            vehicle.setVplate(chePai);
            vehicle.setVmodel(cheXing);
            vehicle.setVnumber(""+vnumber);
            vehicle.setCallId(2);
            vehicle.setVcomment(null);
            vehicle.setCreatedby(1);
            vehicle.setCreatedtime(new Date());
            vehicle.setModifyby(1);
            vehicle.setModifytime(new Date());
            int rel=vehicleService.addVehicle(vehicle);
            if(rel>0){
                System.out.println("添加成功：）");
            }else{
                System.out.println("添加成功：（");
            }
            }else{

        }
        //显示车辆
        /*List<Vehicle> vehicleList=vehicleService.findAllVehicle();
        model.addAttribute("vehicleList",vehicleList);*/
        //分页信息
        int pageCount=vehicleService.findPage();//
        int pageSize=2;
        PageSupport pageSupport=new PageSupport();
        //pageSupport.setCurrentPageNo(pageIndex);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(pageCount);
        model.addAttribute("pageSupport",pageSupport);
        List<Vehicle> vehicleList=vehicleService.findAllVehicle(0,pageSize);
        model.addAttribute("vehicleList",vehicleList);
        return "yongcheguanli";
    }
    //删除
    @RequestMapping(value = "deltCar.html",method = RequestMethod.POST)
    @ResponseBody
    public String del(Integer vehid){

       int rel=vehicleService.delVehicleById(vehid);
        if(rel > 0) {
            System.out.println("删除成功：）");
            return "删除成功：）";
        } else {
            System.out.println("删除失败！：（");
            return "删除成功：）";
        }

    }
    //车辆信息异步显示
    @RequestMapping(value = "xiugai.html",method = RequestMethod.POST)
    @ResponseBody
    public Vehicle changeVh(Integer id,Model model){
        Vehicle vehicle=vehicleService.findById(id);
        return vehicle;
    }
    //车辆信息修改处理
    @RequestMapping("changeVeh.html")
    public String changVeh(Vehicle vehicle,HttpSession session,Model model){
        //获取登录人的信息
        Users users=(Users)session.getAttribute(Constants.USER_SESSION);
        vehicle.setModifytime(new Date());
        vehicle.setModifyby(users.getId());
        vehicleService.updateVehicle(vehicle);
        //分页信息
        int pageCount=vehicleService.findPage();//
        int pageSize=2;
        PageSupport pageSupport=new PageSupport();
        //pageSupport.setCurrentPageNo(pageIndex);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(pageCount);
        model.addAttribute("pageSupport",pageSupport);
        List<Vehicle> vehicleList=vehicleService.findAllVehicle(0,pageSize);
        model.addAttribute("vehicleList",vehicleList);
        return "yongcheguanli";
    }
    //异步判断是否修改的数据已存在
    @RequestMapping("vplate.html")
    @ResponseBody
    public String showvpt(String vplate){
       Vehicle vehicle=new Vehicle();
       vehicle.setVplate(vplate);
        if(vehicleService.findByAjax(vehicle)!=null){
            return"";
        }else{
            return "error";
        }
    }
    //异步判断用车时间重复
    @RequestMapping(value = "carTime.html",method = RequestMethod.POST)
    @ResponseBody
    public List<Vehicleapply> carTime(String carName,Vehicleapply vehicleapply){
        //根据车名获得对应id
        int id=vehicleService.findIdByVmodel(carName);
        vehicleapply.setId(id);
        //根据id查找时间
        List<Vehicleapply> vehicleapplyList=vehicleapplyService.findBehByidTime(vehicleapply);
        System.out.println(carName+":获取的车名");
        System.out.println(vehicleapply.getStartdate()+":获取的开始时间");
        System.out.println(vehicleapply.getEnddate()+"：获取的结束时间");
       return vehicleapplyList;


    }

}
