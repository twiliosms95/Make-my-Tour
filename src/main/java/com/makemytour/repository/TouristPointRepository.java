package com.makemytour.repository;

import com.makemytour.entity.TouristPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristPointRepository extends JpaRepository<TouristPoint,Long> {
}
