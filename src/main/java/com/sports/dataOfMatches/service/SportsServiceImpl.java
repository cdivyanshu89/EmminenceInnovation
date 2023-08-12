package com.sports.dataOfMatches.service;

import java.security.Timestamp;
import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sports.dataOfMatches.dto.UserDto;
import com.sports.dataOfMatches.entity.SportsEntity;
import com.sports.dataOfMatches.exception.SportsException;
import com.sports.dataOfMatches.repository.SportsRepository;

@Service
public class SportsServiceImpl implements SportsService{

	 private final BCryptPasswordEncoder passwordEncoder;
	 
	 private final SportsRepository userRepository;

	 @Autowired
	 public SportsServiceImpl(BCryptPasswordEncoder passwordEncoder, SportsRepository sportsRepository) {
	        this.passwordEncoder = passwordEncoder;
	        this.userRepository=sportsRepository;
	 }
	
	@Override
    public String create(UserDto userDto) throws SportsException, SQLIntegrityConstraintViolationException {
        

        try {
        	SportsEntity sportsEntity= new SportsEntity(userDto.getEmail(), userDto.getName(), userDto.getPassword(), userDto.getPhoneNo(), userDto.getCreatedAt());
        	sportsEntity.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
        	userRepository.save(sportsEntity);

        } catch (Exception e) {
            if (e.getCause().getCause() instanceof SQLIntegrityConstraintViolationException){
                throw new SportsException(e.getMessage());
            }
            System.out.println("ERROR WHILE SAVING USER OBJECT");
        }
        return "Added SuccessFully";
    }

    /**
     *
     * @param userName
     * @return user details object which in Spring boot
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{

        SportsEntity entity = userRepository.findByEmail(userName);

        if (entity == null)
            throw new UsernameNotFoundException(userName);

        
        return new User(entity.getEmail(), entity.getPassword(), true, true, true, true, null);
    }

    @Override
    public SportsEntity getUserDetailsByEmail(String email) {

        SportsEntity entity = userRepository.findByEmail(email);

        if (entity == null)
            throw new UsernameNotFoundException(email);

        return entity;
    }

}
