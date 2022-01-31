package com.boot.server.exam.contollers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.server.exam.models.JwtRequest;
import com.boot.server.exam.models.JwtResponse;
import com.boot.server.exam.models.TblUser;
import com.boot.server.exam.service.impl.UserDetailsSeviceImplSecurity;
import com.boot.server.exam.springsecurityconfig.JwtUtils;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsSeviceImplSecurity userDetailsSeviceImplSecurity;

	@Autowired
	private JwtUtils jwtUtils;


	//Generate Token
	@PostMapping("/generateToken")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {

			authenticate(jwtRequest.getUserName(), jwtRequest.getPassword());

		}catch (UsernameNotFoundException e) {
			throw new Exception("User name not found !! "+e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}

		// so here user is authenticated so we can generate the token

		UserDetails userDetails = this.userDetailsSeviceImplSecurity.loadUserByUsername(jwtRequest.getUserName());
        String token = this.jwtUtils.generateToken(userDetails);
        System.out.println("\n \n \n toke is "+token+"\n \n \n ");
        return ResponseEntity.ok(new JwtResponse(token));

	}

	//return the detail of current user
	@GetMapping("/current-user")
	public TblUser getCurentUser(Principal principal) {

		return (TblUser) this.userDetailsSeviceImplSecurity.loadUserByUsername(principal.getName());

	}



    private void authenticate(String username,String password) throws Exception {
		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		}catch (DisabledException e) {
			throw new Exception("User is disbaled !! "+e.getMessage());

		}catch (BadCredentialsException e) {
			throw new Exception("Bad Credentials !! "+e.getMessage());

		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
