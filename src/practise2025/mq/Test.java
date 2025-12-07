package practise2025.mq;

public class Test {

    public static void main(String[] args) {

        MessageBroker messageBroker = new MessageBroker();

        String queueName1 = "queue1";

        messageBroker.createQueue(queueName1);

        MessageProducer messageProducer = new MessageProducer(messageBroker);

        MessageConsumer messageConsumer = new MessageConsumer("consumer1", messageBroker);

        messageConsumer.consume(queueName1, message -> {
            System.out.println("消费到消息，message: " + message.toString());
            return true;
        });


        for (int i = 0; i < 10; i++) {

            Message message = new Message("topic", null, "测试" + i);

            messageProducer.send(message);
        }

    }


}
