package com.service;

import com.domain.UserDO;
import com.util.Result;

import java.util.List;
public interface UserService {
    /**
     *  根据username查询单条用户信息
     * @param username
     * @return
     */
    public UserDO selectInfoById(String username);
    /**
     *  根据age查询多条用户信息
     * @param age
     * @return
     */
    public List<UserDO> queryBatchInfo(int age);

    /**
     * 更新用户的用户名跟密码
     * @param userDO
     */
    public Result<Void> updateUserInfo(UserDO userDO);

    /**
     * 添加用户
     * @return
     */
    public Result<UserDO> insertUser(UserDO userDO);

    /**
     * 删除用户
     * @param id
     */
    public void deleteUser(int id);

    /**
     * 批量删除用户信息
     * @param id
     */
    public void deleteBatchUser(List<Integer>id);


}
