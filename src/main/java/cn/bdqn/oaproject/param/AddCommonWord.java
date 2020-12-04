package cn.bdqn.oaproject.param;

import java.util.Date;

/**
 * @program: oaproject
 * @description:
 * @author: 作者
 * @create: 2020-11-26 20:14
 */
public class AddCommonWord {
    private String fileName;
    private Integer createdBy;
    private Date createdTime;
    private String massage;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
