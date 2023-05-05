package com.example.arbeitnowapiapp.controller;

import com.example.arbeitnowapiapp.dto.JobDto;
import com.example.arbeitnowapiapp.mapper.JobMapper;
import com.example.arbeitnowapiapp.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService service;
    private final JobMapper mapper;
    @GetMapping
    public JobDto getAllJobs(){
        return null;
    }
}
