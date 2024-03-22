package com.makemytour.repository;

import com.makemytour.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide,Long> {
}
