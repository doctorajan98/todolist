package org.doctorajan;
import java.util.ArrayList;
import java.io.*;

public class TodoListManager<T> {
    private ArrayList<T> tasks;

    public TodoListManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(T task) {
        tasks.add(task);
        System.out.println("Task added successfully");
    }

    public void saveTasksToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName))
        {
            for (T task : tasks) {
                writer.write(task.toString() +  "\n");
            }
            System.out.println("Tasks saved successfully");
        }
        catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display");
        }
        else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ": " + tasks.get(i));
            }
        }
    }

    public void loadTasksFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String task;
            while ((task = reader.readLine()) != null) {
                addTask((T) task); // Add each task to the list
                System.out.println("Task loaded: " + task);
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    public void removeTask(int index) throws TaskNotFoundException {
        if (index < 1 || index > tasks.size()) {
            throw new TaskNotFoundException("Invalid task number.");
        }
        else {
            System.out.println("Task removed successfully");
            tasks.remove(index - 1);
        }
    }

    public void completeTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            System.out.println("Task completed successfully");
            tasks.remove(index - 1);
        }
        else {
            System.out.println("Invalid task number.");
        }
    }
}
