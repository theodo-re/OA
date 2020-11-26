package cn.bdqn.oaproject.entity;


import java.util.Date;

public class Wordrecycle {

  private long id;
  private String rName;
  private long wPro;
  private long folderId;
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


  public String getRName() {
    return rName;
  }

  public void setRName(String rName) {
    this.rName = rName;
  }


  public long getWPro() {
    return wPro;
  }

  public void setWPro(long wPro) {
    this.wPro = wPro;
  }


  public long getFolderId() {
    return folderId;
  }

  public void setFolderId(long folderId) {
    this.folderId = folderId;
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
