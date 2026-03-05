package com.cpgm.evs.service;

import com.cpgm.evs.entity.Election;
import com.cpgm.evs.repository.ElectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectionService {

    private final ElectionRepository electionRepository;

    public List<Election> getActiveElections() {
        return electionRepository.findByActiveTrue();
    }
}