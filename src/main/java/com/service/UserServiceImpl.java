package com.service;

import com.dao.UserDAO;
import com.domain.UserDO;
import com.mysql.jdbc.StringUtils;
import com.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO ;

    /**
     * 查询单条数据
     * @param username
     * @return
     */
    public UserDO selectInfoById(String username){
        return userDAO.selectUserInfo(username);
    }

    /**
     * 根据年龄查询多条用户信息
     * @param age
     * @return
     */
    public List<UserDO>queryBatchInfo(int age){
        List<UserDO>list = new ArrayList<UserDO>();
        list=userDAO.queryUserInfo(age);
        return list;
    }

    /**
     * 根据id更新用户信息
     * @param userDO
     * @return
     */
    public Result<Void> updateUserInfo(UserDO userDO){
        Result<Void>result=new Result();
       Map map=new HashMap();
       map.put("id",userDO.getId());
       map.put("age",userDO.getAge());
       map.put("username",userDO.getUsername());
       userDAO.updateUserInfo(map);
       return result;
    }

    /**
     * 插入用户信息
     * @param userDO
     * @return
     */
    public Result<UserDO> insertUser(UserDO userDO){
        Result<UserDO>result=new Result<UserDO>();
        userDAO.insertUserInfo(userDO);
        return result;
    }

    public void deleteBatchUser(List<Integer> id) {

    }

    public void deleteUser(int id) {

    }
}
