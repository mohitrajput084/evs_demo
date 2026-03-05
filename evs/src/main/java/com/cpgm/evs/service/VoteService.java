package com.cpgm.evs.service;

import com.cpgm.evs.dto.VoteRequest;
import com.cpgm.evs.entity.*;
import com.cpgm.evs.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final CandidateRepository candidateRepository;
    private final ElectionRepository electionRepository;

    public String castVote(VoteRequest request) {

        String mobile = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User voter = userRepository.findByMobile(mobile)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Election election = electionRepository.findById(request.getElectionId())
                .orElseThrow(() -> new RuntimeException("Election not found"));

        if (!election.isActive()) {
            throw new RuntimeException("Election is not active");
        }

        boolean alreadyVoted = voteRepository
                .existsByVoterIdAndElectionId(voter.getId(), election.getId());

        if (alreadyVoted) {
            throw new RuntimeException("You have already voted in this election");
        }

        Candidate candidate = candidateRepository.findById(request.getCandidateId())
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        // Candidate must belong to election
        if (!candidate.getElection().getId().equals(election.getId())) {
            throw new RuntimeException("Candidate does not belong to this election");
        }

        Vote vote = Vote.builder()
                .voter(voter)
                .candidate(candidate)
                .election(election)
                .voteTime(LocalDateTime.now())
                .build();

        voteRepository.save(vote);

        return "Vote cast successfully";
    }
}