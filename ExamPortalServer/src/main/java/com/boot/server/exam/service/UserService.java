package com.boot.server.exam.service;

import java.util.Set;

import com.boot.server.exam.models.TblUser;
import com.boot.server.exam.models.TblUsersRole;

public interface UserService {

	//create user
	public TblUser createUser(TblUser tblUser,Set<TblUsersRole> tblUsersRoles) throws Exception;

	//get user by username
	public TblUser getUserByUserName(String username);

	//delete user by userId
	public void deleteUserByUserId(Long userId);
}
