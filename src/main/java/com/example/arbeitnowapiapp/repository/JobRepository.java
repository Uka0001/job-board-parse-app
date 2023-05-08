package com.example.arbeitnowapiapp.repository;

import com.example.arbeitnowapiapp.dto.CityDto;
import com.example.arbeitnowapiapp.model.Job;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobRepository extends JpaRepository<Job, Long> {
    @Query(value = "SELECT DISTINCT *"
            + " FROM job_data j"
            + " WHERE j.slug = ?1 AND j.created_at = ?2",
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
