package com.erasmus.recommendation;

import com.erasmus.activity.Activity;
import com.erasmus.user.User;
import java.util.List;

public class RecommendationEngine {
    private RecommendationStrategy strategy;

    public RecommendationEngine(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Activity> getRecommendations(User user, List<Activity> allActivities) {
        if (strategy == null) {
            throw new IllegalStateException("Recommendation strategy not set");
        }
        return strategy.recommend(user, allActivities);
    }
}
