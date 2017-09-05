package com.controller;

import com.domain.UserDO;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录控制器，确认登录信息
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
    @Autowired
     private UserService userService;
    @RequestMapping("/doLogin")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        /**
         * 查询单条用户信息放入userdo
         */
        UserDO userDO = userService.selectInfoById(username);
        if (userDO==null){
            request.setAttribute("errorMsg","用户名不存在");
            return new ModelAndView("forword:/login.html");
        }else if (userDO.getPassword()!=password){
            request.setAttribute("errorMsg","密码不正确");
            return new ModelAndView("forword:/login.html");
        }
        else{
                setSessionUser(request,userDO);
                return new ModelAndView("success");
        }
    }

}
