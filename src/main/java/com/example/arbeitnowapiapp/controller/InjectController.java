package com.example.arbeitnowapiapp.controller;

import com.example.arbeitnowapiapp.dto.JobApiResponseDto;
import com.example.arbeitnowapiapp.dto.JobDto;
import com.example.arbeitnowapiapp.mapper.JobMapper;
import com.example.arbeitnowapiapp.model.Job;
import com.example.arbeitnowapiapp.service.HttpClient;
import com.example.arbeitnowapiapp.service.JobService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Controller
@RequiredArgsConstructor
public class InjectController {
    public static final int PAGE_START_ITERATION_NUMBER = 1;
    public static final int PAGE_FINISH_ITERATION_NUMBER = 5;
    private final JobService service;
    private final HttpClient client;
    private final JobMapper mapper;
    @Value("${api.url.arbeitnow}")
    private String arbeitnowUrl;

    @Scheduled(cron = "0 */30 * ? * *")
    @PostConstruct
    public void init() {
        JobApiResponseDto dto = client.get(arbeitnowUrl, JobApiResponseDto.class);
        List<JobDto> jobDtoList = new ArrayList<>(dto.data());
        int pageNumber = PAGE_START_ITERATION_NUMBER;
        while(nonNull(dto.links().next()) && pageNumber <= PAGE_FINISH_ITERATION_NUMBER) {
            pageNumber++;
            dto = client.get(arbeitnowUrl, JobApiResponseDto.class);
            jobDtoList.addAll(dto.data());
        }
        List<Job> jobList = jobDtoList.stream()
                .map(mapper::toModel)
                .toList();
        service.saveAll(jobList);
    }
}
