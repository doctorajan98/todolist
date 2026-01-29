package org.doctorajan;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        TodoListManager<String> todoList = new TodoListManager<>();
        String command;
        String trimmedCommand;

        do {
            System.out.println("\nEnter a command (add/view/remove/complete/exit): ");
            command = scanner.nextLine();
            trimmedCommand = command.replaceAll("\\s+", "");

            switch (trimmedCommand) {
                case "add":
                    System.out.println("Enter a task: ");
                    todoList.addTask(scanner.nextLine());
                    break;
                case "view":
                    todoList.viewTasks();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    break;
                case "remove":
                    System.out.println("Enter the number of the task to remove: ");
                    int removeTaskNumber = scanner.nextInt();
                    scanner.nextLine();
                    todoList.removeTask(removeTaskNumber);
                    break;
                case "complete":
                    System.out.println("Enter the number of the task to complete: ");
                    int completeTaskNumber = scanner.nextInt();
                    scanner.nextLine();
                    todoList.completeTask(completeTaskNumber);
                    break;
                default:
                    System.out.println("Invalid command");
            }
        } while (!trimmedCommand.equals("exit"));

        scanner.close();
    }
}
