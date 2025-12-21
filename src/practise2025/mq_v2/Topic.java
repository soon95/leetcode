package practise2025.mq_v2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Topic {

    String name;

    BlockingQueue<Message> msgQueue = new LinkedBlockingQueue<>();

    Map<String, Message> unackMsgMap = new HashMap<>();

    public Topic(String name) {
        this.name = name;
    }

    public String sendMsg(String content) {

        Message message = new Message(this.name, content);

        msgQueue.offer(message);

        return message.msgId;
    }

    public Message consumeMsg() throws InterruptedException {
        Message message = msgQueue.take();
        unackMsgMap.put(message.msgId, message);
        return message;
    }


    public void ack(String msgId) {
        unackMsgMap.remove(msgId);
    }

}
