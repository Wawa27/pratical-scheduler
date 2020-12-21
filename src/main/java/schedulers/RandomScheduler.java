package schedulers;

import task.Task;

import java.util.Collections;
import java.util.List;

public class RandomScheduler implements Scheduler {

    /**
     * Random scheduler using the {@link Collections) shuffle method};
     */
    public RandomScheduler() {
        super();
    }

    @Override
    public void scheduleTasks(List<Task> tasks) {
        Collections.shuffle(tasks);
    }
}
