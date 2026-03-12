package com.erasmus.participationservice.controller;

import com.erasmus.participationservice.dto.JoinRequest;
import com.erasmus.participationservice.entity.Participation;
import com.erasmus.participationservice.service.ParticipationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participations")
public class ParticipationController {

    private final ParticipationService service;

    public ParticipationController(ParticipationService service) {
        this.service = service;
    }

    @PostMapping("/join")
    public ResponseEntity<Participation> join(@Valid @RequestBody JoinRequest req) {
        return ResponseEntity.ok(service.join(req));
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<Participation>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.byUser(userId));
    }

    @GetMapping("/byActivity/{activityId}")
    public ResponseEntity<List<Participation>> byActivity(@PathVariable Long activityId) {
        return ResponseEntity.ok(service.byActivity(activityId));
    }
}
