package com.sports.dataOfMatches.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sports.dataOfMatches.UtilityCreate;
import com.sports.dataOfMatches.dto.SignIn;
import com.sports.dataOfMatches.dto.UserDto;
import com.sports.dataOfMatches.entity.SportsEntity;
import com.sports.dataOfMatches.exception.SportsException;
import com.sports.dataOfMatches.service.SportsService;

@RestController
@RequestMapping("/authenticate")
public class AppController {

	 private final AuthenticationManager authenticationManager;
	    private final UtilityCreate jwtTokenUtil;
	    private final SportsService sportsService;

	    @Autowired
	    public AppController(AuthenticationManager authenticationManager,
	                                    UtilityCreate jwtTokenUtil,
	                                    SportsService userService) {
	        this.authenticationManager = authenticationManager;
	        this.jwtTokenUtil = jwtTokenUtil;
	        this.sportsService = userService;
	    }
	
	@PostMapping("signUp")
	public ResponseEntity<String> signUp(@RequestBody UserDto userDto) throws SQLIntegrityConstraintViolationException, SportsException {
		
    	String messege= sportsService.create(userDto);
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(messege);
	}
	
	@GetMapping("/signIn")
	public String signIn(@RequestBody SignIn signIn) throws SportsException {
		  try {
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getUserName(), signIn.getPassword()));
	        }catch (Exception e){
	            throw new SportsException("INVALID_CREDENTIALS");
	        }
	        final String token = jwtTokenUtil
	                .generateToken(sportsService.loadUserByUsername(signIn.getUserName()));

	        return token;
	}
	
	
}
