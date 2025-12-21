package practise2025.mq_v2;

import java.util.UUID;

public class Message {

    String msgId;
    String topic;
    String content;

    public Message(String topic, String content) {
        this.msgId = UUID.randomUUID().toString();
        this.topic = topic;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msgId='" + msgId + '\'' +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
