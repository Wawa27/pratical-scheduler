package task;

public class Task {
    private final int length;
    private final int weight;
    private final int limitTime;

    /**
     * Creates a new Task
     * @param startTime The start time of the task
     * @param weight The weight of the task
     * @param limitTime The time limit of the task, should not be lesser than start time
     */
    public Task(int startTime, int weight, int limitTime) {
        this.length = startTime;
        this.weight = weight;
        this.limitTime = limitTime;
    }

    public int getLength() {
        return length;
    }

    public int getWeight() {
        return weight;
    }

    public int getLimitTime() {
        return limitTime;
    }

    @Override
    public String toString() {
        return "task.Task{" +
                "length=" + length +
                ", weight=" + weight +
                ", limitTime=" + limitTime +
                '}';
    }
}
