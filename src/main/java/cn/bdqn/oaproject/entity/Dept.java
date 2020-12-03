package cn.bdqn.oaproject.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Dept {

  private Integer id;
  private String deptName;
  private long organId;
  private long userId;
  private String telephone;
  private String phone;
  private String fax;
  private long createdby;
  @DateTimeFormat(pattern = "yyyy—MM-dd")
  @JsonFormat(locale = "yyyy—MM-dd")
  private Date createdtime;
  private long modifyby;
  @DateTimeFormat(pattern = "yyyy—MM-dd")
  @JsonFormat(locale = "yyyy—MM-dd")
  private Date modifytime;
  private Users users;
  private Users createdbyUsers;
  private Organization organization;


  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  public Users getCreatedbyUsers() {
    return createdbyUsers;
  }

  public void setCreatedbyUsers(Users createdbyUsers) {
    this.createdbyUsers = createdbyUsers;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

 /* public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }*/

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  /* public String getDName() {
    return dName;
  }

  public void setDName(String dName) {
    this.dName = dName;
  }*/

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
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
