package practise2025.thread_print;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrint {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        Condition print1Condition = lock.newCondition();
        Condition print2Condition = lock.newCondition();
        Condition print3Condition = lock.newCondition();

        AtomicInteger flag = new AtomicInteger();

        new Thread(() -> {
            while (true) {
                lock.lock();
                try {

                    while (flag.get() != 0) {
                        print1Condition.await();
                    }
                    System.out.println("AAA");
                    flag.set(1);
                    print2Condition.signal();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }


        }).start();

        new Thread(() -> {
            while (true) {
                lock.lock();
                try {

                    while (flag.get() != 1) {
                        print2Condition.await();
                    }
                    System.out.println("BBB");
                    flag.set(2);
                    print3Condition.signal();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }


        }).start();

        new Thread(() -> {
            while (true) {
                lock.lock();
                try {

                    while (flag.get() != 2) {
                        print3Condition.await();
                    }
                    System.out.println("CCC");
                    flag.set(0);
                    print1Condition.signal();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();


    }


}
