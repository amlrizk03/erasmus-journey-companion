package com.erasmus.recommendation;

import com.erasmus.activity.Activity;
import com.erasmus.user.User;
import java.util.List;

public interface RecommendationStrategy {
    List<Activity> recommend(User user, List<Activity> allActivities);
}
