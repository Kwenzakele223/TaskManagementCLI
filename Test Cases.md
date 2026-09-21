# Test Cases

The following test cases are used to check that the Task Management CLI works correctly.

| Test | What is Being Tested        | Input / Action                         | Expected Result                                        |
| ---- | --------------------------- | -------------------------------------- | ------------------------------------------------------ |
| TC01 | User Registration           | Enter a new username and password      | User is registered successfully                        |
| TC02 | Duplicate Username          | Register using an existing username    | System shows an error and does not create another user |
| TC03 | Empty Username              | Leave the username empty               | System shows an error message                          |
| TC04 | User Login                  | Enter correct username and password    | User is logged in successfully                         |
| TC05 | Incorrect Login             | Enter incorrect login details          | System shows an error message                          |
| TC06 | Create Task                 | Enter valid task information           | Task is created and saved in the database              |
| TC07 | View Tasks                  | Select the view tasks option           | User's tasks are displayed                             |
| TC08 | User-Specific Tasks         | Log in as a different user             | The user only sees their own tasks                     |
| TC09 | Complete Task               | Select a valid task                    | Task status changes to completed                       |
| TC10 | Complete Invalid Task       | Enter a task ID that does not exist    | System shows an error message                          |
| TC11 | Delete Task                 | Select a valid task                    | Task is deleted from the database                      |
| TC12 | Delete Invalid Task         | Enter a task ID that does not exist    | System shows an error message                          |
| TC13 | Invalid Menu Option         | Enter `99`                             | System shows an invalid option message                 |
| TC14 | Invalid Task ID             | Enter `abc` where a number is required | System handles the invalid input without crashing      |
| TC15 | Database Persistence        | Close and reopen the application       | Previously saved users and tasks are still available   |
| TC16 | Task Ownership              | Try to access another user's task      | User cannot manage another user's task                 |
| TC17 | Task Completion Persistence | Complete a task and view it again      | Task remains marked as completed                       |
| TC18 | Application Exit            | Select the exit option                 | Application closes correctly                           |

## Test Result

The main Project 2 functionality was tested through the CLI.

The following areas were tested successfully:

* User registration
* User login
* Duplicate username handling
* Empty input handling
* Task creation
* Viewing tasks
* Completing tasks
* Deleting tasks
* Invalid task IDs
* Invalid menu options
* User-specific tasks
* Database storage
