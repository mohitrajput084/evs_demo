package com.cpgm.evs.service;

import com.cpgm.evs.dto.RegisterRequest;
import com.cpgm.evs.entity.Role;
import com.cpgm.evs.entity.User;
import com.cpgm.evs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request) {

        if (userRepository.findByMobile(request.getMobile()).isPresent()) {
            throw new RuntimeException("Mobile number already registered");
        }

        User user = User.builder()
                .name(request.getName())
                .mobile(request.getMobile())
                .district(request.getDistrict())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_VOTER)
                .enabled(false)  // default false until approved
                .build();

        userRepository.save(user);

        return "User registered successfully. Wait for approval.";
    }
}