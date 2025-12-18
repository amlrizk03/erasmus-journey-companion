package com.erasmus.participationservice.messaging;

import java.time.Instant;

public class ParticipationJoinedEvent {

    private Long userId;
    private Long activityId;
    private Instant timestamp;

    public ParticipationJoinedEvent(Long userId, Long activityId, Instant timestamp) {
        this.userId = userId;
        this.activityId = activityId;
        this.timestamp = timestamp;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
