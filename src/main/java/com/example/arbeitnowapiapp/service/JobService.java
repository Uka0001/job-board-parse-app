package com.example.arbeitnowapiapp.service;

import com.example.arbeitnowapiapp.model.Job;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface JobService {
    void saveAll(List<Job> jobList);

    List<Job> findAll();

    List<Job> findAll(PageRequest pageRequest);

    List<Job> findAllJobsBySlugsAndCreationTime(Job job);
}
