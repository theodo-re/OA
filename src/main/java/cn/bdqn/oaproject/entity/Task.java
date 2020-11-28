package cn.bdqn.oaproject.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Task {

  private long id;
  private String tName;
  private long statusId;
  private long auditId;
  private long createdby;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date createdtime;
  private Dictionary dic;

  private String auditName;
  private String createName;

  public String getAuditName() {
    return auditName;
  }

  public void setAuditName(String auditName) {
    this.auditName = auditName;
  }

  public String getCreateName() {
    return createName;
  }

  public void setCreateName(String createName) {
    this.createName = createName;
  }

  public Dictionary getDic() {
    return dic;
  }

  public void setDic(Dictionary dic) {
    this.dic = dic;
  }

  public String gettName() {
    return tName;
  }

  public void settName(String tName) {
    this.tName = tName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
