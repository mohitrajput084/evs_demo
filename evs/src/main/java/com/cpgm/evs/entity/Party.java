package com.cpgm.evs.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "parties")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String symbol;

}