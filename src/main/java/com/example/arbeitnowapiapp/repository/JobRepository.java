package com.example.arbeitnowapiapp.repository;

import com.example.arbeitnowapiapp.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
