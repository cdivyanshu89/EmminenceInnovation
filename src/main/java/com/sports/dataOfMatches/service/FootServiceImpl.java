package com.sports.dataOfMatches.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.sports.dataOfMatches.dto.ApiResponse;
import com.sports.dataOfMatches.dto.FootballDto;

@Service
public class FootServiceImpl implements FootService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<FootballDto> getMatches(int year, int page) {
        String apiUrl = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&page=" + page;
        ApiResponse response = restTemplate.getForObject(apiUrl, ApiResponse.class);
        return response.getData();
    }
    
    @Override
	public int calcDrawnMatchesCount(List<FootballDto> matches) {
        int count = 0;
        for (FootballDto match : matches) {
            if (match.getTeam1goals().equals(match.getTeam2goals())) {
                count++;
            }
        }
        return count;
    }
}
