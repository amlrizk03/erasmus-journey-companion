package com.erasmus.activity_service.repository;

import com.erasmus.activity_service.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
