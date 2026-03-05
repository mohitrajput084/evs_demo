package com.cpgm.evs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ElectionResultDTO {

    private String candidateName;
    private String partyName;
    private Long voteCount;

}