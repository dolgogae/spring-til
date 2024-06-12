package com.example.projectdirection.pharmacy.repository;

import com.example.projectdirection.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
}
