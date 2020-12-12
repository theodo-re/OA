package cn.bdqn.oaproject.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
public class Affiche {

  private long id;
  private String affTitle;
  private long affstatus;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date startdate;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date enddate;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date pubdate;
  private String affContent;
  private long createdby;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date createdtime;
  private long modifyby;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date modifytime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getAffTitle() {
    return affTitle;
  }

  public void setAffTitle(String affTitle) {
    this.affTitle = affTitle;
  }


  public long getAffstatus() {
    return affstatus;
  }

  public void setAffstatus(long affstatus) {
    this.affstatus = affstatus;
  }


  public Date getStartdate() {
    return startdate;
  }

  public void setStartdate(java.sql.Date startdate) {
    this.startdate = startdate;
  }


  public Date getEnddate() {
    return enddate;
  }

  public void setEnddate(java.sql.Date enddate) {
    this.enddate = enddate;
  }


  public Date getPubdate() {
    return pubdate;
  }

  public void setPubdate(java.sql.Date pubdate) {
    this.pubdate = pubdate;
  }


  public String getAffContent() {
    return affContent;
  }

  public void setAffContent(String affContent) {
    this.affContent = affContent;
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
