package com.erasmus.activity_service.messaging;


import java.time.Instant;

public class ParticipationJoinedEvent {

    private Long userId;
    private Long activityId;
    private Instant joinedAt;

    public ParticipationJoinedEvent() {
    }

    public ParticipationJoinedEvent(Long userId, Long activityId, Instant joinedAt) {
        this.userId = userId;
        this.activityId = activityId;
        this.joinedAt = joinedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public Instant getJoinedAt() {
        return joinedAt;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public void setJoinedAt(Instant joinedAt) {
        this.joinedAt = joinedAt;
    }
}
