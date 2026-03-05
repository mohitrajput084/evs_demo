package com.cpgm.evs.repository;

import com.cpgm.evs.dto.ElectionResultDTO;
import com.cpgm.evs.entity.Vote;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    boolean existsByVoterIdAndElectionId(Long voterId, Long electionId);
    
    @Query("SELECT new com.cpgm.evs.dto.ElectionResultDTO(" +
    	       "c.name, " +
    	       "c.party.name, " +
    	       "COUNT(v)) " +
    	       "FROM Vote v " +
    	       "JOIN v.candidate c " +
    	       "WHERE v.election.id = :electionId " +
    	       "GROUP BY c.id, c.name, c.party.name " +
    	       "ORDER BY COUNT(v) DESC")
    	List<ElectionResultDTO> getElectionResults(@Param("electionId") Long electionId);

}