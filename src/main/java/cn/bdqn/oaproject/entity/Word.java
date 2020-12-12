package cn.bdqn.oaproject.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Word {
  private long id;
  private String fileName;
  private long fileVisible;
  private long fileType;
  private String fileAp;
  private String fileRp;
  private String fileMsg;
  private long fileAdd;
  private Integer createdBy;
  @JsonFormat(locale = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createdTime;
  private long modifyBy;
  private Date modifyTime;
  private Integer fileKind;
  private Users users;
  private Dictionary dictionary;
  private long fileState;
  private Integer dept;


  public Integer getDept() {
    return dept;
  }

  public void setDept(Integer dept) {
    this.dept = dept;
  }

  public String getFileAp() {
    return fileAp;
  }

  public void setFileAp(String fileAp) {
    this.fileAp = fileAp;
  }

  public String getFileRp() {
    return fileRp;
  }

  public void setFileRp(String fileRp) {
    this.fileRp = fileRp;
  }

  public long getFileState() {
    return fileState;
  }

  public void setFileState(long fileState) {
    this.fileState = fileState;
  }

  public Dictionary getDictionary() {
    return dictionary;
  }

  public void setDictionary(Dictionary dictionary) {
    this.dictionary = dictionary;
  }

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  public long getFileVisible() {
    return fileVisible;
  }

  public void setFileVisible(long fileVisible) {
    this.fileVisible = fileVisible;
  }


  public long getFileType() {
    return fileType;
  }

  public void setFileType(long fileType) {
    this.fileType = fileType;
  }





  public String getFileMsg() {
    return fileMsg;
  }

  public void setFileMsg(String fileMsg) {
    this.fileMsg = fileMsg;
  }


  public long getFileAdd() {
    return fileAdd;
  }

  public void setFileAdd(long fileAdd) {
    this.fileAdd = fileAdd;
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


  public long getModifyBy() {
    return modifyBy;
  }

  public void setModifyBy(long modifyBy) {
    this.modifyBy = modifyBy;
  }


  public Date getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }


  public Integer getFileKind() {
    return fileKind;
  }

  public void setFileKind(Integer fileKind) {
    this.fileKind = fileKind;
  }

}
