package com.example.arbeitnowapiapp.controller;

import com.example.arbeitnowapiapp.dto.CityDto;
import com.example.arbeitnowapiapp.dto.JobDto;
import com.example.arbeitnowapiapp.mapper.JobMapper;
import com.example.arbeitnowapiapp.service.JobService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService service;
    private final JobMapper mapper;
    @GetMapping
    public List<JobDto> getAllJobs(@RequestParam (defaultValue = "20") Integer count,
                                   @RequestParam (defaultValue = "0") Integer page,
                                   @RequestParam (defaultValue = "id") String sortBy) {
        Sort sort = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(page, count, sort);
        return service.findAll(pageRequest).stream()
                .map(mapper::toDto)
                .toList();
    }

    @GetMapping("/city")
    public List<CityDto> getStatisticByCity() {
        return service.getStatisticByCity();
    }

    @GetMapping("/recent")
    public List<JobDto> getRecentJobs(@RequestParam int number) {
        return service.getRecentJobs(number);
    }
}
