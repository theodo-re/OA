package cn.bdqn.oaproject.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Memo {

  private long id;
  private String mTitle;
  private String mContent;
  private long createdby;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date createdtime;
  private long modifyby;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date modifytime;

  private Users user;

  public String getmTitle() {
    return mTitle;
  }

  public void setmTitle(String mTitle) {
    this.mTitle = mTitle;
  }

  public String getmContent() {
    return mContent;
  }

  public void setmContent(String mContent) {
    this.mContent = mContent;
  }

  public Users getUser() {
    return user;
  }

  public void setUser(Users user) {
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
