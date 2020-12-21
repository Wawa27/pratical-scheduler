package schedulers;

import task.Task;

import java.util.List;

public interface Scheduler {

    /**
     * From <a href=https://en.wikipedia.org/wiki/Scheduling_(computing)>Wikipedia</a> :
     * <br>
     * Scheduling is the method by which work is assigned to resources that complete the work.
     * The work may be virtual computation elements such as threads, processes or data flows,
     * which are in turn scheduled onto hardware resources such as processors, network links or expansion cards.
     */
    void scheduleTasks(List<Task> tasks);
}
