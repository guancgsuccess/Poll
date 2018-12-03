package com.cx.dao;

import com.cx.entity.User;

/**
 * 用户接口
 */
public interface IUserDao {

    /**
     * 保存用户
     * @param user
     */
    void save(User user);

    /**
     * 根据用户名称进行查询
     * 用户名称是唯一的
     * @param username
     * @return
     */
    User getByUsername(String username);
}
