package com.cpgm.evs.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteRequest {

    private Long candidateId;
    private Long electionId;

}