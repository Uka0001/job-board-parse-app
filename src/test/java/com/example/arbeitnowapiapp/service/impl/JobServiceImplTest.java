package com.example.arbeitnowapiapp.service.impl;

import com.example.arbeitnowapiapp.dto.CityDto;
import com.example.arbeitnowapiapp.mapper.JobMapper;
import com.example.arbeitnowapiapp.model.Job;
import com.example.arbeitnowapiapp.repository.JobRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JobServiceImplTest {

    @Mock
    private JobRepository jobRepository;

    @Mock
    private JobMapper mapper;

    @InjectMocks
    private JobServiceImpl jobService;

    @Test
    void saveAll_ok() {
        List<Job> jobs = Arrays.asList(
                new Job("job-1", 1620577522L),
                new Job("job-2", 1620577523L)
        );
        jobService.saveAll(jobs);
        Mockito.verify(jobRepository).saveAll(jobs);
    }

    @Test
    void findAll_ok() {
        List<Job> expected = Arrays.asList(
                new Job("job-1", 1620577524L),
                new Job("job-2", 1620577525L)
        );
        when(jobRepository.findAll()).thenReturn(expected);
        List<Job> actual = jobService.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void findAllJobsBySlugsAndCreationTime_ok() {
        Job job = new Job("job-1", 1620577523L);
        List<Job> expected = Arrays.asList(job);
        when(jobRepository.findAllBySlugsAndCreationTime(job.getSlug(), job.getCreatedAt())).thenReturn(expected);
        List<Job> actual = jobService.findAllJobsBySlugsAndCreationTime(job);
        assertEquals(expected, actual);
    }

    @Test
    void getStatisticByCity_ok() {
        List<CityDto> expected = Arrays.asList(
                new CityDto("Berlin", 11),
                new CityDto("Dresden", 3)
        );
        when(jobRepository.getStatisticByCity()).thenReturn(expected);
        List<CityDto> actual = jobService.getStatisticByCity();
        assertEquals(expected, actual);
    }
}
