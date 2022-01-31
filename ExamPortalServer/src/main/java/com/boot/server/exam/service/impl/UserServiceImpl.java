package com.boot.server.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.server.exam.exception.UserFoundException;
import com.boot.server.exam.models.TblUser;
import com.boot.server.exam.models.TblUsersRole;
import com.boot.server.exam.repository.RoleRepository;
import com.boot.server.exam.repository.UserRepository;
import com.boot.server.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public TblUser createUser(TblUser tblUser, Set<TblUsersRole> tblUsersRoles) throws Exception {

		TblUser userByUserName = userRepository.findTblUserByUserName(tblUser.getUserName());
		if (userByUserName != null) {
			System.out.println("User is already exist");
			throw new UserFoundException();
        } else {
			for (TblUsersRole tblUsersRole : tblUsersRoles) {
				roleRepository.save(tblUsersRole.getTblRoles());
			}
			tblUser.getTblUsersRoles().addAll(tblUsersRoles);
			userByUserName = userRepository.save(tblUser);
        }
       return userByUserName;
	}

	@Override
	public TblUser getUserByUserName(String username) {
		return userRepository.findTblUserByUserName(username);
	}

	@Override
	public void deleteUserByUserId(Long userId) {

		userRepository.deleteById(userId);
	}



}
