package cn.bdqn.oaproject.param;

import java.util.Date;

/**
 * @program: springbootproject
 * @description:
 * @author: 作者
 * @create: 2020-12-08 11:41
 */
public class UpdateInfo {
    Integer id;
    Integer userId;
    Date date;
    Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
