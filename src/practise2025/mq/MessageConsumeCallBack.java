package practise2025.mq;

@FunctionalInterface
public interface MessageConsumeCallBack {
    boolean consume(Message message);
}
