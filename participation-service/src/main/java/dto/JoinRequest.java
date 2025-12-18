package com.erasmus.participationservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JoinRequest {

    @NotNull
    private Long userId;

    @NotNull
    private Long activityId;
}
