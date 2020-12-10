package cn.bdqn.oaproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Meeting {

  private long id;
  private String mName;
  private String mdescribe;
  private long leisure;
  private long createdby;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date createdtime;
  private long modifyby;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date modifytime;

  public Meeting(){};
  public Meeting(long id, String mName, String mdescribe, long leisure, long createdby, Date createdtime, long modifyby, Date modifytime) {
    this.id = id;
    this.mName = mName;
    this.mdescribe = mdescribe;
    this.leisure = leisure;
    this.createdby = createdby;
    this.createdtime = createdtime;
    this.modifyby = modifyby;
    this.modifytime = modifytime;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getmName() {
    return mName;
  }

  public void setmName(String mName) {
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
