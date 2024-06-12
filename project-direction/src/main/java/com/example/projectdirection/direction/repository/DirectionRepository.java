package com.example.projectdirection.direction.repository;

import com.example.projectdirection.direction.entity.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectionRepository extends JpaRepository<Direction, Long> {
}
