package org.doctorajan;
import java.util.ArrayList;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TodoListManager<T> {
    private ArrayList<T> tasks;

    public TodoListManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description, int priority) {
        Task newTask = new Task(description, priority);
        tasks.add((T) newTask);
        System.out.println("Task added: " + newTask);
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

    public ArrayList<T> getTasks() {
        return tasks;
    }

    public void loadTasksFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String task;
            while ((task = reader.readLine()) != null) {
                String input = task;
                Pattern pattern = Pattern.compile("\\[(\\d+)]\\s*(.*)");

                Matcher matcher = pattern.matcher(input);

                if (matcher.matches()) {
                    int value = Integer.parseInt(matcher.group(1));
                    String description = matcher.group(2);

                    Task newTask = new Task(description, value);
                    tasks.add((T) newTask); // Add each task to the list
                    System.out.println("Task loaded: " + task);
                }
                else {
                    System.out.println("Invalid task format: " + task);
                }
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
