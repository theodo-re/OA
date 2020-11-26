package cn.bdqn.oaproject.entity;


import java.util.Date;

public class Memo {

  private long id;
  private String mTitle;
  private String mContent;
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


  public String getMTitle() {
    return mTitle;
  }

  public void setMTitle(String mTitle) {
    this.mTitle = mTitle;
  }


  public String getMContent() {
    return mContent;
  }

  public void setMContent(String mContent) {
    this.mContent = mContent;
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
