import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        DatabaseSchema databaseSchema = new DatabaseSchema();
        UserRepository userRepository = new UserRepository();
        TaskRepository taskRepository = new TaskRepository();

        Scanner scanner = new Scanner(System.in);

        try
        {
            databaseSchema.createUsersTable();
            databaseSchema.createTasksTable();

            boolean applicationRunning = true;

            while (applicationRunning)
            {
                System.out.println();
                System.out.println("===== TASK MANAGER =====");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");

                String choice = scanner.nextLine();

                switch (choice)
                {
                    case "1":
                        registerUser(scanner, userRepository);
                        break;

                    case "2":
                        User loggedInUser =
                                loginUser(scanner, userRepository);

                        if (loggedInUser != null)
                        {
                            taskMenu(
                                    scanner,
                                    taskRepository,
                                    loggedInUser
                            );
                        }

                        break;

                    case "3":
                        applicationRunning = false;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println(
                                "Invalid option. Please choose 1, 2 or 3."
                        );
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println(
                    "A database error occurred: " + e.getMessage()
            );
        }
        finally
        {
            scanner.close();
        }
    }

    // =========================
    // REGISTRATION
    // =========================

    public static void registerUser(
            Scanner scanner,
            UserRepository userRepository
    )
    {
        System.out.println();
        System.out.println("===== REGISTER =====");

        System.out.print("Enter username: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty())
        {
            System.out.println("Username cannot be empty.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (password.isEmpty())
        {
            System.out.println("Password cannot be empty.");
            return;
        }

        try
        {
            User existingUser =
                    userRepository.findUserByName(name);

            if (existingUser != null)
            {
                System.out.println(
                        "Username already exists. Please choose another."
                );
                return;
            }

            User newUser = new User(0, name, password);

            userRepository.saveUser(newUser);

            System.out.println(
                    "Registration successful!"
            );
        }
        catch (SQLException e)
        {
            System.out.println(
                    "Could not register user: "
                            + e.getMessage()
            );
        }
    }

    // =========================
    // LOGIN
    // =========================

    public static User loginUser(
            Scanner scanner,
            UserRepository userRepository
    )
    {
        System.out.println();
        System.out.println("===== LOGIN =====");

        System.out.print("Enter username: ");
        String loginName = scanner.nextLine().trim();

        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        if (loginName.isEmpty() || loginPassword.isEmpty())
        {
            System.out.println(
                    "Username and password cannot be empty."
            );
            return null;
        }

        try
        {
            User foundUser =
                    userRepository.findUserByName(loginName);

            if (foundUser != null &&
                    foundUser.getPassword().equals(loginPassword))
            {
                System.out.println();
                System.out.println("Login successful!");
                System.out.println(
                        "Welcome, " + foundUser.getName()
                );

                return foundUser;
            }

            System.out.println(
                    "Incorrect username or password."
            );
        }
        catch (SQLException e)
        {
            System.out.println(
                    "Could not login: " + e.getMessage()
            );
        }

        return null;
    }

    // =========================
    // TASK MENU
    // =========================

    public static void taskMenu(
            Scanner scanner,
            TaskRepository taskRepository,
            User loggedInUser
    )
    {
        boolean taskMenuRunning = true;

        while (taskMenuRunning)
        {
            System.out.println();
            System.out.println("===== TASK MANAGER =====");
            System.out.println("1. Create task");
            System.out.println("2. View my tasks");
            System.out.println("3. Complete task");
            System.out.println("4. Delete task");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            String taskChoice = scanner.nextLine();

            try
            {
                switch (taskChoice)
                {
                    case "1":
                        createTask(
                                scanner,
                                taskRepository,
                                loggedInUser
                        );
                        break;

                    case "2":
                        viewTasks(
                                taskRepository,
                                loggedInUser
                        );
                        break;

                    case "3":
                        completeTask(
                                scanner,
                                taskRepository,
                                loggedInUser
                        );
                        break;

                    case "4":
                        deleteTask(
                                scanner,
                                taskRepository,
                                loggedInUser
                        );
                        break;

                    case "5":
                        taskMenuRunning = false;
                        System.out.println(
                                "Logged out successfully."
                        );
                        break;

                    default:
                        System.out.println(
                                "Invalid option. Please choose 1-5."
                        );
                }
            }
            catch (SQLException e)
            {
                System.out.println(
                        "A database error occurred: "
                                + e.getMessage()
                );
            }
        }
    }

    // =========================
    // CREATE TASK
    // =========================

    public static void createTask(
            Scanner scanner,
            TaskRepository taskRepository,
            User loggedInUser
    ) throws SQLException
    {
        System.out.println();
        System.out.println("===== CREATE TASK =====");

        System.out.print("Enter task title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty())
        {
            System.out.println(
                    "Task title cannot be empty."
            );
            return;
        }

        System.out.print("Enter task description: ");
        String description = scanner.nextLine().trim();

        if (description.isEmpty())
        {
            System.out.println(
                    "Task description cannot be empty."
            );
            return;
        }

        Task task = new Task(
                0,
                title,
                description,
                loggedInUser.getId()
        );

        taskRepository.saveTask(task);

        System.out.println(
                "Task created successfully!"
        );
    }

    // =========================
    // VIEW TASKS
    // =========================

    public static void viewTasks(
            TaskRepository taskRepository,
            User loggedInUser
    ) throws SQLException
    {
        List<Task> tasks =
                taskRepository.findTasksByUserId(
                        loggedInUser.getId()
                );

        System.out.println();
        System.out.println("===== YOUR TASKS =====");

        if (tasks.isEmpty())
        {
            System.out.println(
                    "You have no tasks."
            );
            return;
        }

        for (Task task : tasks)
        {
            System.out.println(
                    "ID: " + task.getId()
                            + " | Title: " + task.getTitle()
                            + " | Description: " + task.getDescription()
                            + " | Completed: " + task.isCompleted()
            );
        }
    }

    // =========================
    // COMPLETE TASK
    // =========================

    public static void completeTask(
            Scanner scanner,
            TaskRepository taskRepository,
            User loggedInUser
    ) throws SQLException
    {
        System.out.print(
                "Enter task ID to complete: "
        );

        String input = scanner.nextLine();

        int taskId;

        try
        {
            taskId = Integer.parseInt(input);
        }
        catch (NumberFormatException e)
        {
            System.out.println(
                    "Invalid task ID. Please enter a number."
            );
            return;
        }

        boolean completed =
                taskRepository.completeTask(
                        taskId,
                        loggedInUser.getId()
                );

        if (completed)
        {
            System.out.println(
                    "Task completed successfully."
            );
        }
        else
        {
            System.out.println(
                    "Task not found."
            );
        }
    }

    // =========================
    // DELETE TASK
    // =========================

    public static void deleteTask(
            Scanner scanner,
            TaskRepository taskRepository,
            User loggedInUser
    ) throws SQLException
    {
        System.out.print(
                "Enter task ID to delete: "
        );

        String input = scanner.nextLine();

        int taskId;

        try
        {
            taskId = Integer.parseInt(input);
        }
        catch (NumberFormatException e)
        {
            System.out.println(
                    "Invalid task ID. Please enter a number."
            );
            return;
        }

        boolean deleted =
                taskRepository.deleteTask(
                        taskId,
                        loggedInUser.getId()
                );

        if (deleted)
        {
            System.out.println(
                    "Task deleted successfully."
            );
        }
        else
        {
            System.out.println(
                    "Task not found."
            );
        }
    }
}