# ACCEPTANCE CRITERIA

## 1. Create a Task

**Given** the application is running,
**When** the user chooses **Create Task**,
**Then** the application must allow the user to enter a task name.

**And** the task must be added to the task list.

**And** the task must initially have the status **Not Completed**.

**And** the task must be saved to the JSON file.

---

## 2. View Tasks

**Given** the application contains tasks,
**When** the user chooses **View Tasks**,
**Then** the application must display all tasks in the task list.

**And** each task must display its name.

**And** each task must display its current status.

**And** the user must be able to see whether each task is **Completed** or **Not Completed**.

---

## 3. Delete a Task

**Given** the application contains tasks,
**When** the user chooses **Delete Task**,
**Then** the application must display the available tasks.

**And** the user must be able to select a task to delete.

**And** the selected task must be removed from the task list.

**And** the deleted task must no longer appear when the user views the tasks.

**And** the updated task list must be saved to the JSON file.

**If** the user tries to delete a task that does not exist,
**Then** the application must display:

```text
Task {name} not found.
```

---

## 4. Complete a Task

**Given** the application contains a task that is not completed,
**When** the user chooses **Complete Task**,
**Then** the application must allow the user to select a task.

**And** the selected task's status must change from **Not Completed** to **Completed**.

**And** the updated status must be saved to the JSON file.

**And** when the user views the tasks, the task must show **Completed**.

**If** the user tries to complete a task that does not exist,
**Then** the application must display:

```text
Task {name} not found.
```

---

## 5. Exit the Application

**Given** the application is running,
**When** the user chooses **Exit**,
**Then** the application must save the current task data to the JSON file.

**And** the application must display:

```text
Task management CLI closed.
```

**And** the application must close.

---

## 6. Save Task Data

**Given** the user has created or changed tasks,
**When** the task information changes,
**Then** the application must save the updated task information to the JSON file.

**And** the JSON file must contain the task names and their completion statuses.

**When** the user starts the application again,
**Then** the application must load the previously saved tasks from the JSON file.

**And** the tasks must appear in the task list with their previously saved statuses.

---

## 7. Delete All Tasks

**Given** the application contains one or more tasks,
**When** the user chooses **Delete All Tasks**,
**Then** the application must ask the user to confirm the action.

**And** if the user confirms, all tasks must be removed from the task list.

**And** the updated empty task list must be saved to the JSON file.

**And** when the user chooses **View Tasks**, the application must show that there are no tasks.

**If** the user chooses not to confirm,
**Then** the tasks must remain unchanged.

---

## 8. Invalid Input

**Given** the application is running,
**When** the user enters an option that does not exist,
**Then** the application must display an appropriate error message.

For example:

```text
Option 9 not found.
```

**And** the application must allow the user to try again.

**When** the application expects a number and the user enters text,
**Then** the application must display:

```text
You can only use numbers.
```

**And** the application must not crash.

---

## 9. No Tasks Available

**Given** there are no tasks in the task list,
**When** the user chooses **View Tasks**,
**Then** the application must display:

```text
This view is empty. You must create a task.
```

**And** the user must be given an option to create a task or return to the home menu.
