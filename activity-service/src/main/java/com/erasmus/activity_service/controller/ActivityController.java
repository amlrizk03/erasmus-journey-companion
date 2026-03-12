package com.erasmus.activity_service.controller;

import com.erasmus.activity_service.entity.Activity;
import com.erasmus.activity_service.repository.ActivityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityRepository repo;

    public ActivityController(ActivityRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Activity> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> getById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Activity create(@RequestBody Activity activity) {
        activity.setId(null);
        return repo.save(activity);
    }
}
