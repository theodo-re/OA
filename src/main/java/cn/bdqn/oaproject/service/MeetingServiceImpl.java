package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.MeetingDao;
import cn.bdqn.oaproject.entity.Meeting;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService{
    @Resource
    MeetingDao meetingDao;
    @Override
    public List<Meeting> findMeetingByTime(String firstTime) {
        List<Meeting> list=meetingDao.findMeetingByTime(firstTime);
        return list;
    }

    @Override
    public int updateById(Integer id, Integer modifyb, Date modifytime) {
        int rel=meetingDao.updateById(id,modifyb,modifytime);
        return rel;
    }

    @Override
    public int findIdBynameMeeting(String name) {
        int rel=meetingDao.findIdBynameMeeting(name);
        return rel;
    }

    @Override
        //根据id修改会议室为空闲状态

    public int updateLesureById(Integer id) {
        int rel=meetingDao.updateLesureById(id);
        System.out.println(rel+"这是service的rel");
        return rel;
    }

    @Override
    public int addMeeting(Meeting meeting) {
       int rel=meetingDao.addMeeting(meeting);
       return rel;
    }

    @Override
    //查询全部
    public List<Meeting> findAllMeeting() {
        List<Meeting> list=meetingDao.findAllMeeting();
        return list;
    }

    @Override
    public int updateMetById(Meeting meeting) {
       int rel=meetingDao.updateMetById(meeting);
        return rel;
    }

    @Override
    public int delMetByid(Integer id) {
        int rel=meetingDao.delMetByid(id);
        return rel;
    }

    @Override
    public Meeting findMetById(Integer id) {
        Meeting meeting=meetingDao.findMetById(id);
        return meeting;
    }

    @Override
    public int findAllPage() {

        return meetingDao.findAllPage();
    }

    @Override
    public List<Meeting> findAllMet(Integer index, Integer pageSize) {
        return meetingDao.findAllMet(index,pageSize);
    }


}
