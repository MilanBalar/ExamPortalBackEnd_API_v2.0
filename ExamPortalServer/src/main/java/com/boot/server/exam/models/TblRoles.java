package com.boot.server.exam.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TblRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	private String roleName;


	//relation
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "tblRoles")
	@JsonIgnore
	private Set<TblUsersRole> tblUsersRoles=new HashSet<>();



	public TblRoles(String roleName) {
		super();
		this.roleName = roleName;
	}
	public Set<TblUsersRole> getTblUsersRoles() {
		return tblUsersRoles;
	}
	public void setTblUsersRoles(Set<TblUsersRole> tblUsersRoles) {
		this.tblUsersRoles = tblUsersRoles;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public TblRoles(Long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	public TblRoles() {
		super();
	}



}
