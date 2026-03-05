package com.cpgm.evs.service;

import com.cpgm.evs.dto.ElectionResultDTO;
import com.cpgm.evs.entity.*;
import com.cpgm.evs.repository.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final ElectionRepository electionRepository;
    private final PartyRepository partyRepository;
    private final CandidateRepository candidateRepository;
    private final VoteRepository voteRepository;

    public Election createElection(Election election) {
        return electionRepository.save(election);
    }

    public Party createParty(Party party) {
        return partyRepository.save(party);
    }

    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }
    
    public List<ElectionResultDTO> getElectionResults(Long electionId) {
        return voteRepository.getElectionResults(electionId);
    }
    
    public ElectionResultDTO getWinner(Long electionId) {
        return voteRepository.getElectionResults(electionId)
                .stream()
                .findFirst()
                .orElse(null);
    }
}