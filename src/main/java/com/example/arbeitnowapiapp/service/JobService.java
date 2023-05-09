package com.example.arbeitnowapiapp.service;

import com.example.arbeitnowapiapp.dto.CityDto;
import com.example.arbeitnowapiapp.dto.JobDto;
import com.example.arbeitnowapiapp.dto.ViewDto;
import com.example.arbeitnowapiapp.model.Job;
import java.util.List;
import org.springframework.data.domain.PageRequest;

public interface JobService {
    void saveAll(List<Job> jobList);

    List<Job> findAll();

    List<Job> findAll(PageRequest pageRequest);

    List<Job> findAllJobsBySlugsAndCreationTime(Job job);

    List<CityDto> getStatisticByCity();

    List<JobDto> getRecentJobs(int number);

    ViewDto getJobById(Long id);

    List<ViewDto> getTopViewedJobs(int number);
}
