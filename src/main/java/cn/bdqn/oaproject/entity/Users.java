package cn.bdqn.oaproject.entity;

import java.util.Date;

public class Users {

  private long id;
  private String uName;
  private String uPassWord;
  private String realName;
  private long organId;
  private long deptId;
  private long sex;
  private long proId;
  private long roleId;
  private long status;
  private Date createdtime;
  private long majer;
  private String shangsi;
  private Dept dept;
  private Dictionary dictionary;

  public Dictionary getDictionary() {
    return dictionary;
  }

  public void setDictionary(Dictionary dictionary) {
    this.dictionary = dictionary;
  }

  public String getShangsi() {
    return shangsi;
  }

  public void setShangsi(String shangsi) {
    this.shangsi = shangsi;
  }

  public Dept getDept() {
    return dept;
  }

  public void setDept(Dept dept) {
    this.dept = dept;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUName() {
    return uName;
  }

  public void setUName(String uName) {
    this.uName = uName;
  }


  public String getUPassWord() {
    return uPassWord;
  }

  public void setUPassWord(String uPassWord) {
    this.uPassWord = uPassWord;
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
