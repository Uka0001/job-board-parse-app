package com.example.arbeitnowapiapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "job_tags")
public class JobTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String tag;
    @ManyToMany(mappedBy = "jobTypes")
    private List<Job> jobTypes;
}
