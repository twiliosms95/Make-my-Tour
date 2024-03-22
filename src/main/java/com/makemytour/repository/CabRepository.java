package com.makemytour.repository;

import com.makemytour.entity.Cab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabRepository extends JpaRepository<Cab,Long> {
}
