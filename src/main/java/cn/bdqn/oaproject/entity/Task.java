package cn.bdqn.oaproject.entity;


import java.util.Date;

public class Task {

  private long id;
  private String tName;
  private long statusId;
  private long auditId;
  private long createdby;
  private Date createdtime;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String gettName() {
    return tName;
  }

  public void settName(String tName) {
    this.tName = tName;
  }

  public long getStatusId() {
    return statusId;
  }

  public void setStatusId(long statusId) {
    this.statusId = statusId;
  }


  public long getAuditId() {
    return auditId;
  }

  public void setAuditId(long auditId) {
    this.auditId = auditId;
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
