package cn.bdqn.oaproject.entity;


import java.util.Date;

public class Dept {

  private long id;
  private String dName;
  private long organId;
  private long userId;
  private String telephone;
  private String phone;
  private String fax;
  private long createdby;
  private Date createdtime;
  private long modifyby;
  private Date modifytime;

  public String getdName() {
    return dName;
  }

  public void setdName(String dName) {
    this.dName = dName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getOrganId() {
    return organId;
  }

  public void setOrganId(long organId) {
    this.organId = organId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
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
