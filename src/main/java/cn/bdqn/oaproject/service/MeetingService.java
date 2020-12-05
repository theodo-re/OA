package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.entity.Meeting;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MeetingService {
    List<Meeting> findMeetingByTime(String firstTime);
    //
    int updateById( Integer id,Integer modifyb ,Date modifytime);
    //
    int findIdBynameMeeting(String name);
    //根据id修改会议室为空闲状态
    int updateLesureById( Integer id);
    //增加会议室
    int addMeeting(Meeting meeting);
    //查询全部
    List<Meeting> findAllMeeting();
    //
    int updateMetById(Meeting meeting);
    //删除
    int delMetByid(Integer id);
}
