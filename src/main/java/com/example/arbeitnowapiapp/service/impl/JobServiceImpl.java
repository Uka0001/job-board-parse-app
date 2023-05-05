package com.example.arbeitnowapiapp.service.impl;

import com.example.arbeitnowapiapp.model.Job;
import com.example.arbeitnowapiapp.repository.JobRepository;
import com.example.arbeitnowapiapp.service.JobService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    @Override
    public void saveAll(List<Job> jobList) {
        jobRepository.saveAll(jobList);
    }
}
