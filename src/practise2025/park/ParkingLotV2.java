package practise2025.park;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingLotV2 {

    private int capacity;
    private int usedSpace = 0;

    private Lock lock = new ReentrantLock();
    private Condition enterCondition = lock.newCondition();
    private Condition exitCondition = lock.newCondition();

    public ParkingLotV2(int capacity) {
        this.capacity = capacity;
    }

    public void enter(String carId) {
        lock.lock();
        try {
            while (usedSpace == capacity) {
                enterCondition.await();
            }
            usedSpace++;
            exitCondition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }


    public void exit(String carId) {
        lock.lock();
        try {
            while (usedSpace == 0) {
                exitCondition.await();
            }
            usedSpace--;
            enterCondition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }


}
