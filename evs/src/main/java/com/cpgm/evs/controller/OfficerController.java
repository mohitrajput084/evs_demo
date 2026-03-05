package com.cpgm.evs.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/officer")
public class OfficerController {

    @GetMapping("/dashboard")
    public String officerDashboard() {
        return "Officer Access Granted";
    }
}