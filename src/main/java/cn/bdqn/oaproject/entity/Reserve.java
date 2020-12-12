package cn.bdqn.oaproject.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Reserve {

  private Integer id;
  private long meetId;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date startdate;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date enddate;
  private String rContent;
  private long recordby;
  private long reserveby;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date recordtime;

  //
  private Meeting meeting;//会议表实体
  private Users users;//用户表实体


  //
  public Reserve(){};
  public Reserve(Integer id, long meetId, Date startdate, Date enddate, String rContent, long recordby, long reserveby, Date recordtime) {
    this.id = id;
    this.meetId = meetId;
    this.startdate = startdate;
    this.enddate = enddate;
    this.rContent = rContent;
    this.recordby = recordby;
    this.reserveby = reserveby;
    this.recordtime = recordtime;
  }




  public Meeting getMeeting() {
    return meeting;
  }

  public void setMeeting(Meeting meeting) {
    this.meeting = meeting;
  }

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public long getMeetId() {
    return meetId;
  }

  public void setMeetId(long meetId) {
    this.meetId = meetId;
  }


  public Date getStartdate() {
    return startdate;
  }

  public void setStartdate(Date startdate) {
    this.startdate = startdate;
  }


  public Date getEnddate() {
    return enddate;
  }

  public void setEnddate(Date enddate) {
    this.enddate = enddate;
  }


  public String getrContent() {
    return rContent;
  }

  public void setrContent(String rContent) {
    this.rContent = rContent;
  }

  public long getRecordby() {
    return recordby;
  }

  public void setRecordby(long recordby) {
    this.recordby = recordby;
  }


  public long getReserveby() {
    return reserveby;
  }

  public void setReserveby(long reserveby) {
    this.reserveby = reserveby;
  }


  public Date getRecordtime() {
    return recordtime;
  }

  public void setRecordtime(Date recordtime) {
    this.recordtime = recordtime;
  }

}
