package practise2025.mq_v2;


public class Test {

    public static void main(String[] args) throws InterruptedException {

        Broker broker = new Broker();

        String topicName = "test_topic";
        broker.createTopic(topicName);

        Producer producer = new Producer("test_producer", broker, topicName);

        Consumer consumer = new Consumer("test_consumer", broker, topicName);

        consumer.consume((message) -> {

            System.out.println("消息消费成功: " + message);

            return true;
        });


        for (int i = 0; i < 10; i++) {

            String content = "测试" + i;

            producer.sendMsg(content);

            Thread.sleep(1000);
        }
    }

}
