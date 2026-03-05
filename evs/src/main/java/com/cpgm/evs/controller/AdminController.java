package com.cpgm.evs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpgm.evs.dto.ElectionResultDTO;
import com.cpgm.evs.entity.Candidate;
import com.cpgm.evs.entity.Election;
import com.cpgm.evs.entity.Party;
import com.cpgm.evs.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
	
	private final AdminService adminService;

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Admin Access Granted";
    }
    
    @PostMapping("/elections")
    public Election createElection(@RequestBody Election election) {
        return adminService.createElection(election);
    }

    @PostMapping("/parties")
    public Party createParty(@RequestBody Party party) {
        return adminService.createParty(party);
    }

    @PostMapping("/candidates")
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        return adminService.createCandidate(candidate);
    }
    
    @GetMapping("/results/{electionId}")
    public List<ElectionResultDTO> getElectionResults(@PathVariable Long electionId) {
        return adminService.getElectionResults(electionId);
    }
    
    @GetMapping("/results/{electionId}/winner")
    public ElectionResultDTO getWinner(@PathVariable Long electionId) {
        return adminService.getWinner(electionId);
    }
}