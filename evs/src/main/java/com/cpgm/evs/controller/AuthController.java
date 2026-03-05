package com.cpgm.evs.controller;

import com.cpgm.evs.config.JwtUtil;
import com.cpgm.evs.dto.LoginRequest;
import com.cpgm.evs.dto.RegisterRequest;
import com.cpgm.evs.entity.User;
import com.cpgm.evs.repository.UserRepository;
import com.cpgm.evs.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @GetMapping("/test")
    public String test() {
        return "Controller working";
    }
    
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getMobile(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByMobile(request.getMobile())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtUtil.generateToken(
                user.getMobile(),
                user.getRole().name()
        );

        return ResponseEntity.ok(token);
    }
}