package schedulers;

import task.Task;

import java.util.List;

public class FIFOScheduler implements Scheduler {

    /**
     * From <a href=https://en.wikipedia.org/wiki/Scheduling_(computing)#First_come,_first_served>Wikipedia</a> :
     * <br>
     * First in, first out (FIFO), also known as first come, first served (FCFS),
     * is the simplest scheduling algorithm.
     * FIFO simply queues processes in the order that they arrive in the ready queue.
     */
    public FIFOScheduler() {
        super();
    }

    @Override
    public void scheduleTasks(List<Task> scheduledTasks) { }
}
