package com.cx.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**   
*    
* 项目名称：filmSystem   
* 类名称：Role   
* 类描述：   
* 创建人：edwarder   
* 创建时间：2017年10月24日 下午4:39:08   
*       
*/
@Entity
@Table(name="sys_role")
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String role;//角色
	private String description;//角色描述
	private String status;//角色状态
	private Set<Menu> menus = new HashSet<>();
	private List<User> users = new ArrayList<>();
	
	public Role() {
		super();
	}

	public Role(Integer id, String role, String description, String status) {
		this.id = id;
		this.role = role;
		this.description = description;
		this.status = status;
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
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Column
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@ManyToMany
	@JoinTable(name="sys_role_menu",
				joinColumns = {@JoinColumn(name="role_id",referencedColumnName="id")},
				inverseJoinColumns={@JoinColumn(name="menu_id",referencedColumnName="id")})
	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	
	@ManyToMany(mappedBy="roles")
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Role role = (Role) o;

		return id != null ? id.equals(role.id) : role.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Role{");
		sb.append("id=").append(id);
		sb.append(", role='").append(role).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append(", status='").append(status).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
