package cn.edu.guet.bean;

import java.sql.Timestamp;

/**
 * @Author liwei
 * @Date 2021-06-24 21:16
 * @Version 1.0
 */
public class Users {

    private String userId;
    private String username;
    private String password;
    private String realName;
    private String email;
    private String state;
    private Timestamp createTime;

    public Users() {

    }

    public Users(String userId, String username, String password, String realName, String email, String state, Timestamp createTime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.email = email;
        this.state = state;
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
