package com.hisen.filter;

import com.alibaba.fastjson.JSON;
import com.hisen.constant.CommonEnum;
import com.hisen.entity.JWTInfo;
import com.hisen.entity.response.CommonResponse;
import com.hisen.util.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class JWTCheckInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        response.setCharacterEncoding("utf-8");
        String jwt = request.getHeader("Authorization");
        String name = request.getHeader("name");

        logger.info("JWTCheckInterceptor - jwt:{},name{}",jwt,name);

        if ("".equals(jwt) || "".equals(name) || null == jwt || null == name) {
            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setResCode(CommonEnum.REQUEST_FAILED.getCode());
            commonResponse.setResMsg("非法操作");
            responseMessage(response, response.getWriter(), commonResponse);
            return false;
        }

        // 解密信息
        JWTInfo jwtInfo = JWTUtil.unsign(jwt, JWTInfo.class);

        logger.info("jwt解密之后:{}", JSON.toJSONString(jwtInfo));

        if (jwtInfo == null) {
            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setResCode(CommonEnum.REQUEST_FAILED.getCode());
            commonResponse.setResMsg("token超时,请重新登录");
            responseMessage(response, response.getWriter(), commonResponse);
            return false;
        }
        if (name.equals(jwtInfo.getUsername())) {
            return true;
        } else {
            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setResCode(CommonEnum.REQUEST_FAILED.getCode());
            commonResponse.setResMsg("token校验不通过,请重新登录");
            responseMessage(response, response.getWriter(), commonResponse);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    //请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletResponse response, PrintWriter out,
                                 CommonResponse commonResponse) {
        response.setContentType("application/json; charset=utf-8");
        String json = JSON.toJSONString(commonResponse);
        out.print(json);
        out.flush();
        out.close();
    }
}
