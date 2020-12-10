package cn.bdqn.oaproject.dao;

import cn.bdqn.oaproject.entity.Meeting;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MeetingDao {

        List<Meeting> findMeetingByTime(@Param("firstTiem")String firstTiem);
        //预定成功后id的会议室表修改为不空闲
        int updateById(@Param("id") int id,@Param("modifyby") int modifyby,@Param("modifytime") Date modifytime);
        //根据会议室名称获得id
        int findIdBynameMeeting(@Param("name")String name);
        //根据id修改会议室为空闲状态
        int updateLesureById(@Param("id")int id);
        //增加会议室
        int addMeeting(Meeting meeting);
        //查询全部的会议室
        List<Meeting> findAllMeeting();
        //修改
        int updateMetById(Meeting meeting);
        //删除
        int delMetByid(@Param("id")Integer id);
        //根据id查询
        Meeting findMetById(@Param("id")Integer id);
        //分页
        int findAllPage();
        //
        List<Meeting> findAllMet(@Param("index") Integer index,@Param("size") Integer pageSize);


}
