package cn.bdqn.oaproject.entity;


import java.util.Date;

public class Folder {

  private Integer id;
  private String foldName;
  private String foldAp;
  private Integer dept;
  private String foldMsg;
  private Integer createdBy;
  private Date createdTime;
  private Integer foldKind;
  private Integer foldState;
  private Integer user;
  private String foldRp;

  public String getFoldRp() {
    return foldRp;
  }

  public void setFoldRp(String foldRp) {
    this.foldRp = foldRp;
  }

  public Integer getDept() {
    return dept;
  }

  public void setDept(Integer dept) {
    this.dept = dept;
  }

  public Integer getUser() {
    return user;
  }

  public void setUser(Integer user) {
    this.user = user;
  }

  public Integer getFoldState() {
    return foldState;
  }

  public void setFoldState(Integer foldState) {
    this.foldState = foldState;
  }

  public Integer getFoldKind() {
    return foldKind;
  }

  public void setFoldKind(Integer foldKind) {
    this.foldKind = foldKind;
  }

  public String getFoldAp() {
    return foldAp;
  }

  public void setFoldAp(String foldAp) {
    this.foldAp = foldAp;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getFoldName() {
    return foldName;
  }

  public void setFoldName(String foldName) {
    this.foldName = foldName;
  }



  public String getFoldMsg() {
    return foldMsg;
  }

  public void setFoldMsg(String foldMsg) {
    this.foldMsg = foldMsg;
  }


  public Integer getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }


  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

}
