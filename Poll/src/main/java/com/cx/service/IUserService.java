package com.cx.service;

import com.cx.entity.User;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
public interface IUserService {
    /**
     * 登录 - 根据用户名进行查询
     * @param username 唯一的用户名
     * @return
     */
    User login(String username);
}
