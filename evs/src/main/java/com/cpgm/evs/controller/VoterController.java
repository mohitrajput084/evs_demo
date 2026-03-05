package com.cpgm.evs.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voter")
public class VoterController {

    @GetMapping("/dashboard")
    public String voterDashboard() {
        return "Voter Access Granted";
    }
}