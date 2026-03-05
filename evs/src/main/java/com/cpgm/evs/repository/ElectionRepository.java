package com.cpgm.evs.repository;

import com.cpgm.evs.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectionRepository extends JpaRepository<Election, Long> {

    List<Election> findByActiveTrue();

}