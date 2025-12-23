package practise2025.mq;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class MessageBroker {

    private Map<String, MessageQueue> queues = new ConcurrentHashMap<>();

    public void createQueue(String name) {
        queues.put(name, new MessageQueue(name));
    }

    public String randomGetQueueName() {
        int i = ThreadLocalRandom.current().nextInt(queues.size());
        ArrayList<String> strings = new ArrayList<>(queues.keySet());
        return strings.get(i);
    }


    public boolean send(String queueName, Message message) {
        MessageQueue messageQueue = queues.get(queueName);
        if (messageQueue == null) {
            throw new IllegalArgumentException("队列不存在");
        }

        return messageQueue.send(message);
    }

    public MessageQueue getQueue(String queueName) {
        MessageQueue messageQueue = queues.get(queueName);
        if (messageQueue == null) {
            throw new IllegalArgumentException("队列不存在");
        }

        return messageQueue;
    }
}
