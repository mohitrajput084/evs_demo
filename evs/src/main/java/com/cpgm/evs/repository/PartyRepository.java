package com.cpgm.evs.repository;

import com.cpgm.evs.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {
}