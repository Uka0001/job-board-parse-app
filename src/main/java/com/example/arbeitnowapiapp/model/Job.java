package com.example.arbeitnowapiapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "job_data")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String slug;
    private String companyName;
    private String title;
    @Column(name = "description", length = 13000)
    private String description;
    private boolean remote;
    private String url;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "join_job_tag",
            joinColumns = {@JoinColumn(name = "job_id")},
            inverseJoinColumns = {@JoinColumn(name = "job_tags_id")})
    private List<JobTag> tags;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "join_job_type",
            joinColumns = {@JoinColumn(name = "job_id")},
            inverseJoinColumns = {@JoinColumn(name = "job_type_id")})
    private List<JobType> jobTypes;
    private String location;
    private long createdAt;
    private int views;

    public Job() {
    }

    public Job(String slug, long createdAt) {
        this.slug = slug;
        this.createdAt = createdAt;
    }
}
