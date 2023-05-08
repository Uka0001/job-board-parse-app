package com.example.arbeitnowapiapp.service.impl;

import com.example.arbeitnowapiapp.dto.CityDto;
import com.example.arbeitnowapiapp.dto.JobDto;
import com.example.arbeitnowapiapp.mapper.JobMapper;
import com.example.arbeitnowapiapp.model.Job;
import com.example.arbeitnowapiapp.repository.JobRepository;
import com.example.arbeitnowapiapp.service.JobService;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final JobMapper mapper;

    @Override
    public void saveAll(List<Job> jobList) {
        jobRepository.saveAll(jobList);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> findAll(PageRequest pageRequest) {
        return jobRepository.findAll(pageRequest).toList();
    }

    @Override
    public List<Job> findAllJobsBySlugsAndCreationTime(Job job) {
        List<Job> jobList
                = jobRepository.findAllBySlugsAndCreationTime(
                job.getSlug(),
                job.getCreatedAt());
        return jobList;
    }

    @Override
    public List<CityDto> getStatisticByCity() {
        return jobRepository.getStatisticByCity();
    }

    @Override
    public List<JobDto> getRecentJobs(int number) {
        return jobRepository.findAll().stream()
                .sorted(Comparator.comparing(Job::getCreatedAt))
                .limit(number)
                .map(mapper::toDto)
                .toList();
    }
}
