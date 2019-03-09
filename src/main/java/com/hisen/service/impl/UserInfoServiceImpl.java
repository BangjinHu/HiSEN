package com.hisen.service.impl;

import com.alibaba.fastjson.JSON;
import com.hisen.constant.CommonEnum;
import com.hisen.entity.JWTInfo;
import com.hisen.entity.UserInfo;
import com.hisen.entity.UserInfoExample;
import com.hisen.entity.request.UserLoginRequest;
import com.hisen.entity.response.UserLoginResponse;
import com.hisen.mapper.UserInfoMapper;
import com.hisen.service.UserInfoService;
import com.hisen.util.CookieUtil;
import com.hisen.util.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class UserInfoServiceImpl implements UserInfoService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        log.info("[UserInfoServiceImpl]-[login]-入参:{}", JSON.toJSONString(request));
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andNameEqualTo(request.getName()).andPasswordEqualTo(request.getPassword());
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        log.info("[UserLoginResponse]-[login]-[selectByExample]-出参:{}", JSON.toJSONString(userInfos));
        UserInfo userInfo = userInfos.get(0);
        UserLoginResponse login = new UserLoginResponse();
        if (userInfos == null || userInfos.size() == 0 || !request.getPassword().equals(userInfo.getPassword())) {
            login.setResCode(CommonEnum.LOGIN_FAILD.getCode());
            login.setResMsg(CommonEnum.LOGIN_FAILD.getMsg());
            return login;
        }
        if ("1".equals(userInfo.getUserState())) {
            login.setResCode(CommonEnum.LOGIN_LOCKED.getCode());
            login.setResMsg(CommonEnum.LOGIN_LOCKED.getMsg());
            return login;
        }
        // 生成token
        JWTInfo jwtInfo = new JWTInfo();
        jwtInfo.setPassword(userInfo.getPassword());
        jwtInfo.setUsername(userInfo.getName());
        String jwt = JWTUtil.sign(jwtInfo, Long.valueOf(CommonEnum.JWT_MAXAGE.getMsg()));
        // 放入返回
        login.setJwt(jwt);
        login.setName(userInfo.getName());
        login.setUserType(userInfo.getUserType());
        login.setResCode(CommonEnum.LOGIN_SUCCESS.getCode());
        login.setResMsg(CommonEnum.LOGIN_SUCCESS.getMsg());
        log.info("[UserLoginResponse]-[login]-出参:{}", JSON.toJSONString(login));
        return login;
    }

    @Override
    public Boolean checkJWT(HttpServletRequest req) {
        String jwt = null;
        String name = null;
        Map<String, Cookie> stringCookieMap = CookieUtil.ReadCookieMap(req);
        log.info("[UserLoginResponse]-[checkJWT]-入参:{}", JSON.toJSONString(stringCookieMap));
        // 从cookies中取数据
        if (!stringCookieMap.isEmpty()) {
            jwt = stringCookieMap.get("jwt").getValue();
            name = stringCookieMap.get("name").getValue();
            System.out.println("checkJWT 1:" + jwt + "\t" + name);
        } else {
            // 从Header中取数据
            jwt = req.getHeader("Authorization");
            name = req.getHeader("name");
            System.out.println("checkJWT 2:" + jwt + "\t" + name);
        }
        // 获得加密之前的数据
        JWTInfo jwtInfo = JWTUtil.unsign(jwt, JWTInfo.class);
        // 利用name去查询密码
        String checkJWT = userInfoMapper.checkJWT(jwtInfo.getUsername());
        if ((jwtInfo.getPassword()).equals(checkJWT)) {
            return true;
        }
        return false;
    }
}
