package com.example.arbeitnowapiapp.service;

import com.example.arbeitnowapiapp.dto.JobDto;
import com.example.arbeitnowapiapp.model.Job;

import java.util.List;

public interface JobService {
    void saveAll(List<Job> jobList);
}
