package practise2025.mq;

import java.util.List;
import java.util.UUID;

public class Message {
    private String topic;
    private List<String> tags;
    private String id;
    private String content;
    private long timestamp;

    public Message(String topic, List<String> tags, String content) {
        this.topic = topic;
        this.tags = tags;
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Message{" +
                "topic='" + topic + '\'' +
                ", tags=" + tags +
                ", id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
