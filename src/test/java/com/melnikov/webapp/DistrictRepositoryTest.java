package com.melnikov.webapp;

import com.melnikov.webapp.repository.DistrictRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DistrictRepositoryTest {
    @Autowired
    private DistrictRepository districtRepository;

    @Test
    public void testDistrictRepository(){
        System.out.println(districtRepository.findAll());
    }
}
