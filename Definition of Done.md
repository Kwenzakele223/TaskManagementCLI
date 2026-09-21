# Definition of Done

Project 2 will be considered complete when the following requirements have been met:

## User Management

* [ ] A new user can register successfully.
* [ ] The system prevents duplicate usernames.
* [ ] A registered user can log in successfully.
* [ ] Incorrect login details are handled correctly.
* [ ] Empty required user information is handled correctly.

## Task Management

* [ ] A logged-in user can create a task.
* [ ] A user can view their tasks.
* [ ] A user can complete a task.
* [ ] A user can delete a task.
* [ ] A user can only manage their own tasks.
* [ ] Task completion status is saved correctly.

## Database

* [ ] The SQLite database is created and connected successfully.
* [ ] The `users` table works correctly.
* [ ] The `tasks` table works correctly.
* [ ] Tasks are linked to users using `user_id`.
* [ ] Users and tasks are stored correctly.
* [ ] Database operations work without errors during normal use.

## Error Handling

* [ ] Invalid menu options are handled.
* [ ] Non-numeric input is handled where numbers are required.
* [ ] Invalid task IDs are handled.
* [ ] Empty input is handled.
* [ ] Duplicate usernames are handled.
* [ ] Database errors are handled without crashing the application.

## Code Structure

* [ ] Each class has a clear responsibility.
* [ ] `User` represents user information.
* [ ] `Task` represents task information.
* [ ] `DatabaseSchema` manages the database setup.
* [ ] `UserRepository` manages user database operations.
* [ ] `TaskRepository` manages task database operations.
* [ ] `Main` manages the CLI and application flow.

## Testing

* [ ] Registration has been tested.
* [ ] Login has been tested.
* [ ] Creating a task has been tested.
* [ ] Viewing tasks has been tested.
* [ ] Completing a task has been tested.
* [ ] Deleting a task has been tested.
* [ ] Invalid input has been tested.
* [ ] Duplicate usernames have been tested.
* [ ] Empty input has been tested.

## Final Completion

Project 2 is considered complete when the main features work correctly, the data is stored in SQLite, errors are handled properly, and the application has been tested successfully.
