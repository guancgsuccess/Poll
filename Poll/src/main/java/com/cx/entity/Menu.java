package com.cx.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**   
*    
* 项目名称：filmSystem   
* 类名称：Menu   
* 类描述：   菜单实体类
* 创建人：edwarder   
* 创建时间：2017年10月23日 上午11:36:44   
*       
*/
@Entity
@Table(name="sys_menu")
public class Menu implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer pId;//父菜单id
	private String name;//菜单名称
	private String mUrl;//菜单路径
	private String isParent;//是否是父菜单
	private Set<Role> roles = new HashSet<>();
	
	public Menu() {
		super();
	}
	
	public Menu(Integer id, Integer pId, String name, String mUrl, String isParent) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.mUrl = mUrl;
		this.isParent = isParent;
	}
	@Id
	@GeneratedValue(generator = "gen_menu_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "gen_menu_id", sequenceName = "seq_menu_id", allocationSize = 1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	public String getmUrl() {
		return mUrl;
	}
	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}
	@Column
	public String getIsParent() {
		return isParent;
	}
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	@ManyToMany(mappedBy="menus")
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", pId=" + pId + ", name=" + name + ", mUrl=" + mUrl + ", isParent=" + isParent + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Menu menu = (Menu) o;

		return id != null ? id.equals(menu.id) : menu.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
