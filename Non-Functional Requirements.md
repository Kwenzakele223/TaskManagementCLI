# Non-Functional Requirements

## 1. Easy to Use

* The application must be easy to use in the terminal.
* The menus must be clear.
* The application must give clear instructions.
* Error messages must be easy to understand.

## 2. Performance

* The application should respond quickly to the user.
* Login and registration should work without unnecessary delays.
* Creating, viewing, completing, and deleting tasks should be quick.
* Database operations should work efficiently.

## 3. Reliability

* The application must not crash when the user enters invalid information.
* Invalid menu options must be handled.
* Invalid task IDs must be handled.
* Empty required information must be handled.
* Database errors must be handled properly.

## 4. Data Accuracy

* Each user must have a unique username.
* Each task must belong to the correct user.
* Users must only see and manage their own tasks.
* Completing a task must update its status correctly.
* Deleting a task must delete the correct task.
* User and task information must be stored correctly in the database.

## 5. Security

* Users must log in before managing their tasks.
* Users must only manage their own tasks.
* User input must be checked before it is processed.
* `PreparedStatement` must be used for database queries that use user input.

## 6. Maintainability

* The code must be organised into separate classes.
* Each class must have a clear responsibility.
* The code should be easy to understand and change.

The project uses separate classes for:

* `User`
* `Task`
* `DatabaseSchema`
* `UserRepository`
* `TaskRepository`
* `Main`

## 7. Testing

* The application must be tested to make sure its features work correctly.
* Registration and login must be tested.
* Creating, viewing, completing, and deleting tasks must be tested.
* Invalid input must be tested.
* Duplicate usernames must be tested.
* Database operations must be tested.

## 8. Error Handling

* The application must show a clear message when an error occurs.
* The application must handle invalid menu options.
* The application must handle non-numeric input.
* The application must handle empty input.
* The application must handle users or tasks that do not exist.
* The application must handle database errors without crashing.

## 9. Data Storage

* User information must be stored in the SQLite database.
* Task information must be stored in the SQLite database.
* Task completion status must be saved.
* Tasks must remain connected to the correct user.
* Data must still be available when the application is started again.

## 10. Compatibility

The application must work with:

* Java
* Maven
* JDBC
* SQLite
* Terminal/Command Line
* JUnit for testing

## 11. Future Growth

The project should be designed so that new features can be added later.

Possible future features include:

* More task features.
* More users.
* A larger database.
* A web version of the application.

These features are **not part of the current Project 2**.
