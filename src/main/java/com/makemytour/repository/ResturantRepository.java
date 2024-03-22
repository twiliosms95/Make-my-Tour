package com.makemytour.repository;

import com.makemytour.entity.Resturant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResturantRepository extends JpaRepository<Resturant,Long> {
}
