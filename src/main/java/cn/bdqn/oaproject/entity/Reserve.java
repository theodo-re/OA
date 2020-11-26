package cn.bdqn.oaproject.entity;


import java.util.Date;

public class Reserve {

  private long id;
  private long meetId;
  private Date startdate;
  private Date enddate;
  private String rContent;
  private long recordby;
  private long reserveby;
  private Date recordtime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
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


  public String getRContent() {
    return rContent;
  }

  public void setRContent(String rContent) {
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
