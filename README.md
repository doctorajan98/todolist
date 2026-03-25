# ToDoList — Java Task Management Application

A task management application written in Java that lets users create, manage, and persist to-do items with priority levels. It offers both a CLI and a basic Swing GUI.

---

## Architecture

**Design Pattern: Simple Layered (MVC-lite)**

| Layer | Class | Role |
|---|---|---|
| Model | `Task.java` | Task data (description + priority 1–3) |
| Business Logic | `TodoListManager.java` | Generic `<T>` class managing the task list, file I/O, add/remove/complete |
| CLI View | `Main.java` | Interactive command loop (add/view/remove/complete/save/load/exit) |
| GUI View | `ToDoListGUI.java` | Swing-based window (400×400) with input fields and task display |
| Exception | `TaskNotFoundException.java` | Thrown when an invalid task index is accessed |
| Tests | `ToDoListTest.java` | JUnit tests for add, remove, and complete operations |

> `Animal.java` and `BankAccount.java` are unintegrated practice/learning classes.

---

## Project Structure

```
ToDoList/
├── src/
│   └── main/java/org/doctorajan/
│       ├── Main.java
│       ├── Task.java
│       ├── TaskNotFoundException.java
│       ├── TodoListManager.java
│       ├── ToDoListGUI.java
│       ├── ToDoListTest.java
│       ├── Animal.java
│       └── BankAccount.java
├── newTask        (sample task data file)
├── output         (output from a previous run)
├── pom.xml        (Maven build config)
└── README.md
```

---

## Technologies Used

| Tool / Library | Purpose |
|---|---|
| **Java 25** | Language |
| **Maven** | Build tool |
| **Swing (javax.swing)** | GUI framework |
| **JUnit (classic + Jupiter)** | Unit testing |
| **IntelliJ IDEA** | IDE |

---

## Features

### CLI (fully functional)
- `add` — Add a task with a priority level (1=High, 2=Medium, 3=Low)
- `view` — List all current tasks
- `remove` — Remove a task by index
- `complete` — Mark a task as complete (removes it)
- `save` — Save tasks to a file
- `load` — Load tasks from a file
- `exit` — Quit the application

### GUI (partially implemented)
- **Add** — Add a task with priority via text fields
- **View** — Display all tasks in a scrollable text area
- **Remove** — Button present but not yet implemented

---

## Data Persistence

Tasks are saved/loaded as plain text files using the format:

```
[1] Buy groceries
[2] Call dentist
[3] Read a book
```

Parsed via regex `\[(\d+)]\s*(.*)` — priority number in brackets, followed by the task description.

---

## Tests

Located in `ToDoListTest.java`, using JUnit with `@Before` / `@Test` annotations.

| Test | Verifies |
|---|---|
| `testAddTask()` | Task is added to the list |
| `testRemoveTask()` | Task is removed by index |
| `testCompleteTask()` | Task is marked complete and removed |

> Current coverage is basic happy-path only. No edge case, file I/O, or GUI tests.

---

## Current Status

| Area | Status |
|---|---|
| CLI | Fully functional |
| GUI | Partially implemented (Remove not wired up) |
| Tests | Basic coverage |
| Persistence | Working (plain text file format) |
