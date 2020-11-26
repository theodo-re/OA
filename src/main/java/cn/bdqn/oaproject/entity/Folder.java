package cn.bdqn.oaproject.entity;


import java.util.Date;

public class Folder {

  private long id;
  private String foldName;
  private String foldPic;
  private String fcomment;
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


  public String getFoldName() {
    return foldName;
  }

  public void setFoldName(String foldName) {
    this.foldName = foldName;
  }


  public String getFoldPic() {
    return foldPic;
  }

  public void setFoldPic(String foldPic) {
    this.foldPic = foldPic;
  }


  public String getFcomment() {
    return fcomment;
  }

  public void setFcomment(String fcomment) {
    this.fcomment = fcomment;
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
