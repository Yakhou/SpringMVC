package com.controller;

import com.domain.UserDO;
import com.util.CommonConstant;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    /**
     * 获取session中的用户对象
     * @param request
     * @return
     */
    protected UserDO getSessionUser(HttpServletRequest request){
        return (UserDO) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
    }

    /**
     * 将用户对象保存在session中
     * @param request
     * @param userDO
     */
    protected void setSessionUser(HttpServletRequest request,UserDO userDO){
        request.getSession().setAttribute(CommonConstant.USER_CONTEXT,userDO);
    }
}
