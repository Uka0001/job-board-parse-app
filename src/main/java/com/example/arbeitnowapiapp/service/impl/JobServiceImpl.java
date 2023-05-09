package com.example.arbeitnowapiapp.service.impl;

import com.example.arbeitnowapiapp.dto.CityDto;
import com.example.arbeitnowapiapp.dto.JobDto;
import com.example.arbeitnowapiapp.dto.ViewDto;
import com.example.arbeitnowapiapp.mapper.JobMapper;
import com.example.arbeitnowapiapp.model.Job;
import com.example.arbeitnowapiapp.repository.JobRepository;
import com.example.arbeitnowapiapp.service.JobService;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
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
        return jobRepository.findAllBySlugsAndCreationTime(
                job.getSlug(),
                job.getCreatedAt());
    }

    @Override
    public List<CityDto> getStatisticByCity() {
        return jobRepository.getStatisticByCity();
    }

    @Override
    public List<JobDto> getRecentJobs(int number) {
        return jobRepository.findAll().stream()
                .sorted(Comparator.comparing(
                        Job::getCreatedAt,
                        Comparator.reverseOrder()))
                .limit(number)
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public ViewDto getJobById(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No such id: " + id));
        int updatedViews = job.getViews() + 1;
        job.setViews(updatedViews);
        jobRepository.save(job);
        return mapper.toViewDto(job);
    }

    @Override
    public List<ViewDto> getTopViewedJobs(int number) {
        return jobRepository.findAll().stream()
                .sorted(Comparator.comparing(
                        Job::getViews,
                        Comparator.reverseOrder()))
                .limit(number)
                .map(mapper::toViewDto)
                .toList();
    }
}
