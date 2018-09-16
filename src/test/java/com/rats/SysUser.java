package com.rats;

import com.rats.orm.annotation.AutoCreate;
import com.rats.orm.annotation.SafeDelete;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sys_user")
@SafeDelete
@AutoCreate
public class SysUser implements Serializable {

    @Id //设置为主键值
    @Column(name = "id") //设置数据库中对应的字段名
    private Long userId;

    @Column(name = "status") // 设置数据库中对应的字段名
    private boolean status;

    @Column(name = "user_name")
    private String userName;

    @Transient
    @Column(name = "user_passwd")
    private String userPasswd;

    @Column(name = "create_date")
    private Date createDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }
}



