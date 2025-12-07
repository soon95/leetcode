package practise2025.mq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {

    private String name;
    private BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

    public MessageQueue(String name) {
        this.name = name;
    }

    public boolean send(Message message) {
        return queue.offer(message);
    }

    public Message take() throws InterruptedException {
        return queue.take();
    }


}
