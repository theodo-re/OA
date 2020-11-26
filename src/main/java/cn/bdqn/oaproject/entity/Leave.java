package cn.bdqn.oaproject.entity;


import java.util.Date;

public class Leave {

  private long id;
  private long userId;
  private long deptId;
  private Date startdate;
  private Date enddate;
  private long leaveday;
  private long ltype;
  private String destination;
  private long checkId;
  private long createdby;
  private Date createdtime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
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


  public long getLeaveday() {
    return leaveday;
  }

  public void setLeaveday(long leaveday) {
    this.leaveday = leaveday;
  }


  public long getLtype() {
    return ltype;
  }

  public void setLtype(long ltype) {
    this.ltype = ltype;
  }


  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }


  public long getCheckId() {
    return checkId;
  }

  public void setCheckId(long checkId) {
    this.checkId = checkId;
  }


  public long getCreatedby() {
    return createdby;
  }

  public void setCreatedby(long createdby) {
    this.createdby = createdby;
  }


  public Date getCreatedtime() {
    return createdtime;
  }

  public void setCreatedtime(Date createdtime) {
    this.createdtime = createdtime;
  }

}
