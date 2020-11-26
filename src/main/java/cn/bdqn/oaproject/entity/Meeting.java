package cn.bdqn.oaproject.entity;

import java.util.Date;

public class Meeting {

  private long id;
  private String mName;
  private String mdescribe;
  private long leisure;
  private long createdby;
  private Date createdtime;
  private long modifyby;
  private Date modifytime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getMName() {
    return mName;
  }

  public void setMName(String mName) {
    this.mName = mName;
  }


  public String getMdescribe() {
    return mdescribe;
  }

  public void setMdescribe(String mdescribe) {
    this.mdescribe = mdescribe;
  }


  public long getLeisure() {
    return leisure;
  }

  public void setLeisure(long leisure) {
    this.leisure = leisure;
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


  public long getModifyby() {
    return modifyby;
  }

  public void setModifyby(long modifyby) {
    this.modifyby = modifyby;
  }


  public Date getModifytime() {
    return modifytime;
  }

  public void setModifytime(Date modifytime) {
    this.modifytime = modifytime;
  }

}
