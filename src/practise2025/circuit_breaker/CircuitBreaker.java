package practise2025.circuit_breaker;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class CircuitBreaker<T> {


    // 失败阈值
    private final int closeFailureThreshold;
    // 重置超时时间
    private final int failureProtectTimeThreshold;
    // 半开状态的失败阈值
    private final int halfSuccessThreshold;

    private final int halfTimeWindowThreshold;

    private final AtomicLong recentFailureTime=new AtomicLong();
    private final AtomicInteger failureCounter=new AtomicInteger(0);
    private final AtomicInteger successCounter=new AtomicInteger(0);

    private AtomicLong timeWindow = new AtomicLong();
    private AtomicInteger timeWindowCounter = new AtomicInteger(0);


    public CircuitBreaker(int closeFailureThreshold, int failureProtectTimeThreshold, int halfSuccessThreshold, int halfTimeWindowThreshold) {
        this.closeFailureThreshold = closeFailureThreshold;
        this.failureProtectTimeThreshold = failureProtectTimeThreshold;
        this.halfSuccessThreshold = halfSuccessThreshold;
        this.halfTimeWindowThreshold = halfTimeWindowThreshold;
    }

    // 状态
    private volatile CircuitBreakerState state = CircuitBreakerState.CLOSED;
    private final ReentrantLock lock = new ReentrantLock();

    private void checkCall() throws CircuitBreakException {

        if (state == CircuitBreakerState.CLOSED) {
            return;
        }

        long curTime = System.currentTimeMillis();

        if (state == CircuitBreakerState.HALF_OPEN) {

            long timeWindow = curTime / 1000;

            if (timeWindow != this.timeWindow.get()) {
                lock.lock();
                try {
                    if (timeWindow != this.timeWindow.get() && state == CircuitBreakerState.HALF_OPEN) {
                        this.timeWindow.set(timeWindow);
                        this.timeWindowCounter.set(0);
                    }
                } finally {
                    lock.unlock();
                }
            }

            int i = this.timeWindowCounter.incrementAndGet();

            if (i > this.halfTimeWindowThreshold) {
                throw new CircuitBreakException("半开状态超过限流值");
            }

        } else if (curTime - this.recentFailureTime.get() > this.failureProtectTimeThreshold) {
            // 如果超过了保护时间
            lock.lock();

            try{
                if (curTime - this.recentFailureTime.get() > this.failureProtectTimeThreshold && state == CircuitBreakerState.OPEN) {
                    this.state = CircuitBreakerState.HALF_OPEN;
                    this.successCounter.set(0);
                }
            }finally {
                lock.unlock();
            }


        } else {
            throw new CircuitBreakException("Circuit breaker is full");
        }
    }

    private void handleCallSuccess(){

        if (state == CircuitBreakerState.HALF_OPEN) {
            // 半开状态下 成功次数超过阈值 则转全开
            this.successCounter.incrementAndGet();

            if (this.successCounter.get() > this.halfSuccessThreshold) {

                lock.lock();
                try{
                    if (this.successCounter.get() > this.halfSuccessThreshold && this.state == CircuitBreakerState.HALF_OPEN) {
                        this.state = CircuitBreakerState.CLOSED;
                        this.successCounter.set(0);
                        this.failureCounter.set(0);
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

        if (state == CircuitBreakerState.CLOSED) {
            // 如果是闭合状态 判断失败是否超过阈值

            this.failureCounter.incrementAndGet();

            if (this.failureCounter.get()>this.closeFailureThreshold){
                lock.lock();
                try{
                    if (this.failureCounter.get() > this.closeFailureThreshold && this.state == CircuitBreakerState.CLOSED) {
                        this.state = CircuitBreakerState.OPEN;
                        this.failureCounter.set(0);
                        this.successCounter.set(0);
                    }
                } finally {
                    lock.unlock();
                }
            }

        } else if (state == CircuitBreakerState.HALF_OPEN) {
            // 如果是半开状态 直接断开
            lock.lock();
            try{
                if (state == CircuitBreakerState.HALF_OPEN) {
                    this.state = CircuitBreakerState.OPEN;
                    this.failureCounter.set(0);
                }
            } finally {
                lock.unlock();
            }
        }
    }


    public T execute(Callable<T> callable) throws CircuitBreakException, ApiException {

        checkCall();

        try {
            T call = callable.call();

            handleCallSuccess();

            return call;
        } catch (ApiException | CircuitBreakException e) {
            handleCallFailure();
            throw e;
        } catch (Exception e) {
            handleCallFailure();
            throw new RuntimeException(e);
        }
    }

}
