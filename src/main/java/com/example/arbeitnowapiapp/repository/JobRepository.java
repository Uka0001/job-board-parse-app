package com.example.arbeitnowapiapp.repository;

import com.example.arbeitnowapiapp.dto.CityDto;
import com.example.arbeitnowapiapp.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    @Query(value = "SELECT DISTINCT *"
            + " FROM job_data j"
            + " WHERE slug = ?1 AND CREATED_AT = ?2",
            nativeQuery = true)
    List<Job> findAllBySlugsAndCreationTime(String slug, long createdAt);

    @Query("""
            SELECT new com.example.arbeitnowapiapp.dto.CityDto(j.location, count(j))
            FROM Job j
            GROUP BY j.location
            ORDER BY count(j) ASC
            """)
    List<CityDto> getStatisticByCity();
}
