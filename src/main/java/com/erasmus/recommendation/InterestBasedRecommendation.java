package com.erasmus.recommendation;

import com.erasmus.activity.Activity;
import com.erasmus.user.User;
import com.erasmus.user.UserProfile;
import java.util.ArrayList;
import java.util.List;

public class InterestBasedRecommendation implements RecommendationStrategy {
    
    @Override
    public List<Activity> recommend(User user, List<Activity> allActivities) {
        List<Activity> recommendations = new ArrayList<>();
        
        if (user.getProfile() == null || user.getProfile().getInterests() == null) {
            return recommendations;
        }

        List<String> userInterests = user.getProfile().getInterests();
        
        for (Activity activity : allActivities) {
            for (String interest : userInterests) {
                if (activity.getType().toLowerCase().contains(interest.toLowerCase()) ||
                    activity.getName().toLowerCase().contains(interest.toLowerCase())) {
                    recommendations.add(activity);
                    break;
                }
            }
        }
        
        return recommendations;
    }
}
