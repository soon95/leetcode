package practise2025.mq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class MessageConsumer {

    private String name;
    private MessageBroker broker;

    private ExecutorService executor = Executors.newFixedThreadPool(1);

    private boolean running = true;

    public MessageConsumer(String name, MessageBroker broker) {
        this.name = name;
        this.broker = broker;
    }

    public void consume(String queueName, Function<Message, Boolean> callBack) {
        MessageQueue queue = this.broker.getQueue(queueName);
        executor.submit(() -> {
            while (running) {
                try {
                    Message message = queue.take();
                    boolean res = callBack.apply(message);
                    if (!res) {
                        throw new RuntimeException("消费失败");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void stop() {
        this.running = false;
    }
}
