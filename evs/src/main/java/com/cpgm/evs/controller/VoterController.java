package com.cpgm.evs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cpgm.evs.dto.VoteRequest;
import com.cpgm.evs.entity.Candidate;
import com.cpgm.evs.entity.Election;
import com.cpgm.evs.service.CandidateService;
import com.cpgm.evs.service.ElectionService;
import com.cpgm.evs.service.VoteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/voter")
@RequiredArgsConstructor
public class VoterController {

	private final VoteService voteService;
	private final ElectionService electionService;
    private final CandidateService candidateService;
	
    @GetMapping("/dashboard")
    public String voterDashboard() {
        return "Voter Access Granted";
    }
    
    @PostMapping("/cast-vote")
    public String castVote(@RequestBody VoteRequest request) {
        return voteService.castVote(request);
    }
    
    @GetMapping("/elections")
    public List<Election> getActiveElections() {
        return electionService.getActiveElections();
    }

    @GetMapping("/candidates/{electionId}")
    public List<Candidate> getCandidates(@PathVariable Long electionId) {
        return candidateService.getCandidatesByElection(electionId);
    }
}