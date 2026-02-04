package org.doctorajan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListGUI {
    private TodoListManager<Task> toDoListManager;
    private JTextArea taskArea;
    private JTextField taskInput;
    private JTextField pritorityInput;

    public ToDoListGUI() {
        toDoListManager = new TodoListManager<>();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("To-Do List Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        taskArea = new JTextArea();
        taskArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taskArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        taskInput = new JTextField(20);
        pritorityInput = new JTextField(3);
        JButton addButton = new JButton("Add");
        JButton viewButton = new JButton("View");
        JButton removeButton = new JButton("Remove");

        inputPanel.add(new JLabel("Task: "));
        inputPanel.add(taskInput);
        inputPanel.add(new JLabel("Priority (1-High, 2-Medium, 3-Low): "));
        inputPanel.add(pritorityInput);
        inputPanel.add(addButton);
        inputPanel.add(viewButton);
        inputPanel.add(removeButton);

        frame.add(inputPanel, BorderLayout.SOUTH);

        // AddTask action listener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        // view action listener
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTasks();
            }
        });

        // remove action listener
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTask();
            }
        });

        frame.setVisible(true);
    }

    private void addTask() {
        toDoListManager.addTask(taskInput.getText(), Integer.parseInt(pritorityInput.getText()));
        resetInputFields();
    }

    private void viewTasks() {
        String tasks = toDoListManager.viewTasks();
        taskArea.setText(tasks);
    }

    private void removeTask() {
        // Implement remove task functionality
    }

    // Reset Input Fields
    private void resetInputFields() {
        taskInput.setText("");
        pritorityInput.setText("");
    }
}
