package cn.bdqn.oaproject.entity;


import java.util.Date;

public class Log {

  private long id;
  private long userId;
  private long roleId;
  private String incident;
  private String logcomment;
  private Date opedate;


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


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public String getIncident() {
    return incident;
  }

  public void setIncident(String incident) {
    this.incident = incident;
  }


  public String getLogcomment() {
    return logcomment;
  }

  public void setLogcomment(String logcomment) {
    this.logcomment = logcomment;
  }


  public Date getOpedate() {
    return opedate;
  }

  public void setOpedate(Date opedate) {
    this.opedate = opedate;
  }

}
