# Functional Requirements

## 1. User Registration

* The system must allow a new user to register.
* The user must provide a username and password.
* The system must check if the username already exists.
* The system must not allow duplicate usernames.
* The system must save the new user in the database.
* The system must show a message when registration is successful.
* The system must show an error message when registration fails.

## 2. User Login

* The system must allow a registered user to log in.
* The user must enter their username and password.
* The system must check the details against the database.
* If the details are correct, the user must be logged in.
* If the details are incorrect, the system must show an error message.
* The system must identify the logged-in user.

## 3. Create Task

* A logged-in user must be able to create a task.
* The user must provide the task information.
* The system must save the task in the database.
* The task must be linked to the logged-in user.
* The system must show a message when the task is created successfully.

## 4. View Tasks

* A logged-in user must be able to view their tasks.
* The system must display the user's tasks.
* The system must display the task information.
* The system must show whether a task is completed or not completed.
* A user must not see another user's tasks.

## 5. Complete Task

* A logged-in user must be able to complete a task.
* The user must select the task they want to complete.
* The system must update the task's status to completed.
* The system must save the updated status in the database.
* The system must show a message when the task is completed.
* If the task does not exist, the system must show an error message.

## 6. Delete Task

* A logged-in user must be able to delete a task.
* The user must select the task they want to delete.
* The system must remove the task from the database.
* The system must show a message when the task is deleted.
* If the task does not exist, the system must show an error message.

## 7. User-Specific Tasks

* Every task must be linked to a user.
* The system must use the user's ID to identify their tasks.
* A user must only be able to manage their own tasks.
* The system must keep the relationship between users and tasks in the database.

## 8. Input Validation

* The system must check user input before processing it.
* The system must handle empty required fields.
* The system must handle non-numeric input when a number is required.
* The system must handle invalid menu options.
* Invalid input must not cause the application to crash.

## 9. Database Management

* The system must connect to the SQLite database using JDBC.
* The system must create the required database tables if they do not exist.
* The system must store users in the `users` table.
* The system must store tasks in the `tasks` table.
* The `tasks` table must be connected to the `users` table using `user_id`.
* The system must be able to insert, retrieve, update, and delete data.

## 10. Application Exit

* The user must be able to exit the application.
* The system must close the application without crashing.
* Database resources must be closed properly when they are no longer needed.
