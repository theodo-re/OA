package cn.bdqn.oaproject.entity;


import java.util.Date;

public class Evection {

  private long id;
  private long userId;
  private long deptId;
  private Date startdate;
  private Date enddate;
  private String destination;
  private long traffic;
  private String incident;
  private String etask;
  private double money;
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


  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }


  public long getTraffic() {
    return traffic;
  }

  public void setTraffic(long traffic) {
    this.traffic = traffic;
  }


  public String getIncident() {
    return incident;
  }

  public void setIncident(String incident) {
    this.incident = incident;
  }


  public String getEtask() {
    return etask;
  }

  public void setEtask(String etask) {
    this.etask = etask;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
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
