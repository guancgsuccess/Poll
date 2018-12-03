package com.cx.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**   
*    
* 项目名称：filmSystem   
* 类名称：User   
* 类描述：   管理员实体
* 创建人：edwarder   
* 创建时间：2017年10月13日 上午8:26:31   
*       
*/
@Entity
@Table(name="sys_user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String password;

	private int power;

	private List<Role> roles = new ArrayList<>();
	
	public User() {
	}
	
	public User(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@ManyToMany
	@JoinTable(name="sys_user_role",
				joinColumns = {@JoinColumn(name="user_id",referencedColumnName="id")},
				inverseJoinColumns={@JoinColumn(name="role_id",referencedColumnName="id")})
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Column
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
