package com.example.arbeitnowapiapp.repository;

import com.example.arbeitnowapiapp.dto.CityDto;
import com.example.arbeitnowapiapp.model.Job;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JobRepositoryTest {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    public void setUp() {
        Job job1 = new Job();
        job1.setSlug("slug1");
        job1.setCreatedAt(123456);
        job1.setLocation("Dresden");

        Job job2 = new Job();
        job2.setSlug("slug1");
        job2.setCreatedAt(123456);
        job2.setLocation("Berlin");

        Job job3 = new Job();
        job3.setSlug("slug2");
        job3.setCreatedAt(123456);
        job3.setLocation("Munich");

        entityManager.persist(job1);
        entityManager.persist(job2);
        entityManager.persist(job3);
        entityManager.flush();
    }

    @Test
    public void findAllBySlugsAndCreationTime_ok() {
        // perform test for findAllBySlugsAndCreationTime method
        List<Job> jobs = jobRepository.findAllBySlugsAndCreationTime("slug1", 123456);
        assertEquals(2, jobs.size());
    }

    @Test
    public void getStatisticByCity_ok() {
        // perform test for getStatisticByCity method
        List<CityDto> cityDtoList = jobRepository.getStatisticByCity();
        int actualSize = cityDtoList.size();
        assertEquals(3, actualSize);
        long actualCount = cityDtoList.get(0).count();
        assertEquals(1, actualCount);
    }
}