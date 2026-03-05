package com.cpgm.evs.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "voter_requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoterRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private String status;

    private LocalDateTime requestedAt;

}