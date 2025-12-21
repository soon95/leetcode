package practise2025.scheduler;

public class ScheduledTask {

    String taskName;

    long startTime;

    TaskInstance taskInstance;

    public ScheduledTask(String taskName, boolean isPeriod, int period, long startTime, Runnable task) {
        this.taskName = taskName;
        this.startTime = startTime;
        this.taskInstance = new TaskInstance(taskName, isPeriod, period, startTime, task);
    }

}
