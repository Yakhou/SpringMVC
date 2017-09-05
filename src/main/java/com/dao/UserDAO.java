package com.dao;

import com.domain.UserDO;

import java.util.List;
import java.util.Map;
//@Repository
public interface UserDAO {
    /**
     * 根据用户id删除单个用户信息
     */
    int deleteUser(int id);
    /**
     * 根据多条用户id批量删除用户信息
     */
    int deleteBatchUser(List<Integer>id);
    /**
     * 根据age查询多条用户信息
     */
    List<UserDO> queryUserInfo(int age);
    /**
     * 根据username查询单条用户信息
     */
    UserDO selectUserInfo(String username);
    /**
     * 根据id更新用户信息
     */
    void updateUserInfo(Map<String,Object>map);
    /**
     * 添加用户信息
     */
    int insertUserInfo(UserDO userDO);

}
