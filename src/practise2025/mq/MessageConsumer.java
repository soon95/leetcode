package practise2025.mq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class MessageConsumer {

    private String name;
    private MessageBroker broker;

    private ExecutorService executor = Executors.newCachedThreadPool();

    public MessageConsumer(String name, MessageBroker broker) {
        this.name = name;
        this.broker = broker;
    }

    public void consume(String queueName, Function<Message, Boolean> callBack) {
        MessageQueue queue = this.broker.getQueue(queueName);
        executor.submit(() -> {
            while (true) {
                try {
                    Message message = queue.take();
                    boolean res = callBack.apply(message);
                    if (!res) {
                        queue.send(message);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
