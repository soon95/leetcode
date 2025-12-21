package practise2025.scheduler;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskScheduler {

    PriorityQueue<ScheduledTask> scheduledTasks = new PriorityQueue<>(new Comparator<ScheduledTask>() {
        @Override
        public int compare(ScheduledTask o1, ScheduledTask o2) {
            return Long.compare(o1.startTime, o2.startTime);
        }
    });
    Map<String, ScheduledTask> map = new HashMap<>();


    PriorityQueue<TaskInstance> taskInstances = new PriorityQueue<>(new Comparator<TaskInstance>() {
        @Override
        public int compare(TaskInstance o1, TaskInstance o2) {
            return Long.compare(o1.nextTime, o2.nextTime);
        }
    });
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    ExecutorService executorService = Executors.newFixedThreadPool(5);


    boolean running = true;

    public void addTask(String taskName, boolean isPeriod, int period, long startTime, Runnable task) {

        ScheduledTask scheduledTask = new ScheduledTask(taskName, isPeriod, period, startTime, task);

        map.put(taskName, scheduledTask);
        scheduledTasks.add(scheduledTask);
    }

    public void run() {

        Thread thread = new Thread(() -> {

            while (running) {

                lock.lock();

                try {

                    while (taskInstances.isEmpty()) {
                        condition.await();
                    }

                    TaskInstance task = taskInstances.peek();
                    long delay = task.nextTime - System.currentTimeMillis();
                    if (delay > 0) {
                        // 如果还没到
                        condition.await(delay, TimeUnit.MILLISECONDS);
                    } else {

                        TaskInstance taskInstance = taskInstances.poll();
                        if (taskInstance == null) {
                            continue;
                        }
                        executorService.submit(() -> {
                            try {
                                taskInstance.run();
                            } finally {
                                if (taskInstance.isPeriod) {
                                    updateNextTime(taskInstance);
                                }
                            }
                        });
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }


        });
        thread.start();


    }

    private void updateNextTime(TaskInstance taskInstance) {
        lock.lock();
        try {

            if (taskInstance.cancelled) {
                return;
            }

            taskInstance.updateNextTime();
            taskInstances.offer(taskInstance);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }


    public void schedule(long time) {
        while (!scheduledTasks.isEmpty() && scheduledTasks.peek().startTime <= time) {
            ScheduledTask scheduledTask = scheduledTasks.poll();
            lock.lock();
            try {
                taskInstances.offer(scheduledTask.taskInstance);
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void cancel(String taskName) {

        ScheduledTask scheduledTask = map.get(taskName);
        if (scheduledTask == null) {
            return;
        }

        scheduledTask.taskInstance.cancelled = true;

    }


    public static void main(String[] args) throws InterruptedException {


        TaskScheduler taskScheduler = new TaskScheduler();

        long curTime = System.currentTimeMillis();

        taskScheduler.addTask("test1", true, 1000, curTime + 1000, () -> {
            System.out.println("执行任务1111，" + System.currentTimeMillis());
        });

        taskScheduler.addTask("test2", true, 2000, curTime + 5000, () -> {
            System.out.println("执行任务2222，" + System.currentTimeMillis());
        });

        taskScheduler.run();

        taskScheduler.schedule(curTime + 10000);

        Thread.sleep(10000);

        taskScheduler.cancel("test1");

    }


}
