package com.erasmus.activity_service.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ParticipationEventsListener {

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void onJoined(ParticipationJoinedEvent event) {

        System.out.println(
                "[activity-service] Received ParticipationJoinedEvent: userId="
                        + event.getUserId()
                        + ", activityId="
                        + event.getActivityId()
                        + ", at="
                        + event.getJoinedAt()
        );
    }
}
