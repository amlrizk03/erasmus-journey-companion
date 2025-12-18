package com.erasmus.participationservice.repository;

import com.erasmus.participationservice.entity.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    List<Participation> findByUserId(Long userId);
    List<Participation> findByActivityId(Long activityId);
    boolean existsByUserIdAndActivityId(Long userId, Long activityId);
}
