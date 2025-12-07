package practise2025.mq;

public class MessageProducer {

    private MessageBroker broker;

    public MessageProducer(MessageBroker broker) {
        this.broker = broker;
    }

    public boolean send(Message message) {

        String queueName = this.broker.randomGetQueueName();

        return this.broker.send(queueName, message);
    }

}
