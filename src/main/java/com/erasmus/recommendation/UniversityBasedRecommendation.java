package com.erasmus.recommendation;

import com.erasmus.activity.Activity;
import com.erasmus.user.User;
import java.util.ArrayList;
import java.util.List;

public class UniversityBasedRecommendation implements RecommendationStrategy {
    
    @Override
    public List<Activity> recommend(User user, List<Activity> allActivities) {
        List<Activity> recommendations = new ArrayList<>();
        
        if (user.getProfile() == null || user.getProfile().getUniversity() == null) {
            return recommendations;
        }

        String userUniversity = user.getProfile().getUniversity();
        
        for (Activity activity : allActivities) {
            if (activity.getOrganizer().toLowerCase().contains(userUniversity.toLowerCase()) ||
                activity.getDescription().toLowerCase().contains(userUniversity.toLowerCase())) {
                recommendations.add(activity);
            }
        }
        
        return recommendations;
    }
}
