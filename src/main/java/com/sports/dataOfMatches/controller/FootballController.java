package com.sports.dataOfMatches.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sports.dataOfMatches.dto.FootballDto;
import com.sports.dataOfMatches.service.FootService;


@RestController
@RequestMapping("football")
public class FootballController {

    private final FootService footService;

    @Autowired
    public FootballController(FootService footService) {
        this.footService = footService;
    }

    @GetMapping("/drawn-matches")
    public ResponseEntity<Integer> getDrawnMatchesCount(@RequestParam int year) {
    	List<FootballDto> matches=footService.getMatches(year, 1);
         return new ResponseEntity<>(footService.calcDrawnMatchesCount(matches),HttpStatus.OK);
    }

  
}
