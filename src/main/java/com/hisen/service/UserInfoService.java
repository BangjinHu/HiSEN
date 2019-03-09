package com.hisen.service;

import com.hisen.entity.request.UserLoginRequest;
import com.hisen.entity.response.UserLoginResponse;

import javax.servlet.http.HttpServletRequest;

public interface UserInfoService {
    public UserLoginResponse login(UserLoginRequest request);
    public Boolean checkJWT(HttpServletRequest req);
}
