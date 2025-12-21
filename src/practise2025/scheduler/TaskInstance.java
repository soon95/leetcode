package practise2025.scheduler;

public class TaskInstance {

    String taskName;
    boolean isPeriod;
    int period;
    long nextTime;
    Runnable task;
    boolean cancelled;


    public TaskInstance(String taskName, boolean isPeriod, int period, long nextTime, Runnable task) {
        this.taskName = taskName;
        this.isPeriod = isPeriod;
        this.period = period;
        this.nextTime = nextTime;
        this.task = task;
    }

    public void run() {
        if (cancelled) {
            return;
        }
        this.task.run();
    }

    public void updateNextTime() {
        if (!isPeriod) {
            return;
        }

        this.nextTime += this.period;
    }


}
