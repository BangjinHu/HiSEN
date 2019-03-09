package com.hisen.entity.response;

public class UserLoginResponse extends CommonResponse {
    private String name;
    private Integer userState;
    private Integer userType;
    private String jwt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return "UserLoginResponse{" + "name='" + name + '\'' + ", userState=" + userState + ", userType=" + userType + ", jwt='" + jwt + '\'' + '}';
    }
}
