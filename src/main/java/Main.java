import schedulers.FIFOScheduler;
import schedulers.RandomScheduler;
import schedulers.RoundRobinScheduler;
import schedulers.Scheduler;
import task.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Test different scheduling algorithms qualities from samples
     */
    public static void main(String[] args) throws IOException {
        List<Scheduler> schedulers = new ArrayList<>();

        schedulers.add(new FIFOScheduler());
        schedulers.add(new RandomScheduler());
        schedulers.add(new RoundRobinScheduler());

        for (String pathname : args) {
            System.out.println("Scheduling tasks from name: " + pathname);
            System.out.println();

            List<Task> initialTasks = getTasksFromFile(pathname);

            for (Scheduler scheduler : schedulers) {
                // Make a copy of the initial tasks for the same configuration
                List<Task> tasks = new ArrayList<>(initialTasks);
                System.out.println("Scheduler: " + scheduler.getClass().getSimpleName());

                scheduler.scheduleTasks(tasks);
                System.out.println("Quality: " + computeSchedulerQuality(tasks));

                System.out.println();
            }
        }
    }

    /**
     * Compute the scheduler quality, this is done by making the sum of the tasks which exceeded the time limit
     * times their weight
     *
     * @param scheduledTasks The scheduled tasks result of a scheduler
     * @return A quality, lower is better
     */
    public static int computeSchedulerQuality(List<Task> scheduledTasks) {
        int quality = 0;
        int currentTime = 0;

        for (Task task : scheduledTasks) {
            currentTime += task.getLength();
            // Only add to quality if the current time exceeded the time limit
            quality += Math.max(currentTime - task.getLimitTime(), 0) * task.getWeight();
        }
        return quality;
    }

    /**
     * Retrieve a list of tasks from a file,
     * The file should have the following structure
     * [LENGTH] [WEIGHT] [TIME LIMIT]
     *
     * @param pathname The absolute path of the tasks file
     * @return The list of tasks of the file
     * @throws IOException When the specified file was not found
     */
    public static List<Task> getTasksFromFile(String pathname) throws IOException {
        List<Task> tasks = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathname));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lineData = line.split(" ");
            tasks.add(new Task(
                    Integer.parseInt(lineData[0]),
                    Integer.parseInt(lineData[1]),
                    Integer.parseInt(lineData[2])
            ));
        }
        return tasks;
    }
}
