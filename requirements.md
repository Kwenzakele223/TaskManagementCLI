# REQUIREMENTS ANALYSIS

## TASK MANAGEMENT CLI

### 1. Overview

The Task Management CLI is a terminal-based application that allows users to manage their daily tasks.

The application will allow users to:

1. Create tasks.
2. View tasks and their completion status.
3. Complete tasks.
4. Delete individual tasks.
5. Delete all tasks.
6. Exit the application.
7. Temporarily save tasks using JSON so that tasks are not lost when the application is closed and reopened.

The application will be simple to use and will provide clear messages when the user enters invalid information or tries to perform an action on a task that does not exist.

---

# 2. Problem Statement

People may use paper or other manual methods to manage their daily tasks. These tasks can be misplaced, lost, damaged, or accidentally thrown away.

This application provides a digital way to manage daily tasks through the terminal. It allows users to create, view, complete, and delete tasks while temporarily storing the task information using JSON.

---

# 3. Target Users

The application is intended for people who want to organize and manage their daily activities.

Potential users include:

* Students
* Workers
* People managing personal daily activities

The application should provide a simple way to keep track of tasks and their completion status.

---

# 4. Features

The application must provide the following features:

### 4.1 Create Task

The user must be able to create a new task.

The user will enter the task they want to add to their task list.

Example:

```text
Enter task name: Study Java

Task created successfully.
```

The new task must initially have the status:

```text
Not Completed
```

---

### 4.2 View Tasks

The user must be able to view all tasks currently stored in the application.

Each task must display:

* Task ID or identifier
* Task name
* Task status

Example:

```text
===== MY TASKS =====

1. Study Java
   Status: Not Completed

2. Clean the room
   St
```
