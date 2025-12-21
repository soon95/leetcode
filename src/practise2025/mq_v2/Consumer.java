package practise2025.mq_v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class Consumer {

    String name;

    Broker broker;

    String topicName;

    boolean running = true;

    ExecutorService executorService = Executors.newFixedThreadPool(1);

    public Consumer(String name, Broker broker, String topicName) {
        this.name = name;
        this.broker = broker;
        this.topicName = topicName;
    }

    public void consume(Function<Message, Boolean> callback) {

        executorService.submit(() -> {

            System.out.println("开始消费消息: " + topicName);

            while (running) {

                Topic topic = broker.getTopic(topicName);

                if (topic == null) {
                    throw new RuntimeException("主题不存在");
                }

                Message message = null;
                try {
                    message = topic.consumeMsg();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                Boolean res = callback.apply(message);

                if (res) {
                    topic.ack(message.msgId);
                }
            }
        });

    }

}
