package practise2025.circuit_breaker;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class CircuitBreaker {

    private enum State{
        OPEN,
        CLOSE,
        HALF,
    }


    // 失败阈值
    private final int closeFailureThreshold;
    // 重置超时时间
    private final int failureProtectTimeThreshold;
    // 半开状态的失败阈值
    private final int halfSuccessThreshold;

    private final AtomicLong recentFailureTime=new AtomicLong();
    private final AtomicInteger failureCounter=new AtomicInteger(0);
    private final AtomicInteger successCounter=new AtomicInteger(0);

    public CircuitBreaker(int closeFailureThreshold, int failureProtectTimeThreshold, int halfSuccessThreshold) {
        this.closeFailureThreshold = closeFailureThreshold;
        this.failureProtectTimeThreshold = failureProtectTimeThreshold;
        this.halfSuccessThreshold = halfSuccessThreshold;
    }

    // 状态
    private volatile State state=State.CLOSE;
    private final ReentrantLock lock = new ReentrantLock();

    private void checkCall(){

        if (state!=State.OPEN){
            return;
        }

        long curTime = System.currentTimeMillis();

        if (curTime-this.recentFailureTime.get()>this.failureProtectTimeThreshold){
            // 如果超过了保护时间
            lock.lock();

            try{
                if (curTime-this.recentFailureTime.get()>this.failureProtectTimeThreshold && state==State.OPEN){
                    this.state = State.HALF;
                    this.failureCounter.set(0);
                }
            }finally {
                lock.unlock();
            }


        } else {
            throw  new RuntimeException("Circuit breaker is full");
        }
    }

    private void handleCallSuccess(){

        if (state==State.HALF){
            // 半开状态下 成功次数超过阈值 则转全开
            this.successCounter.incrementAndGet();

            if (this.successCounter.get()>this.closeFailureThreshold){

                lock.lock();
                try{
                    if (this.successCounter.get()>this.halfSuccessThreshold && this.state == State.HALF){
                        this.state = State.CLOSE;
                        this.successCounter.set(0);
                    }
                }finally {
                    lock.unlock();
                }
            }
        } else {
            this.failureCounter.set(0);
        }
    }

    private void handleCallFailure(){

        this.recentFailureTime.set(System.currentTimeMillis());

        if (state==State.CLOSE){
            // 如果是闭合状态 判断失败是否超过阈值

            this.failureCounter.incrementAndGet();

            if (this.failureCounter.get()>this.closeFailureThreshold){
                lock.lock();
                try{
                    if (this.failureCounter.get()>this.closeFailureThreshold && this.state == State.OPEN){
                        this.state = State.OPEN;
                        this.failureCounter.set(0);
                    }
                } finally {
                    lock.unlock();
                }
            }

        } else if(state==State.HALF){
            // 如果是半开状态 直接断开
            lock.lock();
            try{
                if (state==State.HALF){
                    this.state = State.OPEN;
                    this.failureCounter.set(0);
                }
            } finally {
                lock.unlock();
            }
        }
    }



    public Response callRpc(int param1,String param2) throws ApiException {


        checkCall();

        try {
            Response resp = rpc(param1, param2);

            handleCallSuccess();

            return resp;
        } catch (ApiException e) {
            handleCallFailure();
            throw e;
        }
    }


    private Response rpc(int param1,String param2) throws ApiException{
        System.out.println("rpc调用");
        return null;
    }

}
