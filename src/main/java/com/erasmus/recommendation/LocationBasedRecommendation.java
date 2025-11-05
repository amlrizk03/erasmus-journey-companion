package com.erasmus.recommendation;

import com.erasmus.activity.Activity;
import com.erasmus.user.User;
import java.util.ArrayList;
import java.util.List;

public class LocationBasedRecommendation implements RecommendationStrategy {
    
    @Override
    public List<Activity> recommend(User user, List<Activity> allActivities) {
        List<Activity> recommendations = new ArrayList<>();
        
        if (user.getProfile() == null || user.getProfile().getLocation() == null) {
            return recommendations;
        }

        String userLocation = user.getProfile().getLocation();
        
        for (Activity activity : allActivities) {
            if (activity.getLocation().equalsIgnoreCase(userLocation)) {
                recommendations.add(activity);
            }
        }
        
        return recommendations;
    }
}
