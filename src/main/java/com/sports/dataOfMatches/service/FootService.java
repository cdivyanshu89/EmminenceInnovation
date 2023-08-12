package com.sports.dataOfMatches.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.sports.dataOfMatches.dto.FootballDto;

public interface FootService {

	
	public int calcDrawnMatchesCount(List<FootballDto> matches);
	 public List<FootballDto>  getMatches(int year, int page) ;
}
