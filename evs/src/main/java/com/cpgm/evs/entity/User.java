package com.cpgm.evs.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate dob;

    private String gender;

    @Column(unique = true)
    private String mobile;

    private String address;

    private String district;

    private String password;

    private boolean enabled;
    
    @Enumerated(EnumType.STRING)
    private Role role;

}