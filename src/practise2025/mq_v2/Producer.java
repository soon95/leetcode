package practise2025.mq_v2;

public class Producer {

    String name;

    Broker broker;

    String topicName;

    public Producer(String name, Broker broker, String topicName) {
        this.name = name;
        this.broker = broker;
        this.topicName = topicName;
    }

    public void sendMsg(String content) {

        Topic topic = this.broker.getTopic(this.topicName);

        String msgId = topic.sendMsg(content);

        System.out.println("消息发送成功，msgId: " + msgId);
    }


}
