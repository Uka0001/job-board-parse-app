package com.example.arbeitnowapiapp.service;

import com.example.arbeitnowapiapp.dto.CityDto;
import com.example.arbeitnowapiapp.dto.JobDto;
import com.example.arbeitnowapiapp.model.Job;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface JobService {
    void saveAll(List<Job> jobList);

    List<Job> findAll();

    List<Job> findAll(PageRequest pageRequest);

    List<Job> findAllJobsBySlugsAndCreationTime(Job job);

    List<CityDto> getStatisticByCity();

    List<JobDto> getRecentJobs(int number);
}
