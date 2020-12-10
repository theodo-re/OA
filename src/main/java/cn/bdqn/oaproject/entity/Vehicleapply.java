package cn.bdqn.oaproject.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Vehicleapply {

  private long id;
  private long vehicleId;
  private String vnumber;
  private String vpeople;
  private String vdriver;
  private String retinue;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date startdate;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date enddate;
  private String destination;
  private long mileage;
  private String reason;
  private long checkId;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date vdate;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(long vehicleId) {
    this.vehicleId = vehicleId;
  }


  public String getVnumber() {
    return vnumber;
  }

  public void setVnumber(String vnumber) {
    this.vnumber = vnumber;
  }


  public String getVpeople() {
    return vpeople;
  }

  public void setVpeople(String vpeople) {
    this.vpeople = vpeople;
  }


  public String getVdriver() {
    return vdriver;
  }

  public void setVdriver(String vdriver) {
    this.vdriver = vdriver;
  }


  public String getRetinue() {
    return retinue;
  }

  public void setRetinue(String retinue) {
    this.retinue = retinue;
  }


  public Date getStartdate() {
    return startdate;
  }

  public void setStartdate(Date startdate) {
    this.startdate = startdate;
  }


  public Date getEnddate() {
    return enddate;
  }

  public void setEnddate(Date enddate) {
    this.enddate = enddate;
  }


  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }


  public long getMileage() {
    return mileage;
  }

  public void setMileage(long mileage) {
    this.mileage = mileage;
  }


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


  public long getCheckId() {
    return checkId;
  }

  public void setCheckId(long checkId) {
    this.checkId = checkId;
  }


  public Date getVdate() {
    return vdate;
  }

  public void setVdate(Date vdate) {
    this.vdate = vdate;
  }

}
