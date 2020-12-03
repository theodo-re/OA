package cn.bdqn.oaproject.entity;

import java.util.Date;

public class Users {

  private long id;
  private String userName;
  private String passWord;
  private String realName;
  private long organId;
  private long deptId;
  private long sex;
  private long proId;
  private long roleId;
  private long status;
  private Date createdtime;
  private long majer;
  private Organization organization;
  private Dictionary dictionary1;
  private Dictionary dictionary2;
  private Dictionary dictionary3;
  private Dept dept;

  public Dept getDept() {
    return dept;
  }

  public void setDept(Dept dept) {
    this.dept = dept;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }


  public Dictionary getDictionary1() {
    return dictionary1;
  }

  public void setDictionary1(Dictionary dictionary1) {
    this.dictionary1 = dictionary1;
  }

  public Dictionary getDictionary2() {
    return dictionary2;
  }

  public void setDictionary2(Dictionary dictionary2) {
    this.dictionary2 = dictionary2;
  }

  public Dictionary getDictionary3() {
    return dictionary3;
  }

  public void setDictionary3(Dictionary dictionary3) {
    this.dictionary3 = dictionary3;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }


  public long getOrganId() {
    return organId;
  }

  public void setOrganId(long organId) {
    this.organId = organId;
  }


  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }


  public long getSex() {
    return sex;
  }

  public void setSex(long sex) {
    this.sex = sex;
  }


  public long getProId() {
    return proId;
  }

  public void setProId(long proId) {
    this.proId = proId;
  }


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public Date getCreatedtime() {
    return createdtime;
  }

  public void setCreatedtime(Date createdtime) {
    this.createdtime = createdtime;
  }


  public long getMajer() {
    return majer;
  }

  public void setMajer(long majer) {
    this.majer = majer;
  }

}
