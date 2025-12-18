package com.erasmus.participationservice.service;

import com.erasmus.participationservice.dto.JoinRequest;
import com.erasmus.participationservice.entity.Participation;
import com.erasmus.participationservice.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class ParticipationService {

    private final ParticipationRepository repo;
    private final RestTemplate restTemplate;

    @Value("${services.user.base-url}")
    private String userBaseUrl;

    @Value("${services.activity.base-url}")
    private String activityBaseUrl;

    public ParticipationService(ParticipationRepository repo, RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
    }

    public Participation join(JoinRequest req) {

        try {
            restTemplate.getForObject(userBaseUrl + "/users/" + req.getUserId(), Object.class);
        } catch (Exception ex) {
            throw new ResponseStatusException(NOT_FOUND, "User not found: " + req.getUserId());
        }


        try {
            restTemplate.getForObject(activityBaseUrl + "/activities/" + req.getActivityId(), Object.class);
        } catch (Exception ex) {
            throw new ResponseStatusException(NOT_FOUND, "Activity not found: " + req.getActivityId());
        }


        boolean alreadyJoined = repo.existsByUserIdAndActivityId(req.getUserId(), req.getActivityId());
        if (alreadyJoined) {
            throw new ResponseStatusException(CONFLICT, "Already joined");
        }

        Participation p = new Participation();
        p.setUserId(req.getUserId());
        p.setActivityId(req.getActivityId());
        return repo.save(p);
    }

    public List<Participation> byUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public List<Participation> byActivity(Long activityId) {
        return repo.findByActivityId(activityId);
    }
}
