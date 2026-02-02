package org.doctorajan;

public class Task {
    private String description;
    private int priority; // 1 = lowest, 2 = medium, 3 = highest

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "[" + priority + "] " + description; // Display priority with task
    }
}
