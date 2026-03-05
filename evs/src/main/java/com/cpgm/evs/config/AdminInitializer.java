package com.cpgm.evs.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cpgm.evs.entity.Role;
import com.cpgm.evs.entity.User;
import com.cpgm.evs.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AdminInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void run(String... args) {

        if (!userRepository.findByMobile("7777777777").isPresent()) {

            User admin = User.builder()
                    .name("Admin")
                    .mobile("7777777777")
                    .password(passwordEncoder.encode("123456"))
                    .role(Role.ROLE_ADMIN)
                    .enabled(true)
                    .build();

            userRepository.save(admin);
        }
    }
}