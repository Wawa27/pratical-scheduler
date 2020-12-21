package schedulers;

import task.Task;

import java.util.ArrayList;
import java.util.List;

public class RoundRobinScheduler implements Scheduler {

    /**
     * From <a href=https://en.wikipedia.org/wiki/Scheduling_(computing)#Fixed_priority_pre-emptive_scheduling>Wikipedia</a> :
     * <br>
     * The scheduler assigns a fixed time unit per process, and cycles through them.
     * If process completes within that time-slice it gets terminated
     * otherwise it is rescheduled after giving a chance to all other processes.
     */
    public RoundRobinScheduler() {
        super();
    }

    @Override
    public void scheduleTasks(List<Task> scheduledTasks) {
        int currentTime = 0;
        List<Task> tasks = new ArrayList<>(scheduledTasks);
        scheduledTasks.clear();

        // Only add tasks that don't exceed the time limit
        for (int i = tasks.size() - 1; i > 0; i--) {
            Task task = tasks.get(i);
            if (task.getLimitTime() > task.getLength() + currentTime) {
                scheduledTasks.add(task);
                tasks.remove(task);
            }
        }

        // Add all the remaining tasks
        for (Task task : tasks) {
            if (task.getLength() + currentTime > task.getLimitTime()) {
                scheduledTasks.add(task);
            }
        }
    }
}
