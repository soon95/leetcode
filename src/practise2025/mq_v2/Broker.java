package practise2025.mq_v2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Broker {

    Map<String, Topic> topicMap = new HashMap<>();

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);


    public void createTopic(String topicName) {

        Topic topic = new Topic(topicName);

        topicMap.put(topicName, topic);
    }


    public Topic getTopic(String topicName) {

        Topic topic = topicMap.get(topicName);
        if (topic == null) {
            throw new RuntimeException("topic not found");
        }

        return topic;
    }

    public void resendUnAckMessage() {

        scheduledExecutorService.scheduleAtFixedRate(() -> {

            // 拿到所有没有ack的消息 然后重发


        }, 10, 10, TimeUnit.SECONDS);
    }

}
