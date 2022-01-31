package com.boot.server.exam.contollers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.server.exam.exception.UserFoundException;
import com.boot.server.exam.models.TblRoles;
import com.boot.server.exam.models.TblUser;
import com.boot.server.exam.models.TblUsersRole;
import com.boot.server.exam.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	//delete user by userId
	@DeleteMapping("/{userId}")
	public void deleteUserByUserId(@PathVariable("userId") Long userId) {

       userService.deleteUserByUserId(userId);
	}

	//get user by username
	@GetMapping("/{username}")
	public TblUser getUserByUserName(@PathVariable("username") String username) {

        return userService.getUserByUserName(username);
    }

    //create user
	@PostMapping("/")
	public TblUser createUser(@RequestBody TblUser tblUser) throws Exception {

		//Password encoding
		tblUser.setPassword(bCryptPasswordEncoder.encode(tblUser.getPassword()));

		Set<TblUsersRole> tblUsersRoles=new HashSet<TblUsersRole>();

		TblRoles roles=new TblRoles();
		roles.setRoleName("USER");

		TblUsersRole tblUsersRole=new TblUsersRole();
		tblUsersRole.setTblUser(tblUser);
        tblUsersRole.setTblRoles(roles);

        tblUsersRoles.add(tblUsersRole);
      return this.userService.createUser(tblUser, tblUsersRoles);
    }

	//UserFoundException Handling
	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?> exceptionHandler(UserFoundException e){
		System.out.println("inside the UserFoundException handler class");
		return ResponseEntity.badRequest().body(e.getMessage());
	}

	//Exception Handling
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception e) {
		System.out.println("inside the Exception handler class");
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}
