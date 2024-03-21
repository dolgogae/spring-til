package com.example.projectdirection.unit.pharmacy.service;

import com.example.projectdirection.ProjectDirectionApplicationTests;
import com.example.projectdirection.pharmacy.entity.Pharmacy;
import com.example.projectdirection.pharmacy.repository.PharmacyRepository;
import com.example.projectdirection.pharmacy.service.PharmacyRepositoryService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PharmacyRepositoryServiceTest extends ProjectDirectionApplicationTests {

    @Autowired
    PharmacyRepository pharmacyRepository;

    @Autowired
    PharmacyRepositoryService pharmacyRepositoryService;

    @BeforeEach
    public void before() throws Exception {
        pharmacyRepository.deleteAll();
    }

    @Test
    @DisplayName("주소 변경 테스트 코드(트랜잭션)")
    public void updateAddressTest(){
        // given
        Long id = 1L;
        Pharmacy entity = Pharmacy.builder()
                .pharmacyAddress("서울시 용산구")
                .pharmacyName("우리 약국")
                .latitude(123.12)
                .longitude(11.11).build();

        pharmacyRepository.save(entity);

        // when
        pharmacyRepositoryService.updateAddress(id, "서울시 종로구");
        Optional<Pharmacy> result = pharmacyRepository.findById(1L);

        // then
        Assertions.assertTrue(result.isPresent());
        Pharmacy pharmacy = result.get();
        Assertions.assertEquals("서울시 종로구", pharmacy.getPharmacyAddress());
    }
}