package com.example.arbeitnowapiapp.mapper;

import com.example.arbeitnowapiapp.dto.JobDto;
import com.example.arbeitnowapiapp.model.Job;
import com.example.arbeitnowapiapp.model.JobTag;
import com.example.arbeitnowapiapp.model.JobType;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class JobMapper {
    public Job toModel(JobDto dto) {
        Job model = new Job();
        model.setId(null);
        model.setSlug(dto.slug());
        model.setCompanyName(dto.companyName());
        model.setTitle(dto.title());
        model.setDescription(dto.description());
        model.setRemote(dto.remote());
        model.setUrl(dto.url());
        model.setLocation(dto.location());
        model.setCreatedAt(Instant.ofEpochSecond(dto.createdAt()).getEpochSecond());
        return model;
    }

    public JobDto toDto(Job model) {
        return new JobDto(
                model.getSlug(),
                model.getCompanyName(),
                model.getTitle(),
                model.getDescription(),
                model.isRemote(),
                model.getUrl(),
                model.getTags().stream()
                        .map(JobTag::getTag)
                        .toList(),
                model.getJobTypes().stream()
                        .map(JobType::getType)
                        .toList(),
                model.getLocation(),
                model.getCreatedAt()
        );
    }
}
