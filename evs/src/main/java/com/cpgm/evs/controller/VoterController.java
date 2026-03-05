package com.cpgm.evs.controller;

import org.springframework.web.bind.annotation.*;

import com.cpgm.evs.dto.VoteRequest;
import com.cpgm.evs.service.VoteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/voter")
@RequiredArgsConstructor
public class VoterController {

	private final VoteService voteService;
	
    @GetMapping("/dashboard")
    public String voterDashboard() {
        return "Voter Access Granted";
    }
    
    @PostMapping("/cast-vote")
    public String castVote(@RequestBody VoteRequest request) {
        return voteService.castVote(request);
    }
}