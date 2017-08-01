package com.fjw.myapp.model;

/**用户
 * Created by 范佳伟 on 2017/7/31.
 */

public class User {

    private String username;
    private String password;

    private String randomCode;

    private String registerTime;

    private String lastLoginTime;

    private String loginToken;

    private String TokenTime;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String loginToken) {
        this.username = username;
        this.password = password;
        this.loginToken = loginToken;
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

    public String getRandomCode() {
        return randomCode;
    }

    public void setRandomCode(String randomCode) {
        this.randomCode = randomCode;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getTokenTime() {
        return TokenTime;
    }

    public void setTokenTime(String tokenTime) {
        TokenTime = tokenTime;
    }
}
