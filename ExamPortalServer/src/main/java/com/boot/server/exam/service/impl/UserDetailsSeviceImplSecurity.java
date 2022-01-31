package com.boot.server.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boot.server.exam.models.TblUser;
import com.boot.server.exam.repository.UserRepository;

@Service
public class UserDetailsSeviceImplSecurity implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		TblUser user = this.userRepository.findTblUserByUserName(username);
		if(user==null) {
			System.out.println("User not found !!");
			throw new UsernameNotFoundException("User not found !!");
		}
		System.out.println("<<<---- Jwt token generate by------>>> "+user.getUsername());
		return user;
	}

}
