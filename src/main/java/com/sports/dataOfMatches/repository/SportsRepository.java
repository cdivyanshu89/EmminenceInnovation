package com.sports.dataOfMatches.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.*;
import com.sports.dataOfMatches.entity.SportsEntity;

@Repository
public interface SportsRepository extends JpaRepository<SportsEntity, Long> {

	public SportsEntity findByEmail(String email);
	
}
