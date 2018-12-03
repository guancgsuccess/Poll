package com.cx.dao;

import com.cx.entity.Role;

import java.util.List;
import java.util.Set;

/**
 * 角色接口
 */
public interface IRoleDao {

    /**
     * 保存角色信息
     * @param role
     */
    void save(Role role);

    /**
     * 查询所有的角色信息
     * @return
     */
    List<Role> findAll();
}
