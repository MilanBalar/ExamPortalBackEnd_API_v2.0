package com.boot.server.exam.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TblUsersRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userRoleId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private TblUser tblUser;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleId")
	private TblRoles tblRoles;




	public TblUsersRole() {
		super();
	}

	public TblUsersRole(Long userRoleId, TblUser tblUser, TblRoles tblRoles) {
		super();
		this.userRoleId = userRoleId;
		this.tblUser = tblUser;
		this.tblRoles = tblRoles;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public TblUser getTblUser() {
		return tblUser;
	}

	public void setTblUser(TblUser tblUser) {
		this.tblUser = tblUser;
	}

	public TblRoles getTblRoles() {
		return tblRoles;
	}

	public void setTblRoles(TblRoles tblRoles) {
		this.tblRoles = tblRoles;
	}



}
