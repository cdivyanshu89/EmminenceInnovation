package com.sports.dataOfMatches.service;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.security.core.userdetails.UserDetails;

import com.sports.dataOfMatches.dto.UserDto;
import com.sports.dataOfMatches.entity.SportsEntity;
import com.sports.dataOfMatches.exception.SportsException;

public interface SportsService {

	
	public String create(UserDto userDto)  throws SportsException, SQLIntegrityConstraintViolationException;
	public UserDetails loadUserByUsername(String userName);
	public SportsEntity getUserDetailsByEmail(String email) ;
}
