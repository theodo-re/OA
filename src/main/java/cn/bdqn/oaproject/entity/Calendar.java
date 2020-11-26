package cn.bdqn.oaproject.entity;


import java.util.Date;

public class Calendar {

  private long id;
  private String calTitle;
  private Date startdate;
  private Date enddate;
  private long typeId;
  private long address;
  private long userId;
  private String calContent;
  private long createdby;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCalTitle() {
    return calTitle;
  }

  public void setCalTitle(String calTitle) {
    this.calTitle = calTitle;
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


  public long getTypeId() {
    return typeId;
  }

  public void setTypeId(long typeId) {
    this.typeId = typeId;
  }


  public long getAddress() {
    return address;
  }

  public void setAddress(long address) {
    this.address = address;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getCalContent() {
    return calContent;
  }

  public void setCalContent(String calContent) {
    this.calContent = calContent;
  }


  public long getCreatedby() {
    return createdby;
  }

  public void setCreatedby(long createdby) {
    this.createdby = createdby;
  }

}
